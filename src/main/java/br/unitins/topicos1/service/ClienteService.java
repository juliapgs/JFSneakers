package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import jakarta.ejb.ConcurrentAccessException;
import jakarta.validation.Valid;

public interface ClienteService {
    public ClienteResponseDTO insert(@Valid ClienteDTO dto) throws ConcurrentAccessException;

    public ClienteResponseDTO findById(Long id);

    public ClienteResponseDTO update(ClienteDTO dto, Long id);

    public void delete(Long id);

    public List<ClienteResponseDTO> findByAll();

    public List<ClienteResponseDTO> findByNome(String nome);
}
