package br.pucpr.dieta.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UnidadeDeMedida {

	GRAMA("Grama", "g");

	private String nome;

	private String sigla;

	private UnidadeDeMedida(String nome, String sigla) {
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@JsonValue
	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

}
