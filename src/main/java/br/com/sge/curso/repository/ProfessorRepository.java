package br.com.sge.curso.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.sge.curso.domain.Professor;

@Repository
@Transactional
public class ProfessorRepository extends BaseRepositoryImpl<Professor> {

	public ProfessorRepository() {
		super(Professor.class);
	}
	
	@Transactional(readOnly = true)
	public List<Professor> listar() {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("select new br.com.sge.curso.domain.Professor(u.id, u.nome, u.email) from Professor u");
		TypedQuery<Professor> query = session.createQuery(jpql.toString(), Professor.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Professor findOne(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Professor u left join fetch u.telefones t left join fetch u.enderecos e where u.id = :id");
		TypedQuery<Professor> query = session.createQuery(jpql.toString(), Professor.class);
		query.setParameter("id", id);
		return (Professor) query.getSingleResult();
	}
	
	@Transactional(readOnly = true)
	public List<Professor> buscar(Professor usuario){
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Professor u left join fetch u.telefones t where 1= 1");
		if(StringUtils.hasText(usuario.getNome())) {
			jpql.append(" and u.nome like :nome or u.sobrenome like :sobrenome ");
		}
		
		if(StringUtils.hasText(usuario.getEmail())) {
			jpql.append(" and u.email = :email ");
		}
		
		TypedQuery<Professor> query = session.createQuery(jpql.toString(), Professor.class);
		
		if(StringUtils.hasText(usuario.getNome())) {
			query.setParameter("nome", "%"+usuario.getNome()+"%");
			query.setParameter("sobrenome", "%"+usuario.getNome()+"%");
		}
		
		if(StringUtils.hasText(usuario.getEmail())) {
			query.setParameter("email", usuario.getEmail());
		}
		
		return query.getResultList();
	}

}
