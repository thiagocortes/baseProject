package br.com.sge.curso.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Turma;

@Repository
@Transactional
public class TurmaRepository extends BaseRepositoryImpl<Turma> {

	public TurmaRepository() {
		super(Turma.class);
	}
	
	@Transactional(readOnly = true)
	public List<Turma> listar() {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Turma u");
		TypedQuery<Turma> query = session.createQuery(jpql.toString(), Turma.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Turma findOne(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Turma u left join fetch u.nivel n where u.id = :id");
		TypedQuery<Turma> query = session.createQuery(jpql.toString(), Turma.class);
		query.setParameter("id", id);
		return (Turma) query.getSingleResult();
	}

}
