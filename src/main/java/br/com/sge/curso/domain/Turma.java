package br.com.sge.curso.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TURMAS")
public class Turma extends BaseModel {
	
	private static final long serialVersionUID = 5480632134708776503L;

	private Long id;
	private Situacao situacao = Situacao.ATIVO;
	private String nome;
	private Integer maxAluno;
	private String sigla;
	private Professor professor;
	private Curso curso;
	private Nivel nivel;
	
	public Turma() {
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
	@Enumerated(EnumType.STRING)
	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	@Column
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name="max_aluno")
	public Integer getMaxAluno() {
		return maxAluno;
	}

	public void setMaxAluno(Integer maxAluno) {
		this.maxAluno = maxAluno;
	}
	@Column
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	@ManyToOne
	@JoinColumn(name = "ID_PROFESSOR")
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	@ManyToOne
	@JoinColumn(name = "ID_CURSO")
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	@ManyToOne
	@JoinColumn(name = "ID_NIVEL")
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
}
