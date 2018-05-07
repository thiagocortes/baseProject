package br.com.sge.curso.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.sge.curso.domain.HorarioTurno;
import br.com.sge.curso.domain.Turno;
import br.com.sge.curso.service.HorarioTurnoService;
import br.com.sge.curso.service.TurnoService;
import br.com.sge.curso.util.ValidationErrorBuilder;

@Controller
@RequestMapping("/horariosTurnos")
public class HorarioTurnoController{
	
	
	@Autowired
	private HorarioTurnoService service;
	
	@Autowired
	private TurnoService turnoService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public HorarioTurno get(@PathVariable("id")  Long id) {
		return service.get(id);
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<HorarioTurno> list(@RequestParam Integer page) {
		return service.list(page);
	}
	
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<HorarioTurno> findAll() {
		return service.listar();
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public HorarioTurno save(@RequestBody HorarioTurno usuario) {
		if(usuario != null && usuario.getId() != null) {
			return service.update(usuario);
		}
		return service.save(usuario);
	}
	
	@RequestMapping(value = "horarios", method = RequestMethod.GET)
	@ResponseBody
	public Integer[] horarios() {
		Integer [] horarios = new Integer [] {1, 2, 3, 4, 5, 6};
		return horarios;
	}
	
	@RequestMapping(value = "turnos", method = RequestMethod.GET)
	@ResponseBody
	public List<Turno> turnos() {
		return turnoService.listar();
	}
	
//	@RequestMapping(method = RequestMethod.POST, value = "", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<?> login(@Valid @RequestBody HorarioTurno form, BindingResult bindingResult) {
//	    if (bindingResult.hasErrors()) {
//	        return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(bindingResult));
//	    }
//	 
//	    HorarioTurno cliente = service.save(form);
//	    if (cliente == null) {
//	        return ResponseEntity.notFound().build();
//	    }
//	 
//	    return ResponseEntity.ok(cliente);
//	}


}
