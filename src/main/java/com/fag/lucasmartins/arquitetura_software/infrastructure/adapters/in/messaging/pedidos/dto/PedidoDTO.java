package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.dto;

public class PedidoDTO {

    private Integer zipcode;

    private Integer customerId;

    private Integer OrdemItems;

    private Integer Sku;

    private Integer Amount;

    private Integer Origin;

    private Integer OcurredAt;

    public Integer getzipcode() {
        return zipcode;
    }

    public Integer getcustomerId() {
        return customerId;
    }

    public Integer getOrdemItems() {
        return OrdemItems;
    }

    public Integer getSku() {
        return Sku;
    }

    public Integer getAmount() {
        return Amount;
    }

    public Integer getOrigin() {
        return Origin;
    }

    public Integer getOcurredAt() {
        return OcurredAt;
    }

}
