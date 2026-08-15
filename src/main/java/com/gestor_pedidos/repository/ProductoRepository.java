package com.gestor_pedidos.repository;

import com.gestor_pedidos.entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
