package br.com.sge.curso.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCIONARIOS")
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
public class Funcionario extends Pessoa {
	
	private static final long serialVersionUID = 355856051671386093L;
	
	private String perfil = "funcionario";
	
	public Funcionario(Long id, String nome, String email) {
		super();
		setId(id);
		setNome(nome);
		setEmail(email);
	}
	
	public Funcionario() {
		super();
	}
	
	@Column
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	
}
