package br.com.sge.curso.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table( name = "USUARIOS")
@PrimaryKeyJoinColumn(name="id", referencedColumnName="id")
public class Usuario extends Pessoa{
	
	private static final long serialVersionUID = -3134858578753787815L;
	
	private String login;
	private String senha;
	@Transient
	private String senhaRepetida;
	private Date ultimoAcesso;
	private Perfil perfil;
	private Boolean ativo;
	
	@Column
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@Column
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	@Column(name="ultimo_acesso", length = 7)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}
	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
	@Column(name="senha_repetida")
	public String getSenhaRepetida() {
		return senhaRepetida;
	}
	public void setSenhaRepetida(String senhaRepetida) {
		this.senhaRepetida = senhaRepetida;
	}
	@ManyToOne
	@JoinColumn(name = "ID_PERFIL")
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	@Type(type="yes_no")
	@Column(length = 1)
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
	
}