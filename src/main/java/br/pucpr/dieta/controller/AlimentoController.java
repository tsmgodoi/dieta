package br.pucpr.dieta.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import br.pucpr.dieta.application.AlimentoApplicationService;
import br.pucpr.dieta.application.command.CadastrarAlimentoCommand;
import br.pucpr.dieta.controller.dto.AlimentoDto;
import br.pucpr.dieta.model.Alimento;
import br.pucpr.dieta.model.AlimentoRepository;
import br.pucpr.dieta.service.AlimentosSseEmitterService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/alimentos")
@CrossOrigin
public class AlimentoController {

	@Autowired
	private AlimentoApplicationService appService;

	@Autowired
	private AlimentoRepository repository;
	
	@Autowired
	private AlimentosSseEmitterService sseService;

	@PostMapping
	public Alimento cadastrar(@RequestBody @Valid CadastrarAlimentoCommand command) {
		return appService.handle(command);
	}

	@PutMapping
	public Alimento alterar(@RequestBody Alimento alimentoAlterado) {
		return appService.alterar(alimentoAlterado);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable UUID id) {
		appService.excluir(id);
	}

	@GetMapping
	public List<AlimentoDto> listarAlimentos() {
		return repository.findAll().stream().map(AlimentoDto::new).toList();
	}

	@GetMapping(path = "/sse")
	public SseEmitter sse() {
		return sseService.createEmitter(UUID.randomUUID().toString());
	}
	
}
