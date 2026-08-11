package com.gestor_pedidos.pedido;

import com.gestor_pedidos.entities.Pedido;
import com.gestor_pedidos.entities.Usuario;
import com.gestor_pedidos.enums.FormaPago;
import com.gestor_pedidos.usuario.UsuarioDTO;

public record PedidoDTO(FormaPago formaPago, UsuarioDTO usuarioDTO) {
    public static PedidoDTO toDTO(Pedido pedido){
        return new PedidoDTO(pedido.getFormaPago(), pedido.getUsuario() != null ? UsuarioDTO.toDTO(pedido.getUsuario()) : null);
    }
}
