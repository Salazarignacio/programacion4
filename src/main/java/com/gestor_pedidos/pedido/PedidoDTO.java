package com.gestor_pedidos.pedido;

import com.gestor_pedidos.entities.Pedido;
import com.gestor_pedidos.entities.Usuario;
import com.gestor_pedidos.enums.FormaPago;

public record PedidoDTO(FormaPago formaPago, Usuario usuario) {
    public static PedidoDTO toDTO(Pedido pedido){
        return new PedidoDTO(pedido.getFormaPago(), pedido.getUsuario());
    }
}
