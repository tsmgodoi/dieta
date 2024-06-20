package br.pucpr.dieta.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(schema = "DIETA", name = "DIA_ALIMENTACAO")
public class DiaDeAlimentacao implements Caloricavel {

	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name = "DATA", nullable = false)
	private LocalDate data;

	@OneToMany(mappedBy = "dia")
	private List<Refeicao> refeicoes;

	@Override
	public BigDecimal calorias() {
		return Caloricavel.caloriasDe(refeicoes);
	}

}
