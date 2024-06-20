package br.pucpr.dieta.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Embeddable;

@Embeddable
public class Proteina extends MacroNutriente {

	private static final BigDecimal MULTIPLICADOR_CALORIAS = BigDecimal.valueOf(4L);

	protected Proteina() {
		
	}
	
	public Proteina(BigDecimal quantidade) {
		super(quantidade);
	}

	@JsonCreator
	public Proteina(double quantidade) {
		this(BigDecimal.valueOf(quantidade));
	}

	@JsonCreator
	public Proteina(long quantidade) {
		this(BigDecimal.valueOf(quantidade));
	}

	@Override
	public BigDecimal calorias() {
		return quantidade.multiply(MULTIPLICADOR_CALORIAS);
	}

}
