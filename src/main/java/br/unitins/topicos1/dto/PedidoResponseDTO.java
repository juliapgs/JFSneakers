package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.FormaPagamento;
import br.unitins.topicos1.model.StatusPedido;
import br.unitins.topicos1.model.Pedido;
import java.time.LocalDate;

public record PedidoResponseDTO(
    Long id,
    Long usuarioId,
    Long produtoId,
    Long enderecoId,
    LocalDate dataCompra,
    FormaPagamento formaPagamento,
    StatusPedido statusPedido
) {
    public static PedidoResponseDTO valueOf(Pedido pedido){
        return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getUsuarioId(),
            pedido.getProdutoId(),
            pedido.getEnderecoId(),
            pedido.getDataCompra(),
            pedido.getFormaPagamento(),
            pedido.getStatusPedido()
        );
    }
}
