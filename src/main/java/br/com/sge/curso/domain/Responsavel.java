package br.com.sge.curso.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="responsaveis")
public class Responsavel extends Pessoa {

	private static final long serialVersionUID = -5112087244355649897L;
	
	private List<Aluno> alunos;

	@ManyToMany
    @JoinTable(name="responsavel_has_alunos", joinColumns=
    {@JoinColumn(name="responsavel_id")}, inverseJoinColumns=
      {@JoinColumn(name="aluno_id")})
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	


}
