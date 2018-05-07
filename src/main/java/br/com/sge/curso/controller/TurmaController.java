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
import br.com.sge.curso.domain.Turma;
import br.com.sge.curso.service.NivelService;
import br.com.sge.curso.service.ProfessorService;
import br.com.sge.curso.service.TurmaService;

@RestController
@RequestMapping("/turmas")
public class TurmaController{
	
	
	@Autowired
	private TurmaService service;
	
	@Autowired
	private NivelService nivelService;
	
	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Turma get(@PathVariable("id")  Long id) {
		return service.get(id);
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<Turma> list(@RequestParam Integer page) {
		return service.list(page);
	}
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Turma> findAll() {
		return service.listar();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Turma save(@RequestBody Turma usuario) {
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
	
	@RequestMapping(value = "niveis", method = RequestMethod.GET)
	@ResponseBody
	public List<Nivel> niveis() {
		return nivelService.listar();
	}
	
	@RequestMapping(value = "professores", method = RequestMethod.GET)
	@ResponseBody
	public List<Professor> professores() {
		return professorService.listar();
	}
}
