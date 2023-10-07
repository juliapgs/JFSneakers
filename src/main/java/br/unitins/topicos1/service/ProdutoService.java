package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import jakarta.validation.Valid;

public interface ProdutoService {

    public ProdutoResponseDTO insert(@Valid ProdutoDTO dto);

    public ProdutoResponseDTO update(ProdutoDTO dto, Long id);

    public void delete(Long id);

    public ProdutoResponseDTO findById(Long id);

    public List<ProdutoResponseDTO> findByModelo(String modelo);

    public List<ProdutoResponseDTO> findByAll(); 
    
}
