package br.pucpr.dieta.controller.dto;

import java.util.UUID;

import br.pucpr.dieta.model.Alimento;

public class AlimentoDto {

	private UUID id;

	private String nome;

	public AlimentoDto(Alimento alimento) {
		this.id = alimento.getId();
		this.nome = alimento.getNome();
	}

	public UUID getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
