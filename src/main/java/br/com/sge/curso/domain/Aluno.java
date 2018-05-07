package br.com.sge.curso.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="ALUNOS")
public class Aluno extends Pessoa {

	private static final long serialVersionUID = -446328939040515628L;
	
	private String matricula;
	private String perfil = "aluno";
	private String alimentosRestritos;
	private String observacoes;
	private String foto;
	
	private List<Responsavel> portadoresAutorizados;
	private List<Medicamento> medicamentos;
	
	public Aluno() {
		super();
	}
			
	public Aluno(Long id, String nome, String email, String matricula, Date dataNascimento) {
		super();
		setId(id);
		setNome(nome);
		setEmail(email);
		setDataNascimento(dataNascimento);
		this.matricula = matricula;
	}
	
	@Column(name="matricula")
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	@Column
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	@Column(name="alimentos_restritos")
	public String getAlimentosRestritos() {
		return alimentosRestritos;
	}
	public void setAlimentosRestritos(String alimentosRestritos) {
		this.alimentosRestritos = alimentosRestritos;
	}
	@Column(name="observacoes")
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	@ManyToMany(fetch = FetchType.LAZY, mappedBy="alunos", cascade = CascadeType.ALL)
	public List<Responsavel> getPortadoresAutorizados() {
		return portadoresAutorizados;
	}
	public void setPortadoresAutorizados(List<Responsavel> portadoresAutorizados) {
		this.portadoresAutorizados = portadoresAutorizados;
	}
	@Column(columnDefinition="text")
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	} 
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ID_ALUNO")
	@Fetch(value = FetchMode.SUBSELECT)
	public List<Medicamento> getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
	}
	
}
