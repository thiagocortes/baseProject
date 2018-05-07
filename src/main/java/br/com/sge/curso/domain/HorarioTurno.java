package br.com.sge.curso.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="HORARIOS_TURNOS")
public class HorarioTurno extends BaseModel {
	
	private static final long serialVersionUID = 5480632134708776503L;

	private Long id;
	private Integer horario;
	private Date horaInicial;
	private Date horaFinal;
	private Turno turno;
	
	public HorarioTurno() {
		super();
	}
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_inicial")
	@NotNull(message = "Campo Obrigatório")
	public Date getHoraInicial() {
		return horaInicial;
	}
	public void setHoraInicial(Date horaInicial) {
		this.horaInicial = horaInicial;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "hora_final")
	@NotNull(message = "Campo Obrigatório")
	public Date getHoraFinal() {
		return horaFinal;
	}
	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}
	@NotNull(message = "Campo Obrigatório")
	public Integer getHorario() {
		return horario;
	}
	public void setHorario(Integer horario) {
		this.horario = horario;
	}
	@ManyToOne
	@JoinColumn(name="id_turno")
	@NotNull(message = "Campo Obrigatório")
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	
}
