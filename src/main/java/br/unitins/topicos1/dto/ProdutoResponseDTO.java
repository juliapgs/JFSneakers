package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.CategoriaProduto;
import br.unitins.topicos1.model.Produto;

public record ProdutoResponseDTO(
    Long id,
    String marca,
    String modelo,
    CategoriaProduto categoriaProduto,
    String cor,
    Integer tamanho,
    Double valor
) { 
    public static ProdutoResponseDTO valueOf(Produto produto){
        return new ProdutoResponseDTO(
            produto.getId(),
            produto.getMarca(),
            produto.getModelo(),
            produto.getCategoria(),
            produto.getCor(),
            produto.getTamanho(),
            produto.getValor());
    }
}
