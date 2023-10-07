package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.unitins.topicos1.dto.FuncionarioDTO;
import br.unitins.topicos1.dto.FuncionarioResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.model.Funcionario;
import br.unitins.topicos1.repository.FuncionarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class FuncionarioServiceImpl implements FuncionarioService {

    @Inject
    FuncionarioRepository repository;

    @Inject
    Validator validator;

    private void validar(FuncionarioDTO funcionarioDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<FuncionarioDTO>> violations = validator.validate(funcionarioDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    @Override
    @Transactional
    public FuncionarioResponseDTO insert(FuncionarioDTO dto) {

        validar(dto);

        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.setNome(dto.nome());
        novoFuncionario.setEmail(dto.email());
        novoFuncionario.setSenha(dto.senha());

        if (dto.agenda() != null && !dto.agenda().isEmpty()) {
            novoFuncionario.setAgenda(new ArrayList<Telefone>());
            for (TelefoneDTO tel : dto.agenda()) {
                Telefone telefone = new Telefone();
                telefone.setCodigoArea(tel.codigoArea());
                telefone.setNumero(tel.numero());
                novoFuncionario.getAgenda().add(telefone);
            }
        }

        repository.persist(novoFuncionario);

        return FuncionarioResponseDTO.valueOf(novoFuncionario);
    }

    @Override
    @Transactional
    public FuncionarioResponseDTO update(FuncionarioDTO dto, Long id) {
        Funcionario funcionario = repository.findById(id);
        funcionario.setEmail(dto.email());
        funcionario.setNome(dto.nome());
        funcionario.setSenha(dto.senha());

        if (dto.agenda() != null && !dto.agenda().isEmpty()) {
            funcionario.setAgenda(new ArrayList<Telefone>());
            for (TelefoneDTO tel : dto.agenda()) {
                Telefone telefone = new Telefone();
                telefone.setCodigoArea(tel.codigoArea());
                telefone.setNumero(tel.numero());
                funcionario.getAgenda().add(telefone);
            }
        }

        repository.persist(funcionario);

        return FuncionarioResponseDTO.valueOf(funcionario);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public FuncionarioResponseDTO findById(Long id) {
        return FuncionarioResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<FuncionarioResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> FuncionarioResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<FuncionarioResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> FuncionarioResponseDTO.valueOf(e)).toList();
    }

}
