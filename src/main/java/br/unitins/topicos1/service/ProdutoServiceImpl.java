package br.unitins.topicos1.service;

import java.util.List;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import br.unitins.topicos1.model.Produto;
import br.unitins.topicos1.repository.ProdutoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

@ApplicationScoped
public class ProdutoServiceImpl implements ProdutoService {

    @Inject
    ProdutoRepository repository;

    @Override
    @Transactional
    public ProdutoResponseDTO insert(ProdutoDTO dto) {
        Produto novoProduto = new Produto();
        novoProduto.setMarca(dto.getMarca());
        novoProduto.setModelo(dto.getModelo());
        novoProduto.setCategoria(dto.getCategoriaProduto());
        novoProduto.setCor(dto.getCor());
        novoProduto.setTamanho(dto.getTamanho());
        novoProduto.setValor(dto.getValor());
        
        repository.persist(novoProduto);

        return ProdutoResponseDTO.valueOf(novoProduto);
    }

    @Override
    @Transactional
    public ProdutoResponseDTO update(ProdutoDTO dto, Long id) {
        
        Produto produto = repository.findById(id);
        if (produto != null) {
            produto.setMarca(dto.getMarca());
            produto.setModelo(dto.getModelo());
            produto.setCategoria(dto.getCategoriaProduto());
            produto.setCor(dto.getCor());
            produto.setTamanho(dto.getTamanho());
            produto.setValor(dto.getValor());
        } else 
            throw new NotFoundException();

        return ProdutoResponseDTO.valueOf(produto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id)) 
            throw new NotFoundException();
    }

    @Override
    public ProdutoResponseDTO findById(Long id) {
        return ProdutoResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<ProdutoResponseDTO> findByModelo(String modelo) {
        return repository.findByNome(modelo).stream()
            .map(e -> ProdutoResponseDTO.valueOf(e)).toList();
    }

    @Override
    public List<ProdutoResponseDTO> findByAll() {
        return repository.listAll().stream()
            .map(e -> ProdutoResponseDTO.valueOf(e)).toList();
    }
    
}
