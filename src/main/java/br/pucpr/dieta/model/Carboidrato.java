package br.pucpr.dieta.model;

public class Carboidrato extends MacroNutriente {

	public Carboidrato(Integer quantidade) {
		super(quantidade);
	}

	@Override
	public Integer calorias() {
		return quantidade * 4;
	}

}
