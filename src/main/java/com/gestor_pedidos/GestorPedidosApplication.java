package com.gestor_pedidos;

import com.gestor_pedidos.categoria.CategoriaCreate;
import com.gestor_pedidos.categoria.CategoriaDTO;
import com.gestor_pedidos.entities.Categoria;
import com.gestor_pedidos.entities.Pedido;
import com.gestor_pedidos.entities.Producto;
import com.gestor_pedidos.entities.Usuario;
import com.gestor_pedidos.enums.Estado;
import com.gestor_pedidos.enums.FormaPago;
import com.gestor_pedidos.enums.Rol;
import com.gestor_pedidos.pedido.PedidoDTO;
import com.gestor_pedidos.producto.ProductoCreate;
import com.gestor_pedidos.producto.ProductoDTO;
import com.gestor_pedidos.usuario.UsuarioCreate;
import com.gestor_pedidos.usuario.UsuarioDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GestorPedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestorPedidosApplication.class, args);
        UsuarioCreate usuario1 = new UsuarioCreate("Ignacio", "Salazar", "ignaciosalazar@gmail.com", "3416050505", "123abc", Rol.ADMIN);
        UsuarioCreate usuario2 = new UsuarioCreate("Florencia", "Campora", "florcampora@gmail.com", "3416050505", "zxy789", Rol.USUARIO);


        Categoria categoria1 = new CategoriaCreate("Categoria 1", "Primera categoria").toEntity();
        Categoria categoria2 = new CategoriaCreate("Categoria 2", "Segunda categoria").toEntity();
        Categoria categoria3 = new CategoriaCreate("Categoria 3", "Tercera categoria").toEntity();

        Producto producto1 = new ProductoCreate("producto 1", 1100.00, "descripcion 1", 1, "imagen1.jpg", true, categoria1.getId()).toEntity(categoria1);
        Producto producto2 = new ProductoCreate("producto 2", 1250.00, "descripcion 2", 2, "imagen2.jpg", true, categoria2.getId()).toEntity(categoria2);
        Producto producto3 = new ProductoCreate("producto 3", 1500.00, "descripcion 3", 3, "imagen3.jpg", true, categoria3.getId()).toEntity(categoria3);
        Producto producto4 = new ProductoCreate("producto 4", 1750.00, "descripcion 4", 4, "imagen4.jpg", true, categoria1.getId()).toEntity(categoria1);
        Producto producto5 = new ProductoCreate("producto 5", 2000.00, "descripcion 5", 5, "imagen5.jpg", true, categoria2.getId()).toEntity(categoria2);
        Producto producto6 = new ProductoCreate("producto 6", 2250.00, "descripcion 6", 6, "imagen6.jpg", true, categoria3.getId()).toEntity(categoria3);
        Producto producto7 = new ProductoCreate("producto 7", 2500.00, "descripcion 7", 7, "imagen7.jpg", true, categoria1.getId()).toEntity(categoria1);
        Producto producto8 = new ProductoCreate("producto 8", 2750.00, "descripcion 8", 8, "imagen8.jpg", true, categoria2.getId()).toEntity(categoria2);
        Producto producto9 = new ProductoCreate("producto 9", 3000.00, "descripcion 9", 9, "imagen9.jpg", true, categoria3.getId()).toEntity(categoria3);
        Producto producto10 = new ProductoCreate("producto 10", 3400.00, "descripcion 10", 10, "imagen10.jpg", true, categoria3.getId()).toEntity(categoria3);

        Pedido pedido1 = new Pedido(FormaPago.EFECTIVO, usuario1.toEntity());
        Pedido pedido2 = new Pedido(FormaPago.TARJETA, usuario2.toEntity());
        Pedido pedido3 = new Pedido(FormaPago.TRANSFERENCIA, usuario2.toEntity());
        pedido1.addDetallePedido(2, producto1);
        pedido1.addDetallePedido(3, producto3);
        pedido2.addDetallePedido(1, producto2);
        pedido2.addDetallePedido(2, producto7);
        pedido3.addDetallePedido(2, producto1);
        pedido3.addDetallePedido(5, producto9);
        pedido3.addDetallePedido(6, producto8);

        pedido3.calcularTotal();
        pedido1.findDetallePedidoByProducto(producto1);
        pedido1.findDetallePedidoByProducto(producto4);

    }

}
