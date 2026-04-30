package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.listener;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.dto.PedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.mapper.PedidoDTOMapper;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("aws")
public class PedidoSqsAdapter {

    private static final Logger log = LoggerFactory.getLogger(PedidoSqsAdapter.class);

    private final PedidoServicePort pedidoServicePort;

    public PedidoSqsAdapter(PedidoServicePort pedidoServicePort) {
        this.pedidoServicePort = pedidoServicePort;
    }

    @SqsListener("${queue.order-events}")
    public void receberMensagem(PedidoDTO dto) {
        try {
            log.info("Evento de pedido recebido para o cliente {}", dto.getPessoa() != null ? dto.getPessoa().getId() : null);

            final PedidoBO pedidoBO = PedidoDTOMapper.toBo(dto);
            pedidoServicePort.criarPedido(pedidoBO);

            log.info("Pedido processado com sucesso.");
        } catch (Exception e) {
            log.error("Erro ao processar o evento de pedido", e);
            throw e;
        }
    }
}
