package com.gestor_pedidos.repository;

import com.gestor_pedidos.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
