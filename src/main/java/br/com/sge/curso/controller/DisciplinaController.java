package br.com.sge.curso.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sge.curso.domain.Disciplina;
import br.com.sge.curso.domain.TipoSexo;
import br.com.sge.curso.service.DisciplinaService;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController{
	
	
	@Autowired
	private DisciplinaService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Disciplina get(@PathVariable("id")  Long id) {
		return service.get(id);
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<Disciplina> list(@RequestParam Integer page) {
		return service.list(page);
	}
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Disciplina> findAll() {
		return service.listar();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Disciplina save(@RequestBody Disciplina usuario) {
		if(usuario != null && usuario.getId() != null) {
			return service.update(usuario);
		}
		return service.save(usuario);
	}
	
}
