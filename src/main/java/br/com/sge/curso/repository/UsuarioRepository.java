package br.com.sge.curso.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Usuario;

@Repository
@Transactional
public class UsuarioRepository extends BaseRepositoryImpl<Usuario> {
	
	@PersistenceContext
    private EntityManager entityManager;

	public UsuarioRepository() {
		super(Usuario.class);
	}
	
	@Transactional(readOnly = true)
	public Usuario findByEmailAndPass(String email, String senha){
		
		StringBuilder jpql = new StringBuilder("from Usuario u where email = :email and senha = :senha ");
		
		TypedQuery<Usuario> query = entityManager.createQuery(jpql.toString(), Usuario.class); 
		
		query.setParameter("email", email);
		query.setParameter("senha", senha);
		
		return (Usuario) query.getSingleResult();
		
	}

}
