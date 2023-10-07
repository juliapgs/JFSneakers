package br.unitins.topicos1.dto;

import java.util.List;

public record ClienteDTO(
        String nome,
        String email,
        String senha,
        List<TelefoneDTO> agenda) {

}