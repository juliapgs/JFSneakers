// package br.unitins.topicos1;

// import io.quarkus.test.junit.QuarkusTest;
// import io.restassured.http.ContentType;
// import jakarta.inject.Inject;

// import br.unitins.topicos1.dto.ClienteDTO;
// import br.unitins.topicos1.dto.ClienteResponseDTO;
// import br.unitins.topicos1.dto.TelefoneDTO;
// import br.unitins.topicos1.service.ClienteService;

// import static io.restassured.RestAssured.given;
// import static org.hamcrest.CoreMatchers.is;
// import static org.hamcrest.CoreMatchers.notNullValue;

// import java.util.ArrayList;
// import java.util.List;

// import org.junit.jupiter.api.Test;

// @QuarkusTest
// public class GreetingResourceTest {

//         @Inject
//         ClienteService clienteService;

//         @Test
//         public void testFindAll() {
//                 given()
//                                 .when().get("/clientes")
//                                 .then()
//                                 .statusCode(200);
//         }

//         @Test
//         public void testInsert() {
//                 List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
//                 telefones.add(new TelefoneDTO("63", "33333333"));

//                 ClienteDTO dto = new ClienteDTO(
//                                 "Julinda",
//                                 "julinda@gmail.com",
//                                 "1234", telefones);

//                 given()
//                                 .contentType(ContentType.JSON)
//                                 .body(dto)
//                                 .when().post("/clientes")
//                                 .then()
//                                 .statusCode(201)
//                                 .body(
//                                                 "id", notNullValue(),
//                                                 "nome", is("Julinda"),
//                                                 "email", is("julinda@gmail.com"),
//                                                 "senha", is("1234"));
//         }

//         @Test
//         public void testUpdate() {
//                 List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
//                 telefones.add(new TelefoneDTO("63", "33333333"));

//                 ClienteDTO dto = new ClienteDTO(
//                                 "julinda",
//                                 "julinda@gmail.com",
//                                 "5678",
//                                 telefones);

//                 ClienteResponseDTO clienteTest = clienteService.insert(dto);
//                 Long id = clienteTest.id();

//                 ClienteDTO dtoUpdate = new ClienteDTO(
//                                 "Julinda insert",
//                                 "julindainsert@gmail.com",
//                                 "5678",
//                                 telefones);

//                 given()
//                                 .contentType(ContentType.JSON)
//                                 .body(dtoUpdate)
//                                 .when().put("/clientes/" + id)
//                                 .then()
//                                 .statusCode(204);
//         }

//         @Test
//         public void testDelete() {
//                 List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
//                 telefones.add(new TelefoneDTO("63", "33333333"));

//                 ClienteDTO dto = new ClienteDTO(
//                                 "Julinda insert",
//                                 "julindainsert@gmail.com",
//                                 "9874",
//                                 telefones);

//                 ClienteResponseDTO clienteTest = clienteService.insert(dto);
//                 Long id = clienteTest.id();

//                 given()
//                                 .when().delete("/clientes/" + id)
//                                 .then()
//                                 .statusCode(204);

//         }

//         @Test
//         public void testeFindById() {
//                 List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
//                 telefones.add(new TelefoneDTO("63", "33333333"));

//                 ClienteDTO dto = new ClienteDTO(
//                                 "Julinda insert",
//                                 "julindaid@gmail.com",
//                                 "0304",
//                                 telefones);

//                 ClienteResponseDTO clienteTest = clienteService.insert(dto);
//                 Long id = clienteTest.id();

//                 given()
//                                 .when().get("/clientes/" + id)
//                                 .then()
//                                 .statusCode(200);
//         }

//         @Test
//         public void testeFindByNome() {
//                 List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
//                 telefones.add(new TelefoneDTO("63", "33333333"));

//                 ClienteDTO dto = new ClienteDTO(
//                                 "Julinda nome",
//                                 "julindanome@gmail.com",
//                                 "3404",
//                                 telefones);

//                 ClienteResponseDTO clienteTest = clienteService.insert(dto);
//                 String nome = clienteTest.nome();

//                 given()
//                                 .when().get("/clientes/search/nome/" + nome)
//                                 .then()
//                                 .statusCode(200);
//         }
// }