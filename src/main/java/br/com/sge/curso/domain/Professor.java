package br.com.sge.curso.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="PROFESSORES")
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
public class Professor extends Pessoa {

	private static final long serialVersionUID = 733922544033711122L;
	
	private String perfil = "professor";
	
	public Professor(Long id, String nome, String email) {
		super();
		setId(id);
		setNome(nome);
		setEmail(email);
	}
	
	public Professor() {
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
