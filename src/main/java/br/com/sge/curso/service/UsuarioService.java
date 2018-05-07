package br.com.sge.curso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sge.curso.domain.Usuario;
import br.com.sge.curso.repository.UsuarioRepository;

@Service
public class UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioService(){
		
	}

	public Usuario login(String email, String senha) {
		return usuarioRepository.findByEmailAndPass(email, senha);
	}

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
