package com.gestor_pedidos.repository;

import com.gestor_pedidos.entities.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}
