package br.pucpr.dieta.model;

public class Proteina extends MacroNutriente {

	public Proteina(Integer quantidade) {
		super(quantidade);
	}

	@Override
	public Integer calorias() {
		return quantidade * 4;
	}

}
