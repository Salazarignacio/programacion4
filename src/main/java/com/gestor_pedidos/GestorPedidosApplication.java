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

    }

}
