package com.gestor_pedidos.detallePedido;

import com.gestor_pedidos.entities.DetallePedido;
import com.gestor_pedidos.entities.Producto;

public record DetallePedidoCreate(int cantidad, Producto producto) {
    public DetallePedido toEntity() {
        return new DetallePedido(cantidad, producto);
    }
}
