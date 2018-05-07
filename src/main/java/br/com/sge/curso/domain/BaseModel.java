package br.com.sge.curso.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.persistence.Version;

@MappedSuperclass
public class BaseModel implements Serializable{

	private static final long serialVersionUID = 404517387231898817L;
	
	protected Date dataCriacao;
	protected Date dataAtualizacao;
	protected String usuarioCriacao;
	protected String usuarioAtualizacao;
	protected Long version;
	private String message;
	
	@Column(name="dt_criacao")
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	@Column(name="dt_atualizacao")
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	@Column(name="usuario_criacao")
	public String getUsuarioCriacao() {
		return usuarioCriacao;
	}
	public void setUsuarioCriacao(String usuarioCriacao) {
		this.usuarioCriacao = usuarioCriacao;
	}
	@Column(name="usuario_atualizacao")
	public String getUsuarioAtualizacao() {
		return usuarioAtualizacao;
	}
	public void setUsuarioAtualizacao(String usuarioAtualizacao) {
		this.usuarioAtualizacao = usuarioAtualizacao;
	}
	
	@Version
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	
	@PrePersist
    public void prePersist() {
        this.setDataCriacao(new Date());
    }

    @PreUpdate
    public void preUpdate() {
        this.setDataAtualizacao(new Date());
    }
    @Transient
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
    
}
