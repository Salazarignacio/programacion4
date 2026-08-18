package com.gestor_pedidos.service;

import com.gestor_pedidos.detallePedido.DetallePedidoCreate;
import com.gestor_pedidos.detallePedido.DetallePedidoDTO;

import java.util.List;

public interface DetallePedidoService {
    public DetallePedidoDTO save(DetallePedidoCreate detallePedidoCreate);
    public DetallePedidoDTO findById(Long id);
    public List<DetallePedidoDTO> findAll();
    public void deleteById(Long id);
}
