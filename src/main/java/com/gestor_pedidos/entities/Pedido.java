package com.gestor_pedidos.entities;

import com.gestor_pedidos.enums.Estado;
import com.gestor_pedidos.enums.FormaPago;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    private Estado estado;
    private Double total;
    private FormaPago formaPago;
    @ManyToOne
    private Usuario usuario;
    private static Set<DetallePedido> detallePedido = new HashSet<>();

    public Pedido( Estado estado, FormaPago formaPago, Usuario usuario) {
        super();
        this.fecha = LocalDate.now();
        this.estado = estado;
        this.formaPago = formaPago;
        this.usuario = usuario;

    }

    public void addDetallePedido(int cantidad, Producto producto) {
        DetallePedido nuevoDetalle = new DetallePedido(cantidad, producto);
        detallePedido.add(nuevoDetalle);
    }

public void calcularTotal(){
    Double total = 0.0;
        for (DetallePedido detalle : detallePedido) {
        total = total + detalle.getSubtotal();
    }
    System.out.println("Total $" + total);
}

}
