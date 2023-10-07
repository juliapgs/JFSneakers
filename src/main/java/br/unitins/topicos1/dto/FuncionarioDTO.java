package br.unitins.topicos1.dto;

import java.util.List;

public record FuncionarioDTO(
                String nome,
                String email,
                String senha,
                List<TelefoneDTO> listaTelefone) {

}