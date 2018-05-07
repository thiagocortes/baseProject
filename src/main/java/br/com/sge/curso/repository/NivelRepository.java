package br.com.sge.curso.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Nivel;

@Repository
@Transactional
public class NivelRepository extends BaseRepositoryImpl<Nivel> {

	public NivelRepository() {
		super(Nivel.class);
	}
	
	@Transactional(readOnly = true)
	public List<Nivel> listar() {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Nivel u");
		TypedQuery<Nivel> query = session.createQuery(jpql.toString(), Nivel.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Nivel findOne(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Nivel u left join fetch u.curso c where u.id = :id");
		TypedQuery<Nivel> query = session.createQuery(jpql.toString(), Nivel.class);
		query.setParameter("id", id);
		return (Nivel) query.getSingleResult();
	}


}
