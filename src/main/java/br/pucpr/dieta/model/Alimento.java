package br.pucpr.dieta.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.util.Assert;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "DIETA", name = "ALIMENTO")
public class Alimento implements Caloricavel {

	@Id
	@GeneratedValue
	private UUID id;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "TIPO")
	private String tipo;

	@Column(name = "MARCA")
	private String marca;

	@Column(name = "ESTADO")
	@Enumerated(EnumType.STRING)
	private EstadoDoAlimento estado;

	@Column(name = "UNIDADE_MEDIDA", nullable = false)
	@Enumerated(EnumType.STRING)
	private UnidadeDeMedida unidade;

	@Column(name = "QTDE_PORCAO", nullable = false)
	private BigDecimal quantidadePorcao;

	@Embedded
	@AttributeOverride(name = "quantidade", column = @Column(name = "QTDE_CARBOIDRATO", nullable = false))
	private Carboidrato carboidrato;

	@Embedded
	@AttributeOverride(name = "quantidade", column = @Column(name = "QTDE_PROTEINA", nullable = false))
	private Proteina proteina;

	@Embedded
	@AttributeOverride(name = "quantidade", column = @Column(name = "QTDE_GORDURA", nullable = false))
	private Gordura gordura;

	protected Alimento() {

	}

	public Alimento(String nome) {
		Assert.hasLength(nome, "O nome do alimento não pode ser vazio");
		this.nome = nome;
	}

	public UUID getId() {
		return this.id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Optional<String> getTipo() {
		return Optional.ofNullable(this.tipo);
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Optional<String> getMarca() {
		return Optional.ofNullable(this.marca);
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Optional<EstadoDoAlimento> getEstado() {
		return Optional.ofNullable(this.estado);
	}

	public void setEstado(EstadoDoAlimento estado) {
		this.estado = estado;
	}

	public UnidadeDeMedida getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeDeMedida unidade) {
		this.unidade = unidade;
	}

	public BigDecimal getQuantidadePorcao() {
		return quantidadePorcao;
	}

	public void setQuantidadePorcao(BigDecimal quantidadePorcao) {
		this.quantidadePorcao = quantidadePorcao;
	}

	public Carboidrato getCarboidrato() {
		return carboidrato;
	}

	public void setCarboidrato(Carboidrato carboidrato) {
		this.carboidrato = carboidrato;
	}

	public Proteina getProteina() {
		return proteina;
	}

	public void setProteina(Proteina proteina) {
		this.proteina = proteina;
	}

	public Gordura getGordura() {
		return gordura;
	}

	public void setGordura(Gordura gordura) {
		this.gordura = gordura;
	}

	public List<MacroNutriente> macronutrientes() {
		return List.of(carboidrato, proteina, gordura);
	}

	@Override
	public BigDecimal calorias() {
		return Caloricavel.caloriasDe(macronutrientes());
	}

}
