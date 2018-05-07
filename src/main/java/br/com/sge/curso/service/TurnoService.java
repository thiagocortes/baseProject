package br.com.sge.curso.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.Turno;
import br.com.sge.curso.repository.TurnoRepository;

@Service
public class TurnoService extends BaseService<Turno> {
	
	@Autowired
	private TurnoRepository repository;
	
	public TurnoService(){
		
	}
	
	@Override
	public void delete(Long id) {
		Turno object = repository.findOne(id);
		repository.delete(object);
	}

	@Override
	public Turno get(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Page<Turno> list(Integer page) {
		return null; 
	}

	@Override
	@Transactional
	public Turno save(Turno object) {
		Turno funcionario = repository.findForName(object.getNome());
		if(funcionario != null) {
			funcionario.setMessage("Turno já cadastrado");
		}else {
			funcionario = repository.save(object);
		}
		
		return funcionario;
	}
	
	@Override
	@Transactional
	public Turno update(Turno object) {
		return repository.update(object);
	}
	
	@Override
	public Iterable<Turno> findAll() {
		return repository.findAll();
	}
	
	public List<Turno> listar() {
		return repository.listar();
	}

	
}
