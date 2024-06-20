package br.pucpr.dieta.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonValue;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.MappedSuperclass;

@Embeddable
@MappedSuperclass
public abstract class MacroNutriente implements Caloricavel {

	@Column(name = "QUANTIDADE")
	protected BigDecimal quantidade;

	protected MacroNutriente() {
		
	}
	
	public MacroNutriente(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	@JsonValue
	public BigDecimal getQuantidade() {
		return quantidade;
	}

}
