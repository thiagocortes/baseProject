package br.com.sge.curso.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Disciplina;

@Repository
@Transactional
public class DisciplinaRepository extends BaseRepositoryImpl<Disciplina> {

	public DisciplinaRepository() {
		super(Disciplina.class);
	}
	
	@Transactional(readOnly = true)
	public List<Disciplina> listar() {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Disciplina u");
		TypedQuery<Disciplina> query = session.createQuery(jpql.toString(), Disciplina.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Disciplina findOne(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Disciplina u where u.id = :id");
		TypedQuery<Disciplina> query = session.createQuery(jpql.toString(), Disciplina.class);
		query.setParameter("id", id);
		return (Disciplina) query.getSingleResult();
	}


}
