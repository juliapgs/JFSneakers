// package br.unitins.topicos1;

// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.http.ContentType;
// import jakarta.inject.Inject;
// import org.junit.jupiter.api.Test;

// import br.unitins.topicos1.dto.PedidoDTO;
// import br.unitins.topicos1.dto.PedidoResponseDTO;
// import br.unitins.topicos1.model.FormaPagamento;
// import br.unitins.topicos1.service.PedidoService;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.CoreMatchers.notNullValue;
// import static org.hamcrest.MatcherAssert.assertThat;

// @QuarkusTest
// public class PedidoResourceTest {

// @Inject
// PedidoService pedidoService;

// @Test
// public void testFindAll() {
// given()
// .when().get("/pedidos")
// .then()
// .statusCode(200);
// }

// @Test
// public void testInsert() {
// PedidoDTO dto = new PedidoDTO(
// "Nome do Cliente",
// FormaPagamento.BOLETO, // Forma de pagamento
// 100.00f // Valor total
// );

// given()
// .contentType(ContentType.JSON)
// .body(dto)
// .when().post("/pedidos")
// .then()
// .statusCode(201)
// .body(
// "id", notNullValue(),
// "nomeCliente", is("Nome do Cliente"),
// "formaPagamento", is("BOLETO"),
// "valorTotal", is(100.00f));
// }

// @Test
// public void testUpdate() {
// PedidoDTO dto = new PedidoDTO(
// "Nome do Cliente Atualizado",
// FormaPagamento.BOLETO, // Forma de pagamento atualizada
// 200.00f // Valor total atualizado
// );

// // Inserindo um pedido
// PedidoResponseDTO pedidoTest = pedidoService.insert(dto);
// Long id = pedidoTest.getId();

// PedidoDTO dtoUpdate = new PedidoDTO(
// "Nome do Cliente Modificado",
// FormaPagamento.BOLETO, // Forma de pagamento modificada
// 300.00f // Valor total modificado
// );

// given()
// .contentType(ContentType.JSON)
// .body(dtoUpdate)
// .when().put("/pedidos/" + id)
// .then()
// .statusCode(200)
// .body(
// "id", is(id.intValue()),
// "nomeCliente", is("Nome do Cliente Modificado"),
// "formaPagamento", is("DEBITO"),
// "valorTotal", is(300.00f));
// }

// @Test
// public void testDelete() {
// PedidoDTO dto = new PedidoDTO(
// "Cliente para Exclusão",
// FormaPagamento.DINHEIRO, // Forma de pagamento para exclusão
// 50.00f // Valor total para exclusão
// );

// // Inserindo um pedido para exclusão
// PedidoResponseDTO pedidoTest = pedidoService.insert(dto);
// Long id = pedidoTest.getId();

// given()
// .when().delete("/pedidos/" + id)
// .then()
// .statusCode(204);
// }
// }