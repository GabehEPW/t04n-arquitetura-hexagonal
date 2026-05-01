package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.mapper;

import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoProdutoBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PessoaBO;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.ProdutoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.dto.PedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.dto.PedidoProdutoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.dto.PessoaDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedidos.dto.ProdutoDTO;

import java.util.ArrayList;
import java.util.List;

public class PedidoDTOMapper {

    private PedidoDTOMapper() {
    }

    public static PedidoBO toBo(PedidoDTO dto) {
        final PedidoBO bo = new PedidoBO();

        bo.setId(dto.getId());
        bo.setPessoa(toBoPessoa(dto));
        bo.setCep(resolveCep(dto));
        bo.setItens(toBoItens(dto));

        return bo;
    }

    public static PedidoDTO toDto(PedidoBO bo) {
        final PedidoDTO dto = new PedidoDTO();

        dto.setId(bo.getId());
        dto.setPessoa(toDto(bo.getPessoa()));
        dto.setCep(bo.getCep());
        dto.setItens(toDtoItens(bo.getItens()));
        dto.setZipCode(bo.getCep());
        dto.setOrderItems(toDtoItens(bo.getItens()));
        dto.setCustomerId(bo.getPessoa() != null ? Long.valueOf(bo.getPessoa().getId()) : null);
        dto.setValorTotal(bo.getValorTotal());

        return dto;
    }

    private static PessoaBO toBoPessoa(PedidoDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getPessoa() != null) {
            return toBo(dto.getPessoa());
        }

        if (dto.getCustomerId() == null) {
            return null;
        }

        final PessoaBO bo = new PessoaBO();
        bo.setId(dto.getCustomerId().intValue());
        return bo;
    }

    private static String resolveCep(PedidoDTO dto) {
        if (dto == null) {
            return null;
        }

        return dto.getZipCode() != null ? dto.getZipCode() : dto.getCep();
    }

    private static PessoaBO toBo(PessoaDTO dto) {
        if (dto == null) {
            return null;
        }

        final PessoaBO bo = new PessoaBO();
        bo.setId(dto.getId());
        bo.setNomeCompleto(dto.getNomeCompleto());
        bo.setCpf(dto.getCpf());
        bo.setDataNascimento(dto.getDataNascimento());
        bo.setEmail(dto.getEmail());
        bo.setTelefone(dto.getTelefone());
        return bo;
    }

    private static PessoaDTO toDto(PessoaBO bo) {
        if (bo == null) {
            return null;
        }

        final PessoaDTO dto = new PessoaDTO();
        dto.setId(bo.getId());
        dto.setNomeCompleto(bo.getNomeCompleto());
        dto.setCpf(bo.getCpf());
        dto.setDataNascimento(bo.getDataNascimento());
        dto.setEmail(bo.getEmail());
        dto.setTelefone(bo.getTelefone());
        return dto;
    }

    private static List<PedidoProdutoBO> toBoItens(PedidoDTO dto) {
        final List<PedidoProdutoBO> boItens = new ArrayList<>();
        final List<PedidoProdutoDTO> itens = dto != null && dto.getOrderItems() != null ? dto.getOrderItems() : dto != null ? dto.getItens() : null;

        if (itens == null) {
            return boItens;
        }

        for (PedidoProdutoDTO item : itens) {
            boItens.add(toBo(item));
        }

        return boItens;
    }

    private static PedidoProdutoBO toBo(PedidoProdutoDTO dto) {
        final PedidoProdutoBO bo = new PedidoProdutoBO();
        bo.setId(dto.getId());
        bo.setQuantidade(dto.getAmount() != null ? dto.getAmount() : dto.getQuantidade());
        bo.setSubtotal(dto.getSubtotal() == null ? 0.0 : dto.getSubtotal());
        bo.setProduto(toBoProduto(dto));
        return bo;
    }

    private static ProdutoBO toBoProduto(PedidoProdutoDTO dto) {
        if (dto == null) {
            return null;
        }

        if (dto.getProduto() != null) {
            return toBo(dto.getProduto());
        }

        if (dto.getSku() == null) {
            return null;
        }

        final ProdutoBO bo = new ProdutoBO();
        bo.setId(dto.getSku());
        return bo;
    }

    private static ProdutoBO toBo(ProdutoDTO dto) {
        if (dto == null) {
            return null;
        }

        final ProdutoBO bo = new ProdutoBO();
        bo.setId(dto.getId());
        bo.setNome(dto.getNome());
        bo.setEstoque(dto.getEstoque());
        bo.setPreco(dto.getPreco());
        return bo;
    }

    private static List<PedidoProdutoDTO> toDtoItens(List<PedidoProdutoBO> itens) {
        final List<PedidoProdutoDTO> dtoItens = new ArrayList<>();
        if (itens == null) {
            return dtoItens;
        }

        for (PedidoProdutoBO item : itens) {
            dtoItens.add(toDto(item));
        }

        return dtoItens;
    }

    private static PedidoProdutoDTO toDto(PedidoProdutoBO bo) {
        final PedidoProdutoDTO dto = new PedidoProdutoDTO();
        dto.setId(bo.getId());
        dto.setQuantidade(bo.getQuantidade());
        dto.setAmount(bo.getQuantidade());
        dto.setSubtotal(bo.getSubtotal());
        dto.setProduto(toDto(bo.getProduto()));
        dto.setSku(bo.getProduto() != null ? bo.getProduto().getId() : null);
        return dto;
    }

    private static ProdutoDTO toDto(ProdutoBO bo) {
        if (bo == null) {
            return null;
        }

        final ProdutoDTO dto = new ProdutoDTO();
        dto.setId(bo.getId());
        dto.setNome(bo.getNome());
        dto.setEstoque(bo.getEstoque());
        dto.setPreco(bo.getPreco());
        return dto;
    }
}
