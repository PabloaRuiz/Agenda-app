package com.agenda.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "Agenda")
public class Agendamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", locale = "pt-BR", timezone = "UTC")
    private Instant datahora;
    private String observacao;

    @ManyToOne
    @NotNull
    private Servico servico;

    @ManyToOne
    @NotNull
    private Cliente cliente;
     
    public Agendamento() {
    }

    public Agendamento(Instant datahora, String observacao, Servico servico, Cliente cliente) {
        this.datahora = datahora;
        this.observacao = observacao;
        this.servico = servico;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDatahora() {
        return datahora;
    }

    public void setDatahora(Instant datahora) {
        this.datahora = datahora;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

