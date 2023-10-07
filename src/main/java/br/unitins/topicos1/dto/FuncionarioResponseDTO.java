package br.unitins.topicos1.dto;

import java.util.List;
import br.unitins.topicos1.model.Funcionario;

public record FuncionarioResponseDTO(
        Long id,
        String nome,
        String email,
        String senha,
        List<TelefoneDTO> agenda) {

    public static FuncionarioResponseDTO valueOf(Funcionario funcionario) {

        return new FuncionarioResponseDTO(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getEmail(),
                funcionario.getSenha(),
                funcionario.getAgenda()
                        .stream()
                        .map(t -> TelefoneDTO.valueOf(t))
                        .toList());
    }
}
