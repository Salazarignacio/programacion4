package com.gestor_pedidos.categoria;

import com.gestor_pedidos.entities.Categoria;

public record CategoriaDTO(String nombre, String descripcion) {
    public static CategoriaDTO toDTO(Categoria categoria) {
        return new CategoriaDTO(categoria.getNombre(), categoria.getDescripcion());
    }
}
