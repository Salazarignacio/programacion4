package com.gestor_pedidos.service;

import com.gestor_pedidos.entities.Pedido;
import com.gestor_pedidos.enums.FormaPago;
import com.gestor_pedidos.pedido.PedidoDTO;
import com.gestor_pedidos.pedido.PedidoEdit;

import java.util.List;

public interface PedidoService {
    public PedidoDTO save(FormaPago formaPago, Long idUsuario);
    public PedidoDTO findById(Long id);
    public List<PedidoDTO> findAll();
    public PedidoDTO update(PedidoEdit pedidoEdit, Long id);
    public void deleteById(Long id);
}
