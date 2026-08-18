package com.gestor_pedidos.service;

import com.gestor_pedidos.detallePedido.DetallePedidoCreate;
import com.gestor_pedidos.detallePedido.DetallePedidoDTO;
import com.gestor_pedidos.entities.DetallePedido;
import com.gestor_pedidos.repository.DetallePedidoRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DetallePedidoServiceImpl implements DetallePedidoService{
    private final DetallePedidoRepository detallePedidoRepository;

    @Override
    public DetallePedidoDTO save(DetallePedidoCreate detallePedidoCreate){
        DetallePedido detallePedido = detallePedidoRepository.save(detallePedidoCreate.toEntity());
        return  DetallePedidoDTO.toDTO(detallePedido);
    }

    @Override
    public DetallePedidoDTO findById(Long id){
        DetallePedido detallePedido = detallePedidoRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro detalle pedido con ID: " + id));
        return  DetallePedidoDTO.toDTO(detallePedido);
    }
    @Override
    public List<DetallePedidoDTO> findAll(){
        List<DetallePedido> detalles = detallePedidoRepository.findAll();
        return detalles.stream().map(DetallePedidoDTO::toDTO).toList();
    }

    public void deleteById(Long id){
        DetallePedido detallePedido = detallePedidoRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro detalle pedido con ID: " + id));
        detallePedido.setEliminado(true);
        detallePedidoRepository.save(detallePedido);
    }
}
