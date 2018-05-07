package br.com.sge.curso.controller;

import java.util.Arrays;
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

import br.com.sge.curso.domain.Curso;
import br.com.sge.curso.domain.Situacao;
import br.com.sge.curso.service.CursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController /*extends BaseController<Curso>*/{
	
	
	@Autowired
	private CursoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Curso get(@PathVariable("id")  Long id) {
		return service.get(id);
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<Curso> list(@RequestParam Integer page) {
		return service.list(page);
	}
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Curso> findAll() {
		return service.listar();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Curso save(@RequestBody Curso usuario) {
		if(usuario != null && usuario.getId() != null) {
			return service.update(usuario);
		}
		return service.save(usuario);
	}
	
	@RequestMapping(value = "situacao", method = RequestMethod.GET)
	@ResponseBody
	public List<Situacao> getSituacao() {
		return Arrays.asList(Situacao.values());
	}
	
}
