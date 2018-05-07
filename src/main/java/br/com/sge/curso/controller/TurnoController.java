package br.com.sge.curso.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.sge.curso.domain.Nivel;
import br.com.sge.curso.domain.Professor;
import br.com.sge.curso.domain.Situacao;
import br.com.sge.curso.domain.Turno;
import br.com.sge.curso.service.NivelService;
import br.com.sge.curso.service.ProfessorService;
import br.com.sge.curso.service.TurnoService;

@RestController
@RequestMapping("/turnos")
public class TurnoController{
	
	
	@Autowired
	private TurnoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Turno get(@PathVariable("id")  Long id) {
		return service.get(id);
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<Turno> list(@RequestParam Integer page) {
		return service.list(page);
	}
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Turno> findAll() {
		return service.listar();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Turno save(@RequestBody Turno usuario) {
		if(usuario != null && usuario.getId() != null) {
			return service.update(usuario);
		}
		return service.save(usuario);
	}


}
