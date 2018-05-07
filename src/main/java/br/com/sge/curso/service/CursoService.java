package br.com.sge.curso.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Curso;
import br.com.sge.curso.repository.CursoRepository;

@Service
public class CursoService extends BaseService<Curso> {
	
	@Autowired
	private CursoRepository repository;
	
	public CursoService(){
		
	}
	
	@Override
	public void delete(Long id) {
		Curso object = repository.findOne(id);
		repository.delete(object);
	}

	@Override
	public Curso get(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Curso> list(Integer page) {
		return null; 
	}

	@Override
	@Transactional
	public Curso save(Curso object) {
		preInsert(object);
		return repository.save(object);
	}
	
	@Override
	@Transactional
	public Curso update(Curso object) {
		preUpdate(object);
		return repository.update(object);
	}
	
	@Override
	public Iterable<Curso> findAll() {
		return repository.findAll();
	}
	
	public List<Curso> listar() {
		return repository.listar();
	}
	
	private void preInsert(Curso object) {
		object.setDataCriacao(new Date());
		object.setDataAtualizacao(new Date());
	}
	
	private void preUpdate(Curso object) {
		object.setDataAtualizacao(new Date());
	}
	
}
