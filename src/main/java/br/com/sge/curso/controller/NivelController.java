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

import com.google.gson.Gson;

import br.com.sge.curso.domain.Curso;
import br.com.sge.curso.domain.Nivel;
import br.com.sge.curso.domain.Situacao;
import br.com.sge.curso.service.CursoService;
import br.com.sge.curso.service.NivelService;

@Controller
@RequestMapping("/niveis")
public class NivelController{
	
	
	@Autowired
	private NivelService service;
	@Autowired
	private CursoService cursoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Nivel get(@PathVariable("id")  Long id) {
		return service.get(id);
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<Nivel> list(@RequestParam Integer page) {
		return service.list(page);
	}
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Nivel> findAll() {
		return service.listar();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Nivel save(@RequestBody Nivel usuario) {
		if(usuario != null && usuario.getId() != null) {
			return service.update(usuario);
		}
		return service.save(usuario);
	}
	
	@RequestMapping(value = "cursos", method = RequestMethod.GET)
	@ResponseBody
	public List<Curso> getCursos() {
		return cursoService.listar();
	}
	
	@RequestMapping(value = "situacao", method = RequestMethod.GET)
	@ResponseBody
	public List<Situacao> getSituacao() {
		return Arrays.asList(Situacao.values());
	}
	
}