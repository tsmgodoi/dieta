package br.pucpr.dieta.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "DIETA", name = "REFEICAO")
public class Refeicao implements Caloricavel {

	@Id
	@GeneratedValue
	private UUID id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "HORARIO")
	private LocalDateTime horario;

	@OneToMany(mappedBy = "refeicao")
	private List<Porcao> porcoes;

	@ManyToOne
	@JoinColumn(name = "ID_DIA_ALIMENTACAO", nullable = false)
	private DiaDeAlimentacao dia;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDateTime getHorario() {
		return horario;
	}

	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	public List<Porcao> getPorcoes() {
		return porcoes;
	}

	public void setPorcoes(List<Porcao> porcoes) {
		this.porcoes = porcoes;
	}

	public DiaDeAlimentacao getDia() {
		return dia;
	}

	public void setDia(DiaDeAlimentacao dia) {
		this.dia = dia;
	}

	@Override
	public BigDecimal calorias() {
		return Caloricavel.caloriasDe(porcoes);
	}

}
