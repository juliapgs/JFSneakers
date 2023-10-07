package br.unitins.topicos1.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.unitins.topicos1.dto.ClienteDTO;
import br.unitins.topicos1.dto.ClienteResponseDTO;
import br.unitins.topicos1.dto.TelefoneDTO;
import br.unitins.topicos1.model.Telefone;
import br.unitins.topicos1.model.Cliente;
import br.unitins.topicos1.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {

    @Inject
    ClienteRepository repository;

    @Inject
    Validator validator;

    private void validar(ClienteDTO clienteDTO) throws ConstraintViolationException {
        Set<ConstraintViolation<ClienteDTO>> violations = validator.validate(clienteDTO);

        if (!violations.isEmpty())
            throw new ConstraintViolationException(violations);
    }

    @Override
    @Transactional
    public ClienteResponseDTO insert(ClienteDTO dto) {

        validar(dto);

        Cliente novoCliente = new Cliente();
        novoCliente.setNome(dto.nome());
        novoCliente.setEmail(dto.email());
        novoCliente.setSenha(dto.senha());

        if (dto.listaTelefone() != null &&
                !dto.listaTelefone().isEmpty()) {
            novoCliente.setListaTelefone(new ArrayList<Telefone>());
            for (TelefoneDTO tel : dto.listaTelefone()) {
                Telefone telefone = new Telefone();
                telefone.setCodigoArea(tel.codigoArea());
                telefone.setNumero(tel.numero());
                novoCliente.getListaTelefone().add(telefone);
            }
        }

        repository.persist(novoCliente);

        return ClienteResponseDTO.valueOf(novoCliente);
    }

    @Override
    @Transactional
    public ClienteResponseDTO update(ClienteDTO dto, Long id) {
        Cliente cliente = repository.findById(id);
        cliente.setEmail(dto.email());
        cliente.setNome(dto.nome());
        cliente.setSenha(dto.senha());

        // falta a implementacao dos telefones
        // vcs (ALUNOS) devem implementar!!!!!

        return ClienteResponseDTO.valueOf(cliente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id))
            throw new NotFoundException();
    }

    @Override
    public ClienteResponseDTO findById(Long id) {
        return ClienteResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<ClienteResponseDTO> findByNome(String nome) {
        return repository.findByNome(nome).stream()
                .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ClienteResponseDTO> findByAll() {
        return repository.listAll().stream()
                .map(e -> ClienteResponseDTO.valueOf(e)).toList();
    }
}
