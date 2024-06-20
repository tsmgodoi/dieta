package br.pucpr.dieta.application;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.pucpr.dieta.application.command.CadastrarAlimentoCommand;
import br.pucpr.dieta.model.Alimento;
import br.pucpr.dieta.model.AlimentoRepository;
import br.pucpr.dieta.service.AlimentosSseEmitterService;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class AlimentoApplicationService {

	@Autowired
	private AlimentoRepository repository;
	
	@Autowired
	private AlimentosSseEmitterService sseService;

	public Alimento handle(CadastrarAlimentoCommand command) {
		Alimento alimento = new Alimento(command.getNome());
		command.getTipo().ifPresent(alimento::setTipo);
		command.getMarca().ifPresent(alimento::setMarca);
		command.getEstado().ifPresent(alimento::setEstado);
		alimento.setUnidade(command.getUnidade());
		alimento.setQuantidadePorcao(command.getQuantidadePorcao());
		alimento.setCarboidrato(command.getCarboidrato());
		alimento.setProteina(command.getProteina());
		alimento.setGordura(command.getGordura());
		
		alimento = repository.save(alimento);
		
		sseService.notificar("criado", alimento);
		
		return alimento;
	}

	public Alimento alterar(Alimento alimentoAlterado) {
		var alimentoExistente = recuperarAlimento(alimentoAlterado.getId());
		alimentoExistente.setNome(alimentoAlterado.getNome());
		alimentoAlterado.getMarca().ifPresent(alimentoExistente::setMarca);
		alimentoAlterado.getEstado().ifPresent(alimentoExistente::setEstado);
		alimentoAlterado.getTipo().ifPresent(alimentoExistente::setTipo);
		return alimentoExistente;
	}

	private Alimento recuperarAlimento(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Alimento com id " + id + " não encontrado"));
	}

	public void excluir(UUID id) {
		repository.delete(recuperarAlimento(id));
		sseService.notificar("excluido", id);
	}

}
