package br.pucpr.dieta.model;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Essa interface representa o que pode ser calculado a quantidade de calorias.
 * 
 * <p>
 * Por padrão, a unidade de medida é Kcal.
 */
public interface Caloricavel {

	/**
	 * Calcula a quantidade de calorias em Kcal.
	 * 
	 * @return a quantidade de calorias em Kcal.
	 */
	BigDecimal calorias();
	
	static BigDecimal caloriasDe(Collection<? extends Caloricavel> itens) {
		return itens.stream().map(Caloricavel::calorias).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
}
