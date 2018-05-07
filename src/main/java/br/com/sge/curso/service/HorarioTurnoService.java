package br.com.sge.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sge.curso.domain.HorarioTurno;
import br.com.sge.curso.repository.HorarioTurnoRepository;

@Service
public class HorarioTurnoService extends BaseService<HorarioTurno> {
	
	@Autowired
	private HorarioTurnoRepository repository;
	
	public HorarioTurnoService(){
		super();
	}
	
	@Override
	public void delete(Long id) {
		HorarioTurno object = repository.findOne(id);
		repository.delete(object);
	}

	@Override
	public HorarioTurno get(Long id) {
		return repository.findOne(id);
	}

	@Override
	public Page<HorarioTurno> list(Integer page) {
		return null; 
	}

	@Override
	@Transactional
	public HorarioTurno save(HorarioTurno object) {
		HorarioTurno funcionario = repository.findForHorarioTurno(object);
		if(funcionario != null) {
			funcionario.setMessage("Horário já Cadastrado");
		}else {
			funcionario = repository.save(object);
		}
		return funcionario;
	}
	
	@Override
	@Transactional
	public HorarioTurno update(HorarioTurno object) {
		return repository.update(object);
	}
	
	@Override
	public Iterable<HorarioTurno> findAll() {
		return repository.findAll();
	}
	
	public List<HorarioTurno> listar() {
		return repository.listar();
	}

	
}
