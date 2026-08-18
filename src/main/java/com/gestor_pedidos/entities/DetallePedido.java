package com.gestor_pedidos.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DetallePedido extends Base {
    private int cantidad;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "detalle_pedido")
    private Pedido pedido;
    private Double subtotal;

    public DetallePedido(int cantidad, Producto producto) {
        super();
        this.cantidad = cantidad;
        this.producto = producto;
        this.subtotal = cantidad * producto.getPrecio();
    }


}
