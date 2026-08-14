package com.gestor_pedidos.entities;

import com.gestor_pedidos.enums.Estado;
import com.gestor_pedidos.enums.FormaPago;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Pedido extends Base implements Calculable {
    private LocalDate fecha;
    @Enumerated(EnumType.STRING)
    private Estado estado;
    private Double total;
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;
    @ManyToOne
    private Usuario usuario;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<DetallePedido> detallePedido = new HashSet<>();

    public Pedido(FormaPago formaPago, Usuario usuario) {
        super();
        this.fecha = LocalDate.now();
        this.estado = Estado.PENDIENTE;
        this.formaPago = formaPago;
        this.usuario = usuario;

    }

    public void addDetallePedido(int cantidad, Producto producto) {
        DetallePedido nuevoDetalle = new DetallePedido(cantidad, producto);
        detallePedido.add(nuevoDetalle);
        nuevoDetalle.setPedido(this);
        calcularTotal();
    }

    public DetallePedido findDetallePedidoByProducto(Producto prod){
        for(DetallePedido det : detallePedido){
            if (det.getProducto().equals(prod)) {
                System.out.println("Detalle Pedido Encontrado:  ");
                System.out.println(det);
                return det;
            }
        }
        System.out.println("No se encontro Detalle Pedido");
        return null;
    }
    public void deleteDetallePedidoByProducto(Producto prod){
        DetallePedido detalle= findDetallePedidoByProducto(prod);
        if(detalle != null){
            detallePedido.remove(detalle);
            detalle.setPedido(null);
        }

    }

    public void calcularTotal() {
        this.total = 0.0;
        for (DetallePedido detalle : detallePedido) {
            total = total + detalle.getSubtotal();
        }
        System.out.println("Total $" + total);
    }

}
