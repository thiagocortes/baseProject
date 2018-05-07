package br.com.sge.curso.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Funcionario;

@Repository
@Transactional
public class FuncionarioRepository extends BaseRepositoryImpl<Funcionario> {

	public FuncionarioRepository() {
		super(Funcionario.class);
	}
	
	@Transactional(readOnly = true)
	public List<Funcionario> listar() {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("select new br.com.sge.curso.domain.Funcionario(u.id, u.nome, u.email) from Funcionario u");
		TypedQuery<Funcionario> query = session.createQuery(jpql.toString(), Funcionario.class);
		return query.getResultList();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Funcionario findOne(Long id) {
		Session session = getSessionFactory().getCurrentSession();
		StringBuilder jpql = new StringBuilder("from Funcionario u left join fetch u.telefones t left join fetch u.enderecos e where u.id = :id");
		TypedQuery<Funcionario> query = session.createQuery(jpql.toString(), Funcionario.class);
		query.setParameter("id", id);
		return (Funcionario) query.getSingleResult();
	}


}
