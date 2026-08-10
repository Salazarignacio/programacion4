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
import com.gestor_pedidos.usuario.UsuarioDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GestorPedidosApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestorPedidosApplication.class, args);
        UsuarioDTO usuarioDTO1 = new UsuarioDTO("Ignacio", "Salazar", "ignaciosalazar@gmail.com", "3416050505", "123abc", Rol.ADMIN);
        UsuarioDTO usuarioDTO2 = new UsuarioDTO("Florencia", "Campora", "florcampora@gmail.com", "3416050505", "zxy789", Rol.USUARIO);

        CategoriaDTO categoriaDTO1 = new CategoriaDTO("Categoria 1", "Primera categoria");
        CategoriaDTO categoriaDTO2 = new CategoriaDTO("Categoria 2", "Segunda categoria");
        CategoriaDTO categoriaDTO3 = new CategoriaDTO("Categoria 3", "Tercera categoria");

        ProductoDTO productoDTO1 = new ProductoDTO("producto 1", 1100.00,"descripcion 1", 1, "imagen1.jpg", true, categoriaDTO1);


    }

}
