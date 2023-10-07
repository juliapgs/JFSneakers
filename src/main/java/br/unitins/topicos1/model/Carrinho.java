// package br.unitins.topicos1.model;

// import java.util.ArrayList;
// import java.util.List;

// public class Carrinho {
//     private List<Produto> produtos;
//     private double valorTotal;

//     public Carrinho() {
//         produtos = new ArrayList<>();
//         valorTotal = 0.0;
//     }

//     public List<Produto> getProdutos() {
//         return produtos;
//     }

//     public void setProdutos(List<Produto> produtos) {
//         this.produtos = produtos;
//         calcularValorTotal();
//     }

//     public double getValorTotal() {
//         return valorTotal;
//     }

//     private void calcularValorTotal() {
//         valorTotal = 0.0;
//         for (Produto produto : produtos) {
//             valorTotal += produto.getValor();
//         }
//     }
// }
