package br.com.sge.curso.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Curso;

@Repository
@Transactional
public class CursoRepository extends BaseRepositoryImpl<Curso> {

	public CursoRepository() {
		super(Curso.class);
	}
	
	@Transactional(readOnly = true)
	public List<Curso> listar() {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Curso u");
		TypedQuery<Curso> query = session.createQuery(jpql.toString(), Curso.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Curso findOne(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Curso u where u.id = :id");
		TypedQuery<Curso> query = session.createQuery(jpql.toString(), Curso.class);
		query.setParameter("id", id);
		return (Curso) query.getSingleResult();
	}


}
