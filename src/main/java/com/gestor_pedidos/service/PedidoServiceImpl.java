package com.gestor_pedidos.service;

import com.gestor_pedidos.entities.Pedido;
import com.gestor_pedidos.entities.Usuario;
import com.gestor_pedidos.enums.FormaPago;
import com.gestor_pedidos.pedido.PedidoDTO;
import com.gestor_pedidos.repository.PedidoRepository;
import com.gestor_pedidos.repository.UsuarioRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PedidoServiceImpl implements PedidoService {
    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;
    @Override
    public PedidoDTO save(FormaPago formaPago, Long idUsuario){
        Usuario usuarioEncontrado = usuarioRepository.findById(idUsuario).orElseThrow(()->new NullPointerException("No se ecnontro usuario con ID: " + idUsuario));
        Pedido pedido = new Pedido(formaPago,usuarioEncontrado);
        pedido = pedidoRepository.save(pedido);
        return PedidoDTO.toDTO(pedido);
    }
    @Override
    public PedidoDTO findById(Long id){
        Pedido pedidoEncontrado = pedidoRepository.findById(id).orElseThrow(()->new NullPointerException("No se encontro pedido con ID: " + id));
        return PedidoDTO.toDTO(pedidoEncontrado);
    }

    @Override
    public List<PedidoDTO> findAll() {
        List<Pedido> pedidos = pedidoRepository.findAll();
        return pedidos.stream().map(PedidoDTO::toDTO).toList();
    }
    @Override
    public PedidoDTO update(Pedido pedido, Long id){
        Pedido pedidoEncontrado = pedidoRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro pedido con ID: " + id));
        pedidoEncontrado = pedidoRepository.save(pedido);
        return  PedidoDTO.toDTO(pedidoEncontrado);
    }
    @Override
    public void deleteById(Long id){
        Pedido pedidoEncontrado = pedidoRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro pedido con ID: " + id));
        pedidoEncontrado.setEliminado(true);
        pedidoRepository.save(pedidoEncontrado);
    }
}
