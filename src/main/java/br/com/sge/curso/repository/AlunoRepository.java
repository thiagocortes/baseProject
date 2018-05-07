package br.com.sge.curso.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import br.com.sge.curso.domain.Aluno;

@Repository
@Transactional
public class AlunoRepository extends BaseRepositoryImpl<Aluno> {

	public AlunoRepository() {
		super(Aluno.class);
	}
	
	@Transactional(readOnly = true)
	public List<Aluno> listar() {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("select new br.com.sge.curso.domain.Aluno(u.id, u.nome, u.email, u.matricula, u.dataNascimento) from Aluno u left join u.portadoresAutorizados r");
		TypedQuery<Aluno> query = session.createQuery(jpql.toString(), Aluno.class);
		return query.getResultList();
	}
	
	@Transactional(readOnly = true)
	public Aluno obterPorMatricula(String matricula) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("select u from Aluno u left join u.portadoresAutorizados r where matricula = :matricula");
		TypedQuery<Aluno> query = session.createQuery(jpql.toString(), Aluno.class);
		query.setParameter("matricula", matricula);
		return query.getSingleResult();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Aluno findOne(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("select u from Aluno u left join fetch u.portadoresAutorizados r where u.id = :id");
		TypedQuery<Aluno> query = session.createQuery(jpql.toString(), Aluno.class);
		query.setParameter("id", id);
		return (Aluno) query.getSingleResult();
	}

	@Transactional(readOnly = true)
	public List<Aluno> buscar(Aluno usuario){
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Aluno u left join fetch u.portadoresAutorizados r left join fetch u.telefones t where 1= 1");
		if(StringUtils.hasText(usuario.getNome())) {
			jpql.append(" and u.nome like :nome or u.sobrenome like :sobrenome ");
		}
		
		if(StringUtils.hasText(usuario.getMatricula())) {
			jpql.append(" and u.matricula = :matricula ");
		}
		
		if(StringUtils.hasText(usuario.getEmail())) {
			jpql.append(" and u.email = :email ");
		}
		
		TypedQuery<Aluno> query = session.createQuery(jpql.toString(), Aluno.class);
		
		if(StringUtils.hasText(usuario.getNome())) {
			query.setParameter("nome", "%"+usuario.getNome()+"%");
			query.setParameter("sobrenome", "%"+usuario.getNome()+"%");
		}
		
		if(StringUtils.hasText(usuario.getMatricula())) {
			query.setParameter("matricula", usuario.getMatricula());
		}
		
		if(StringUtils.hasText(usuario.getEmail())) {
			query.setParameter("email", usuario.getEmail());
		}
		
		return query.getResultList();
	}

}
