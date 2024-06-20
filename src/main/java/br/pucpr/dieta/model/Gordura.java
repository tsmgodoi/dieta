package br.pucpr.dieta.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Embeddable;

@Embeddable
public class Gordura extends MacroNutriente {

	private static final BigDecimal MULTIPLICADOR_CALORIAS = BigDecimal.valueOf(9L);

	protected Gordura() {
		
	}
	
	public Gordura(BigDecimal quantidade) {
		super(quantidade);
	}

	@JsonCreator
	public Gordura(double quantidade) {
		this(BigDecimal.valueOf(quantidade));
	}

	@JsonCreator
	public Gordura(long quantidade) {
		this(BigDecimal.valueOf(quantidade));
	}

	@Override
	public BigDecimal calorias() {
		return quantidade.multiply(MULTIPLICADOR_CALORIAS);
	}

}
