package br.com.sge.curso.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sge.curso.domain.Aluno;
import br.com.sge.curso.service.AlunoService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/aluno")
public class AlunoController{
	
	
	@Autowired
	private AlunoService alunoService;
	
	
	@PostMapping
	public Aluno save(@Valid @RequestBody Aluno object) {
		return alunoService.save(object);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Aluno> delete(@PathVariable Long id) {
		Aluno emp = alunoService.getForId(id);
		
		if( emp == null ) {
			return ResponseEntity.notFound().build();
		}
			
		alunoService.delete(emp.getId());
		return ResponseEntity.ok().body(emp);
		
	}
	
	@GetMapping
	public List<Aluno> findAll(){
		System.out.println("findAll");
		return alunoService.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable(value = "id") Long id){
		Aluno emp = alunoService.getForId(id);
		if( emp == null ) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	
	@PutMapping
	public ResponseEntity<Aluno> update(@Valid @RequestBody Aluno object) {
		Aluno emp = alunoService.getForId(object.getId());
		if( emp == null ) {
			return ResponseEntity.notFound().build();
		}
		
		emp.setNome(object.getNome());
		emp.setCpf(object.getCpf());
		emp.setEmail(object.getEmail());
		
		return ResponseEntity.ok().body(alunoService.update(emp));
		
	}
	
}
