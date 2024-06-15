package br.pucpr.dieta.model;

public abstract class MacroNutriente {

	protected Integer quantidade;

	public MacroNutriente(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer quantidade() {
		return quantidade;
	}

	/**
	 * Calcula a quantidade de calorias em Kcal.
	 * 
	 * @return a quantidade de calorias em Kcal.
	 */
	public abstract Integer calorias();

}
