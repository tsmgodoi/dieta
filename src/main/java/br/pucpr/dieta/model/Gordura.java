package br.pucpr.dieta.model;

public class Gordura extends MacroNutriente {

	public Gordura(Integer quantidade) {
		super(quantidade);
	}

	@Override
	public Integer calorias() {
		return quantidade * 9;
	}

}
