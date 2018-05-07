package br.com.sge.curso.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Nivel;
import br.com.sge.curso.repository.NivelRepository;

@Service
public class NivelService extends BaseService<Nivel> {
	
	@Autowired
	private NivelRepository repository;
	
	public NivelService(){
		
	}
	
	@Override
	public void delete(Long id) {
		Nivel object = repository.findOne(id);
		repository.delete(object);
	}

	@Override
	public Nivel get(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Nivel> list(Integer page) {
		return null; 
	}

	@Override
	@Transactional
	public Nivel save(Nivel object) {
		preInsert(object);
		Nivel funcionario = repository.save(object);
		posInsert(funcionario);
		return funcionario;
	}
	
	@Override
	@Transactional
	public Nivel update(Nivel object) {
		preUpdate(object);
		return repository.update(object);
	}
	
	@Override
	public Iterable<Nivel> findAll() {
		return repository.findAll();
	}
	
	public List<Nivel> listar() {
		return repository.listar();
	}
	
	private void preInsert(Nivel object) {
		object.setDataCriacao(new Date());
		object.setDataAtualizacao(new Date());
	}
	
	private void posInsert(Nivel object){
		
	}
	
	private void preUpdate(Nivel object) {
		object.setDataAtualizacao(new Date());
	}
	
}
