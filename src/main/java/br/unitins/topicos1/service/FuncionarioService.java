package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import jakarta.validation.ConstraintDeclarationException;
import jakarta.validation.Valid;

public interface FuncionarioService {
    public FuncionarioResponseDTO insert(@Valid FuncionarioDTO dto) throws ConstraintDeclarationException;

    public FuncionarioResponseDTO findById(Long id);

    public FuncionarioResponseDTO update(FuncionarioDTO dto, Long id);

    public void delete(Long id);

    public List<FuncionarioResponseDTO> findByAll();

    public List<FuncionarioResponseDTO> findByNome(String nome);
}
