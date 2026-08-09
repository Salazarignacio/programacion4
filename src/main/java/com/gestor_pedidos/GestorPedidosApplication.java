package com.gestor_pedidos;

import com.gestor_pedidos.entities.Categoria;
import com.gestor_pedidos.entities.Pedido;
import com.gestor_pedidos.entities.Producto;
import com.gestor_pedidos.entities.Usuario;
import com.gestor_pedidos.enums.Estado;
import com.gestor_pedidos.enums.FormaPago;
import com.gestor_pedidos.enums.Rol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class GestorPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorPedidosApplication.class, args);
		/*Usuario usuario = new Usuario("Ignacio", "Salazar", "ignaciosalazar@gmail.com","3416050508", "123ABC", Rol.USUARIO);
		Categoria categoria = new Categoria( "Lacteos", "Productos elaborados con leche");
		Producto prod1 = new Producto("Leche", 2200.00, "Leche comun", 20, "...", true, categoria);
		Pedido ped1 = new Pedido(Estado.PENDIENTE, FormaPago.EFECTIVO, usuario);
		ped1.addDetallePedido(2, prod1);
		ped1.calcularTotal();*/

		
	}

}
