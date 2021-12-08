package com.agenda.DTO;

import com.agenda.entities.Agendamento;
import com.agenda.entities.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

public class AgendamentoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String cliente;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm", locale = "pt-BR", timezone = "UTC")
    private Instant datahora;
    private BigDecimal valor;

    public  AgendamentoDTO() {
    }

    public AgendamentoDTO(Agendamento obj) {
        id = obj.getId();
        cliente = obj.getCliente().getNome();
        datahora = obj.getDatahora();
        valor = obj.getServico().getValor();
    }

    public AgendamentoDTO(Long id, String cliente, Instant datahora, BigDecimal valor) {
        this.id = id;
        this.cliente = cliente;
        this.datahora = datahora;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Instant getDatahora() {
        return datahora;
    }

    public void setDatahora(Instant datahora) {
        this.datahora = datahora;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
