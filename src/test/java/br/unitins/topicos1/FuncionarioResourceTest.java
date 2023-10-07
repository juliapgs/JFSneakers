package br.unitins.topicos1;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.service.FuncionarioService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;

@QuarkusTest
public class FuncionarioResourceTest {

        @Inject
        FuncionarioService funcionarioService;

        @Test
        public void testFindAll() {
                given()
                                .when().get("/funcionarios")
                                .then()
                                .statusCode(200);
        }

        @Test
        public void testInsertFuncionario() {
                List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
                telefones.add(new TelefoneDTO("63", "33333333"));

                FuncionarioDTO dto = new FuncionarioDTO(
                                "Julinda",
                                "julinda@gmail.com",
                                "1234", telefones);

                given()
                                .contentType(ContentType.JSON)
                                .body(dto)
                                .when().post("/funcionarios")
                                .then()
                                .statusCode(201)
                                .body(
                                                "id", notNullValue(),
                                                "nome", is("Julinda"),
                                                "email", is("julinda@gmail.com"),
                                                "senha", is("1234"));
        }

        @Test
        public void testUpdateFuncionario() {
                List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
                telefones.add(new TelefoneDTO("63", "33333333"));

                FuncionarioDTO dto = new FuncionarioDTO(
                                "julinda",
                                "julinda@gmail.com",
                                "5678",
                                telefones);

                FuncionarioResponseDTO funcionarioTest = funcionarioService.insert(dto);
                Long id = funcionarioTest.id();

                FuncionarioDTO dtoUpdate = new FuncionarioDTO(
                                "Julinda insert",
                                "julindainsert@gmail.com",
                                "5678",
                                telefones);

                given()
                                .contentType(ContentType.JSON)
                                .body(dtoUpdate)
                                .when().put("/funcionario/" + id)
                                .then()
                                .statusCode(404);
        }

        @Test
        public void testDelete() {
                List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
                telefones.add(new TelefoneDTO("63", "33333333"));

                FuncionarioDTO dto = new FuncionarioDTO(
                                "Julinda insert",
                                "julindainsert@gmail.com",
                                "9874",
                                telefones);

                FuncionarioResponseDTO funcionarioTest = funcionarioService.insert(dto);
                Long id = funcionarioTest.id();

                given()
                                .when().delete("/funcionarios/" + id)
                                .then()
                                .statusCode(204);

        }

        @Test
        public void testeFindById() {
                List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
                telefones.add(new TelefoneDTO("63", "33333333"));

                FuncionarioDTO dto = new FuncionarioDTO(
                                "Julinda insert",
                                "julindaid@gmail.com",
                                "0304",
                                telefones);

                FuncionarioResponseDTO funcionarioTest = funcionarioService.insert(dto);
                Long id = funcionarioTest.id();

                given()
                                .when().get("/funcionario/" + id)
                                .then()
                                .statusCode(404);
        }

        @Test
        public void testeFindByNome() {
                List<TelefoneDTO> telefones = new ArrayList<TelefoneDTO>();
                telefones.add(new TelefoneDTO("63", "33333333"));

                FuncionarioDTO dto = new FuncionarioDTO(
                                "Julinda nome",
                                "julindanome@gmail.com",
                                "3404",
                                telefones);

                FuncionarioResponseDTO funcionarioTest = funcionarioService.insert(dto);
                String nome = funcionarioTest.nome();

                given()
                                .when().get("/funcionarios/search/nome/" + nome)
                                .then()
                                .statusCode(200);
        }

}
