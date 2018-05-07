package br.com.sge.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Professor;
import br.com.sge.curso.repository.ProfessorRepository;

@Service
public class ProfessorService extends BaseService<Professor> {
	
	@Autowired
	private ProfessorRepository repository;
	
	public ProfessorService(){
		
	}
	
	@Override
	public void delete(Long id) {
		Professor professor = repository.findOne(id);
		repository.delete(professor);
	}

	@Override
	public Professor get(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Professor> list(Integer page) {
		return null; 
	}

	@Override
	@Transactional
	public Professor save(Professor object) {
		return repository.save(object);
	}
	
	@Override
	@Transactional
	public Professor update(Professor object) {
		return repository.update(object);
	}
	
	@Override
	public Iterable<Professor> findAll() {
		return repository.findAll();
	}
	
	@Override
	public List<Professor> listar() {
		return repository.listar();
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Professor> buscar(Professor usuario) {
		return repository.buscar(usuario);
	}
	
}
