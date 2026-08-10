package com.gestor_pedidos.producto;

import com.gestor_pedidos.categoria.CategoriaDTO;
import com.gestor_pedidos.entities.Producto;

public record ProductoDTO(String nombre, Double precio, String descripcion, int stock, String imagen, boolean disponible, CategoriaDTO categoriaDTO) {
    public static ProductoDTO toDTO(Producto prod){
        return new ProductoDTO(prod.getNombre(), prod.getPrecio(), prod.getDescripcion(), prod.getStock(), prod.getImagen(), prod.isDisponible(), prod.getCategoria() != null ? CategoriaDTO.toDTO(prod.getCategoria()) : null );
    }
}
