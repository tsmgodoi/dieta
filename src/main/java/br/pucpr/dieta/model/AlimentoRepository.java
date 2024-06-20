package br.pucpr.dieta.model;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentoRepository extends JpaRepository<Alimento, UUID> {

}
