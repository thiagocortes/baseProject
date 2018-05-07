package br.com.sge.curso.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Funcionario;
import br.com.sge.curso.repository.FuncionarioRepository;

@Service
public class FuncionarioService extends BaseService<Funcionario> {
	
	@Autowired
	private FuncionarioRepository repository;
	
	public FuncionarioService(){
		
	}
	
	@Override
	public void delete(Long id) {
		Funcionario object = repository.findOne(id);
		repository.delete(object);
	}

	@Override
	public Funcionario get(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Funcionario> list(Integer page) {
		return null; 
	}

	@Override
	@Transactional
	public Funcionario save(Funcionario object) {
		preInsert(object);
		Funcionario funcionario = repository.save(object);
		posInsert(funcionario);
		return funcionario;
	}
	
	@Override
	@Transactional
	public Funcionario update(Funcionario object) {
		preUpdate(object);
		return repository.update(object);
	}
	
	@Override
	public Iterable<Funcionario> findAll() {
		return repository.findAll();
	}
	
	public List<Funcionario> listar() {
		return repository.listar();
	}
	
	private void preInsert(Funcionario object) {
		object.setDataCriacao(new Date());
		object.setDataAtualizacao(new Date());
	}
	
	private void posInsert(Funcionario object){
		
	}
	
	private void preUpdate(Funcionario object) {
		object.setDataAtualizacao(new Date());
	}
	
}
