package br.com.sge.curso.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TURNOS")
public class Turno extends BaseModel {
	
	private static final long serialVersionUID = 5480632134708776503L;

	private Long id;
	private String nome;
	private Date horaInicial;
	private Date horaFinal;
	
	public Turno() {
		super();
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Column
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_inicial")
	public Date getHoraInicial() {
		return horaInicial;
	}
	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_final")
	public Date getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	
}
