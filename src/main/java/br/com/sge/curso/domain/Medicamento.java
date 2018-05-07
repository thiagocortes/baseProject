package br.com.sge.curso.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="medicamentos")
public class Medicamento extends BaseModel {

	private static final long serialVersionUID = 9075852609789240428L;
	
	private Aluno pessoa;
	private String descricao;
	private Long id;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ALUNO")
	public Aluno getPessoa() {
		return pessoa;
	}
	public void setPessoa(Aluno pessoa) {
		this.pessoa = pessoa;
	}
	@Column
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
