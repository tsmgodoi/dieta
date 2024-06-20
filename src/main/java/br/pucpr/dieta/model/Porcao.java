package br.pucpr.dieta.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "DIETA", name = "PORCAO")
public class Porcao implements Caloricavel {

	@Id
	@GeneratedValue
	private UUID id;
	
	@OneToOne
	@JoinColumn(name = "ID_ALIMENTO", referencedColumnName = "id", nullable = false)
	private Alimento alimento;
	
	@Column(name = "QUANTIDADE")
	private Integer quantidade;
	
	@ManyToOne
	@JoinColumn(name = "ID_REFEICAO", nullable = false)
	private Refeicao refeicao;

	@Override
	public BigDecimal calorias() {
		return alimento.calorias().multiply(BigDecimal.valueOf(quantidade));
	}
	
}
