package br.com.sge.curso.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Turma;
import br.com.sge.curso.repository.TurmaRepository;

@Service
public class TurmaService extends BaseService<Turma> {
	
	@Autowired
	private TurmaRepository repository;
	
	public TurmaService(){
		
	}
	
	@Override
	public void delete(Long id) {
		Turma object = repository.findOne(id);
		repository.delete(object);
	}

	@Override
	public Turma get(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Turma> list(Integer page) {
		return null; 
	}

	@Override
	@Transactional
	public Turma save(Turma object) {
		preInsert(object);
		Turma funcionario = repository.save(object);
		posInsert(funcionario);
		return funcionario;
	}
	
	@Override
	@Transactional
	public Turma update(Turma object) {
		preUpdate(object);
		return repository.update(object);
	}
	
	@Override
	public Iterable<Turma> findAll() {
		return repository.findAll();
	}
	
	public List<Turma> listar() {
		return repository.listar();
	}
	
	private void preInsert(Turma object) {
		object.setDataCriacao(new Date());
		object.setDataAtualizacao(new Date());
	}
	
	private void posInsert(Turma object){
		
	}
	
	private void preUpdate(Turma object) {
		object.setDataAtualizacao(new Date());
	}
	
}
