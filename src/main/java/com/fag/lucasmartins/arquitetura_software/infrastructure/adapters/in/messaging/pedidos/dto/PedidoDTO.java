package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.dto;

import java.util.List;
import java.util.UUID;

public class PedidoDTO {

    private UUID id;

    private PessoaDTO pessoa;

    private String cep;

    private List<PedidoProdutoDTO> itens;

    private Double valorTotal;

    private String zipCode;

    private Long customerId;

    private List<PedidoProdutoDTO> orderItems;

    private String origin;

    private String occurredAt;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public PessoaDTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<PedidoProdutoDTO> getItens() {
        return itens;
    }

    public void setItens(List<PedidoProdutoDTO> itens) {
        this.itens = itens;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<PedidoProdutoDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<PedidoProdutoDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(String occurredAt) {
        this.occurredAt = occurredAt;
    }

}
