package br.pucpr.dieta.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EstadoDoAlimento {

	CRU("Cru"), COZIDO("Cozido"), GRELHADO("Grelhado"), ASSADO("Assado");

	private String nome;

	private EstadoDoAlimento(String nome) {
		this.nome = nome;
	}

	@JsonValue
	public String getNome() {
		return nome;
	}

}
