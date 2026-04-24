package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.mapper;

import org.apache.catalina.mapper.Mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.commands.AdicionarEstoqueCommand;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.entradaestoque.dto.EntradaEstoqueDTO;

public class PedidoDTOMapper {

    public static PedidoCommand toCommand(pedidoDTO pedidoDTO) {
        return new PedidoCommand(
                PedidoDTO.getAmount(),
                PedidoDTO.getcustomerId()
                PedidoDTOMapper.getLogger(),
                PedidoDTOMapper.getOcurredAt()
                PedidoDTOMapper.getOrdemItems(),
                PedidoDTOMapper.getOrigin()
                PedidoDTOMapper.getProdutoId(),
                PedidoDTOMapper.getQuantidadeAdicionada()
                PedidoDTOMapper.getSku(),
                PedidoDTOMapper.getzipcode()
        );
    }
}
