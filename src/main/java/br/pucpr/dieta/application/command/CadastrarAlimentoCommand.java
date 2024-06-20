package br.pucpr.dieta.application.command;

import java.math.BigDecimal;
import java.util.Optional;

import br.pucpr.dieta.model.Carboidrato;
import br.pucpr.dieta.model.EstadoDoAlimento;
import br.pucpr.dieta.model.Gordura;
import br.pucpr.dieta.model.Proteina;
import br.pucpr.dieta.model.UnidadeDeMedida;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CadastrarAlimentoCommand implements Command {

	@NotBlank
	private String nome;

	private String tipo;

	private String marca;

	private EstadoDoAlimento estado;

	@NotNull
	private UnidadeDeMedida unidade;

	@NotNull
	private BigDecimal quantidadePorcao;

	@NotNull
	private Carboidrato carboidrato;

	@NotNull
	private Proteina proteina;

	@NotNull
	private Gordura gordura;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Optional<String> getTipo() {
		return Optional.ofNullable(tipo);
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Optional<String> getMarca() {
		return Optional.ofNullable(marca);
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Optional<EstadoDoAlimento> getEstado() {
		return Optional.ofNullable(estado);
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

}
