package br.unitins.topicos1.dto;

import java.util.List;

import br.unitins.topicos1.model.Perfil;
import br.unitins.topicos1.model.Usuario;

public record UsuarioResponseDTO(
    Long id,
    String nome,
    String email,
    String login,
    Perfil perfil,
    List<TelefoneDTO> agenda
) { 
    public static UsuarioResponseDTO valueOf(Usuario usuario){

        return new UsuarioResponseDTO(
            usuario.getId(), 
            usuario.getNome(),
            usuario.getEmail(),
            usuario.getLogin(),
            usuario.getPerfil(),
            usuario.getAgenda()
                .stream()
                .map(t -> TelefoneDTO.valueOf(t)).toList()
        );
    }
}