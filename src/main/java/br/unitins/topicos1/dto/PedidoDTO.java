package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.FormaPagamento;
import br.unitins.topicos1.model.StatusPedido;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class PedidoDTO {

    @NotNull(message = "O campo cliente não pode ser nulo.")
    private Long clienteId;

    @NotNull(message = "O campo produto não pode ser nulo.")
    private Long produtoId;

    @NotNull(message = "O campo dataCompra não pode ser nulo.")
    private LocalDate dataCompra;

    @NotNull(message = "O campo formaPagamento não pode ser nulo.")
    private FormaPagamento formaPagamento;

    @NotNull(message = "O campo statusPedido não pode ser nulo.")
    private StatusPedido statusPedido;

    public PedidoDTO( Long clienteId, Long produtoId, LocalDate dataCompra, FormaPagamento formaPagamento, StatusPedido statusPedido) {
        this.clienteId = clienteId;
        this.produtoId = produtoId;
        this.dataCompra = dataCompra;
        this.formaPagamento = formaPagamento;
        this.statusPedido = statusPedido;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
   
    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
