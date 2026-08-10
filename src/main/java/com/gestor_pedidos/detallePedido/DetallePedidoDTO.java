package com.gestor_pedidos.detallePedido;

import com.gestor_pedidos.entities.DetallePedido;
import com.gestor_pedidos.entities.Producto;

public record DetallePedidoDTO(int cantidad, Producto producto) {
    public static DetallePedidoDTO toDTO(DetallePedido detallePedido) {
        return new DetallePedidoDTO(detallePedido.getCantidad(), detallePedido.getProducto());
    }
}
