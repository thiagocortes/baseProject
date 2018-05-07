package br.com.sge.curso.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Aluno;
import br.com.sge.curso.repository.AlunoRepository;

@Service
public class AlunoService extends BaseService<Aluno> {
	
	@Autowired
	private AlunoRepository repository;
	
	public AlunoService(){
		
	}
	
	@Override
	public void delete(Long id) {
		Aluno usuario = repository.findOne(id);
		repository.delete(usuario);
	}

	@Override
	public Aluno get(Long id) {
		return repository.findOne(id);
	}
	
	public Aluno getForId(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Aluno> list(Integer page) {
		return null; 
	}

	@Override
	@Transactional
	public Aluno save(Aluno object) {
		Aluno aluno = repository.save(object);
		posInsert(aluno);
		return aluno;
	}
	
	@Override
	@Transactional
	public Aluno update(Aluno object) {
		return repository.update(object);
	}
	
	@Override
	public Iterable<Aluno> findAll() {
		return repository.findAll();
	}
	
	public List<Aluno> listar() {
		return repository.listar();
	}
	
	public List<Aluno> pesquisar(Aluno aluno) {
		return repository.listar();
	}
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public List<Aluno> buscar(Aluno usuario) {
		return repository.buscar(usuario);
	}
	
	private void posInsert(Aluno aluno){
		aluno.setMatricula(gerarMatricula(aluno.getId()));
		update(aluno);
	}
	
	private String gerarMatricula(Long id) {
		int ano = Calendar.getInstance().get(Calendar.YEAR);
		int mes = Calendar.getInstance().get(Calendar.MONTH);
		int semestre = 1;
		if(mes > 6) {
			semestre = 2;
		}
		return (""+ ano + 0 + semestre + id);
	}
}
