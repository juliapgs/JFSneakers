package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.FormaPagamento;
import br.unitins.topicos1.model.StatusPedido;
import java.time.LocalDate;

public class PedidoDTO {

    private Long usuarioId;
    private Long produtoId;
    private Long enderecoId;
    private LocalDate dataCompra;
    private FormaPagamento formaPagamento;
    private StatusPedido statusPedido;

    public Long getProdutoId() { // Adicione este método
        return produtoId;
    }

    public void setProdutoId(Long produtoId) { // Adicione este método
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

    public Long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(Long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
