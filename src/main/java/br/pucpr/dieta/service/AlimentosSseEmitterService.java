package br.pucpr.dieta.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

import br.pucpr.dieta.controller.dto.AlimentoDto;
import br.pucpr.dieta.model.Alimento;

@Service
public class AlimentosSseEmitterService {
	
	private static final Logger log = LoggerFactory.getLogger(AlimentosSseEmitterService.class);

	private Map<String, SseEmitter> emitters = new HashMap<>();
	
	public SseEmitter createEmitter(String id) {
		SseEmitter emitter = new SseEmitter();
		emitters.put(id, emitter);
		
		emitter.onCompletion(() -> {
			synchronized (this.emitters) {
				this.emitters.remove(id);
			}
		});
		
		emitter.onTimeout(() -> {
			emitter.complete();
		});
		
		return emitter;
	}
	
	public void notificar(String event, Alimento alimento) {
		notificarComDados(event, new AlimentoDto(alimento));
	}
	
	public void notificar(String event, UUID id) {
		notificarComDados(event, id);
	}
	
	private void notificarComDados(String event, Object data) {
		for (var entry : emitters.entrySet()) {
			try {
				SseEventBuilder eventBuilder = SseEmitter.event().data(data).name(event);
				entry.getValue().send(eventBuilder);
			} catch (IOException e) {
				log.warn("Erro ao notificar o cliente de id " + entry.getKey());
			}
		}
	}
	
}
