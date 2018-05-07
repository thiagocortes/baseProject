package br.com.sge.curso.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Disciplina;
import br.com.sge.curso.repository.DisciplinaRepository;

@Service
public class DisciplinaService extends BaseService<Disciplina> {
	
	@Autowired
	private DisciplinaRepository repository;
	
	public DisciplinaService(){
		
	}
	
	@Override
	public void delete(Long id) {
		Disciplina object = repository.findOne(id);
		repository.delete(object);
	}

	@Override
	public Disciplina get(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Disciplina> list(Integer page) {
		return null; 
	}

	@Override
	@Transactional
	public Disciplina save(Disciplina object) {
		preInsert(object);
		Disciplina funcionario = repository.save(object);
		posInsert(funcionario);
		return funcionario;
	}
	
	@Override
	@Transactional
	public Disciplina update(Disciplina object) {
		preUpdate(object);
		return repository.update(object);
	}
	
	@Override
	public Iterable<Disciplina> findAll() {
		return repository.findAll();
	}
	
	public List<Disciplina> listar() {
		return repository.listar();
	}
	
	private void preInsert(Disciplina object) {
		object.setDataCriacao(new Date());
		object.setDataAtualizacao(new Date());
	}
	
	private void posInsert(Disciplina object){
		
	}
	
	private void preUpdate(Disciplina object) {
		object.setDataAtualizacao(new Date());
	}
	
}
