package br.com.sge.curso.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Turno;

@Repository
@Transactional
public class TurnoRepository extends BaseRepositoryImpl<Turno> {

	public TurnoRepository() {
		super(Turno.class);
	}
	
	@Transactional(readOnly = true)
	public List<Turno> listar() {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Turno u");
		TypedQuery<Turno> query = session.createQuery(jpql.toString(), Turno.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Turno findOne(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Turno u where u.id = :id");
		TypedQuery<Turno> query = session.createQuery(jpql.toString(), Turno.class);
		query.setParameter("id", id);
		return (Turno) query.getSingleResult();
	}
	
	@Transactional(readOnly = true)
	public Turno findForName(String nome) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Turno u where u.nome = :nome");
		TypedQuery<Turno> query = session.createQuery(jpql.toString(), Turno.class);
		query.setParameter("nome", nome);
		return (Turno) query.getSingleResult();
	}

}
