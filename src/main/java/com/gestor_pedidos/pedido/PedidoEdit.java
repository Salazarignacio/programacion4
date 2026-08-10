package com.gestor_pedidos.pedido;

import com.gestor_pedidos.entities.Pedido;
import com.gestor_pedidos.entities.Usuario;
import com.gestor_pedidos.enums.FormaPago;

public record PedidoEdit(FormaPago formaPago, Usuario usuario) {
    public void applyTo(Pedido pedido) {
        if (pedido.getFormaPago() != null) {
            pedido.setFormaPago(formaPago);
        }
        if (pedido.getUsuario() != null) {
            pedido.setUsuario(usuario);
        }
    }
}
