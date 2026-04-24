package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.saidaestoque.listener;

@Component
public class SqsPedidoAdapter {

    @SqsListener("${queue.order-events{")
    public void listen(SuaDTO dto) {
        System.out.println("Mensagem recebida: " + dto.getCustomerId());

        orderService.process(dto);
    }

}