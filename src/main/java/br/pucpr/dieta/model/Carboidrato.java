package br.pucpr.dieta.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Embeddable;

@Embeddable
public class Carboidrato extends MacroNutriente {

	private static final BigDecimal MULTIPLICADOR_CALORIAS = BigDecimal.valueOf(4L);

	protected Carboidrato() {
		
	}
	
	public Carboidrato(BigDecimal quantidade) {
		super(quantidade);
	}

	@JsonCreator
	public Carboidrato(double quantidade) {
		this(BigDecimal.valueOf(quantidade));
	}

	@JsonCreator
	public Carboidrato(long quantidade) {
		this(BigDecimal.valueOf(quantidade));
	}

	@Override
	public BigDecimal calorias() {
		return quantidade.multiply(MULTIPLICADOR_CALORIAS);
	}

}
