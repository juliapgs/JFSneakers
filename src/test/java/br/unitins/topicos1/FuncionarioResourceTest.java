package br.unitins.topicos1;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.google.inject.Inject;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.service.FuncionarioService;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class FuncionarioResourceTest {
    @Inject
    FuncionarioService funcionariosService;

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
                        "nome", is("Julinda insert"),
                        "email", is("julindainsert@gmail.com"),
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

        FuncionarioResponseDTO funcionarioTest = funcionariosService.insert(dto);
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
                .statusCode(204);
    }
}
