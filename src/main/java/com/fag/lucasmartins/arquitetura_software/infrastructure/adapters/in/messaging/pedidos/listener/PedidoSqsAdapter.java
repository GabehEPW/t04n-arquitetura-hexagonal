package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.dto.PedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.mapper.PedidoDTOMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Profile("aws")
public class PedidoSqsAdapter {

    private static final Logger log = LoggerFactory.getLogger(PedidoSqsAdapter.class);

    private final PedidoServicePort pedidoServicePort;

    private final ObjectMapper objectMapper;

    public PedidoSqsAdapter(PedidoServicePort pedidoServicePort, ObjectMapper objectMapper) {
        this.pedidoServicePort = pedidoServicePort;
        this.objectMapper = objectMapper;
    }

    @SqsListener("${queue.order-events}")
    public void receberMensagem(String payload) throws Exception {
        try {
            final PedidoDTO dto = objectMapper.readValue(payload, PedidoDTO.class);

            log.info("Evento de pedido recebido: customerId={}, zipCode={}, origin={}", dto.getCustomerId(), dto.getZipCode(), dto.getOrigin());

            final PedidoBO pedidoBO = PedidoDTOMapper.toBo(dto);
            pedidoServicePort.criarPedido(pedidoBO);

            log.info("Pedido processado com sucesso.");
        } catch (Exception e) {
            log.error("Erro ao processar o evento de pedido", e);
            throw e;
        }
    }
}
