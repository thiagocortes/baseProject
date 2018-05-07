package br.com.sge.curso.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.HorarioTurno;

@Repository
@Transactional
public class HorarioTurnoRepository extends BaseRepositoryImpl<HorarioTurno> {

	public HorarioTurnoRepository() {
		super(HorarioTurno.class);
	}
	
	@Transactional(readOnly = true)
	public List<HorarioTurno> listar() {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from HorarioTurno u");
		TypedQuery<HorarioTurno> query = session.createQuery(jpql.toString(), HorarioTurno.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public HorarioTurno findOne(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from HorarioTurno u where u.id = :id");
		TypedQuery<HorarioTurno> query = session.createQuery(jpql.toString(), HorarioTurno.class);
		query.setParameter("id", id);
		return (HorarioTurno) query.getSingleResult();
	}
	
	@Transactional(readOnly = true)
	public HorarioTurno findForHorarioTurno(HorarioTurno horario) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from HorarioTurno u where u.turno = :turno and u.horario = :horario");
		TypedQuery<HorarioTurno> query = session.createQuery(jpql.toString(), HorarioTurno.class);
		query.setParameter("turno", horario.getTurno());
		query.setParameter("horario", horario.getHorario());
		return (HorarioTurno) query.getSingleResult();
	}

}
