// package br.unitins.topicos1;

// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.http.ContentType;
// import jakarta.inject.Inject;
// import org.junit.jupiter.api.Test;

// import br.unitins.topicos1.dto.EnderecoDTO;
// import br.unitins.topicos1.service.EnderecoService;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.CoreMatchers.notNullValue;
// import static org.hamcrest.MatcherAssert.assertThat;

// @QuarkusTest
// public class EnderecoResourceTest {

// @Inject
// EnderecoService enderecoService;

// @Test
// public void testFindAll() {
// given()
// .when().get("/enderecos")
// .then()
// .statusCode(200);
// }

// @Test
// public void testInsert() {
// EnderecoDTO dto = new EnderecoDTO("77023342",
// "Capim Shopping");

// given()
// .contentType(ContentType.JSON)
// .body(dto)
// .when().post("/enderecos")
// .then()
// .statusCode(201)
// .body(
// "id", notNullValue(),
// "cep", is("77023342"),
// "logradouro", is("Capim Shopping"));
// }

// @Test
// public void testUpdate() {
// EnderecoDTO dto = new EnderecoDTO("77023342",
// "Capim Shopping");

// EnderecoDTO enderecoTest = enderecoService.insert(dto);
// Long id = enderecoTest.getId();

// EnderecoDTO enderecoUp = new EnderecoDTO("77023382",
// "Capim Dourado Shopping");

// given()
// .contentType(ContentType.JSON)
// .body(dto)
// .when().put("/enderecos/" + id)
// .then()
// .statusCode(204);

// }

// @Test
// public void testDelete() {
// EnderecoDTO dto = new EnderecoDTO("77023342",
// "Capim Shopping");

// EnderecoDTO enderecoTest = enderecoService.insert(dto);
// Long id = enderecoTest.getId();

// given()
// .when().delete("/enderecos/" + id)
// .then()
// .statusCode(204);
// }
// }
