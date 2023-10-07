// package br.unitins.topicos1.resource;

// import br.unitins.topicos1.dto.CarrinhoResponseDTO;
// import br.unitins.topicos1.dto.ProdutoDTO;
// import br.unitins.topicos1.service.CarrinhoService;
// import jakarta.inject.Inject;
// import jakarta.transaction.Transactional;
// import jakarta.validation.Valid;
// import jakarta.ws.rs.Consumes;
// import jakarta.ws.rs.DELETE;
// import jakarta.ws.rs.GET;
// import jakarta.ws.rs.POST;
// import jakarta.ws.rs.Path;
// import jakarta.ws.rs.PathParam;
// import jakarta.ws.rs.Produces;
// import jakarta.ws.rs.core.MediaType;
// import jakarta.ws.rs.core.Response;
// import jakarta.ws.rs.core.Response.Status;

// @Path("/carrinho")
// @Produces(MediaType.APPLICATION_JSON)
// @Consumes(MediaType.APPLICATION_JSON)
// public class CarrinhoResource {

//     @Inject
//     CarrinhoService service;

//     @POST
//     @Transactional
//     public Response adicionarProduto(@Valid ProdutoDTO produtoDTO) {
//         service.adicionarProduto(produtoDTO);
//         return Response.status(Status.CREATED).build();
//     }

//     // @DELETE
//     // @Transactional
//     // @Path("/{id}")
//     // public Response removerProduto(@PathParam("id") Long id) {
//     //     service.removerProduto(id);
//     //     return Response.status(Status.NO_CONTENT).build();
//     // }

//     @GET
//     public Response listarProdutosNoCarrinho() {
//         CarrinhoResponseDTO carrinhoResponseDTO = service.listarProdutosNoCarrinho();
//         return Response.ok(carrinhoResponseDTO).build();
//     }
// }
