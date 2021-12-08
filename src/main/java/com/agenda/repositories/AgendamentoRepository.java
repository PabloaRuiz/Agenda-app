package com.agenda.repositories;

import com.agenda.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

	Optional<Agendamento> findByCliente(Long cliente);
}