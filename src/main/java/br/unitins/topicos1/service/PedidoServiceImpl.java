package br.unitins.topicos1.service;

import br.unitins.topicos1.dto.PedidoDTO;
import br.unitins.topicos1.dto.PedidoResponseDTO;
import br.unitins.topicos1.model.FormaPagamento;
import br.unitins.topicos1.model.Pedido;
import br.unitins.topicos1.repository.PedidoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class PedidoServiceImpl implements PedidoService {

    @Inject
    PedidoRepository repository;

    @Inject
    ClienteService clienteService;

    @Inject
    PedidoService pedidoService;

    @Override
    @Transactional
    public PedidoResponseDTO insert(PedidoDTO dto) {
        Pedido novoPedido = new Pedido();
        novoPedido.setDataCompra(dto.getDataCompra());
        novoPedido.setFormaPagamento(dto.getFormaPagamento());
        novoPedido.setStatusPedido(dto.getStatusPedido());

        novoPedido.setClienteId(dto.getClienteId());
        novoPedido.setProdutoId(dto.getProdutoId());

        repository.persist(novoPedido);

        return PedidoResponseDTO.valueOf(novoPedido);
    }

    @Override
    @Transactional
    public PedidoResponseDTO update(PedidoDTO dto, Long id) {
        Pedido pedido = repository.findById(id);
        if (pedido != null) {
            pedido.setDataCompra(dto.getDataCompra());
            pedido.setFormaPagamento(dto.getFormaPagamento());
            pedido.setStatusPedido(dto.getStatusPedido());

            pedido.setClienteId(dto.getClienteId());
            pedido.setProdutoId(dto.getProdutoId());
        } else {
            throw new NotFoundException();
        }

        return PedidoResponseDTO.valueOf(pedido);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.deleteById(id)) {
            throw new NotFoundException();
        }
    }

    @Override
    public PedidoResponseDTO findById(Long id) {
        return PedidoResponseDTO.valueOf(repository.findById(id));
    }

    @Override
    public List<PedidoResponseDTO> findAll() {
        List<Pedido> pedidos = repository.listAll();
        return pedidos.stream()
                .map(PedidoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    public List<PedidoResponseDTO> findByFormaPagamento(FormaPagamento formaPagamento) {
        List<Pedido> pedidos = repository.list("formaPagamento", formaPagamento);
        return pedidos.stream()
                .map(PedidoResponseDTO::valueOf)
                .collect(Collectors.toList());
    }
}
