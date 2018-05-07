package br.com.sge.curso.vo;

import br.com.sge.curso.domain.BaseModel;

public class PessoaVO extends BaseModel{
	
	private static final long serialVersionUID = -884582090238254758L;
	
	private Long id;
	private String nome;
	private String email;
	private String matricula;
	
	public PessoaVO(Long id, String nome, String email, String matricula) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
