package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.FormaPagamento;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.model.StatusPedido;
import java.time.LocalDate;

public record PedidoResponseDTO(
    Long id,
    Long clienteId,
    Long produtoId,
    LocalDate dataCompra,
    FormaPagamento formaPagamento,
    StatusPedido statusPedido
) { 
    public static PedidoResponseDTO valueOf(Pedido pedido){
        return new PedidoResponseDTO(
            pedido.getId(),
            pedido.getClienteId(),
            pedido.getProdutoId(),
            pedido.getDataCompra(),
            pedido.getFormaPagamento(),
            pedido.getStatusPedido());
    }
}
