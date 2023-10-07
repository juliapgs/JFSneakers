package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;

public interface ClienteService {
    public ClienteResponseDTO insert(ClienteDTO dto);

    public ClienteResponseDTO findById(Long id);

    public ClienteResponseDTO update(ClienteDTO dto, Long id);

    public void delete(Long id);

    public List<ClienteResponseDTO> findByAll();

    public List<ClienteResponseDTO> findByNome(String nome);
}
