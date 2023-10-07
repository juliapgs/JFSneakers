package br.unitins.topicos1;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import br.unitins.topicos1.service.ProdutoService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@QuarkusTest
public class ProdutoResourceTest {

    @Inject
    ProdutoService produtoService;

    @Test
    public void testFindAll() {
        given()
          .when().get("/produtos")
          .then()
             .statusCode(200);
    }

    @Test
    public void testInsert() {
        ProdutoDTO dto = new ProdutoDTO(
            "Nome do Produto",
            "Descrição do Produto",
            10.99 // Preço do Produto
        );

        given()
            .contentType(ContentType.JSON)
            .body(dto)
            .when().post("/produtos")
            .then()
            .statusCode(201)
            .body(
                "id", notNullValue(),
                "nome", is("Nome do Produto"),
                "descricao", is("Descrição do Produto"),
                "preco", is(10.99f)
            );
    }

    @Test
    public void testUpdate() {
        ProdutoDTO dto = new ProdutoDTO(
            "Nome do Produto Atualizado",
            "Descrição do Produto Atualizado",
            20.99 // Preço do Produto Atualizado
        );

        // Inserindo um produto
        ProdutoResponseDTO produtoTest = produtoService.insert(dto);
        Long id = produtoTest.getId();

        ProdutoDTO dtoUpdate = new ProdutoDTO(
            "Nome do Produto Modificado",
            "Descrição do Produto Modificado",
            30.99 // Preço do Produto Modificado
        );

        given()
            .contentType(ContentType.JSON)
            .body(dtoUpdate)
            .when().put("/produtos/" + id)
            .then()
            .statusCode(204);

        // Verificando a alteração
        ProdutoResponseDTO prod = produtoService.findById(id);
        assertThat(prod.getNome(), is("Nome do Produto Modificado"));
        assertThat(prod.getDescricao(), is("Descrição do Produto Modificado"));
        assertThat(prod.getPreco(), is(30.99f));
    }

    @Test
    public void testDelete() {
        ProdutoDTO dto = new ProdutoDTO(
            "Produto para Exclusão",
            "Descrição do Produto para Exclusão",
            15.99 // Preço do Produto para Exclusão
        );

        // Inserindo um produto para exclusão
        ProdutoResponseDTO produtoTest = produtoService.insert(dto);
        Long id = produtoTest.getId();

        given()
            .when().delete("/produtos/" + id)
            .then()
            .statusCode(204);
    }
}
