// package br.unitins.topicos1.service;

// import java.util.ArrayList;
// import java.util.List;
// import br.unitins.topicos1.dto.CarrinhoResponseDTO;
// import br.unitins.topicos1.dto.ProdutoDTO;
// import br.unitins.topicos1.model.Carrinho;
// import jakarta.enterprise.context.ApplicationScoped;
// import jakarta.transaction.Transactional;
// import jakarta.ws.rs.NotFoundException;

// @ApplicationScoped
// public class CarrinhoServiceImpl implements CarrinhoService {
//     private final List<ProdutoDTO> produtosNoCarrinho = new ArrayList<>();

//     @Override
//     @Transactional
//     public void adicionarProduto(ProdutoDTO produtoDTO) {
//         produtosNoCarrinho.add(produtoDTO);
//     }

//     // @Override
//     // @Transactional
//     // public void removerProduto(Long id) {
//     //     boolean removed = produtosNoCarrinho.removeIf(produtoDTO -> produtoDTO.getId().equals(id));
//     //     if (!removed) {
//     //         throw new NotFoundException("Produto não encontrado no carrinho.");
//     //     }
//     // }

//     @Override
//     public CarrinhoResponseDTO listarProdutosNoCarrinho() {
//         double valorTotal = calcularValorTotal();
//         return new CarrinhoResponseDTO(produtosNoCarrinho, valorTotal);
//     }

//     private double calcularValorTotal() {
//         double valorTotal = 0.0;
//         for (ProdutoDTO produtoDTO : produtosNoCarrinho) {
//             valorTotal += produtoDTO.getValor();
//         }
//         return valorTotal;
//     }
// }
