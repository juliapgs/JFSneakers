package br.unitins.topicos1;

import org.junit.jupiter.api.Test;

import com.google.inject.Inject;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import br.unitins.topicos1.model.CategoriaProduto;
import br.unitins.topicos1.service.ProdutoService;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

@QuarkusTest
public class ProdutoResourceTest {

    @jakarta.inject.Inject
    ProdutoService produtoService;

    @Test
    public void testFindAll() {
        given()
                .when().get("/produtos")
                .then()
                .statusCode(200);
    }

    @Test
    public void testInsertProduto() {
        ProdutoDTO dto = new ProdutoDTO("Nike",
                "Air force",
                CategoriaProduto.CASUAL,
                "Branco",
                39,
                800.00);

        given()
                .contentType(ContentType.JSON)
                .body(dto)
                .when().post("/produtos")
                .then().statusCode(201)
                .body(
                        "id", notNullValue(),
                        "modelo", is("Air force"),
                        "categoria", is("CASUAL"),
                        "cor", is("Branco"),
                        "tamanho", is(39),
                        "valor", is(800.00f));
    }

    @Test
    public void testUpdateproduto() {
        ProdutoDTO dto = new ProdutoDTO("Nike",
                "Air force",
                CategoriaProduto.CASUAL,
                "Branco",
                39,
                800.00);

        ProdutoResponseDTO produtTest = produtoService.insert(dto);
        Long id = produtTest.id();

        ProdutoDTO dtoUpdate = new ProdutoDTO("Nike",
                "Air force up",
                CategoriaProduto.CASUAL,
                "Branco",
                39,
                800.00);

        given()
                .contentType(ContentType.JSON)
                .body(dtoUpdate)
                .when().post("/produtos/" + id)
                .then().statusCode(204);
    }

    @Test
    public void testDeleteProduto() {
        ProdutoDTO dto = new ProdutoDTO("Nike",
                "Air force",
                CategoriaProduto.CASUAL,
                "Branco",
                39,
                800.00);

        ProdutoResponseDTO produtTest = produtoService.insert(dto);
        Long id = produtTest.id();

        given()
                .when().delete("/produtos/" + id)
                .then().statusCode(204);
    }

    @Test
    public void testFindByNome() {
        ProdutoDTO dto = new ProdutoDTO("Nike",
                "Air force",
                CategoriaProduto.CASUAL,
                "Branco",
                39,
                800.00);

        ProdutoResponseDTO produtTest = produtoService.insert(dto);
        Long id = produtTest.id();

        given()
                .when().get("/produtos/" + id)
                .then().statusCode(200);
    }

    @Test
    public void findByMarca() {
        ProdutoDTO dto = new ProdutoDTO("Nike",
                "Air force",
                CategoriaProduto.CASUAL,
                "Branco",
                39,
                800.00);

        ProdutoResponseDTO produtTest = produtoService.insert(dto);
        String marca = produtTest.marca();

        given()
                .when().get("/produtos/" + marca)
                .then().statusCode(200);
    }

}
