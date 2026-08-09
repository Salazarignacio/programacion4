package com.gestor_pedidos.categoria;

import com.gestor_pedidos.entities.Categoria;

public record CategoriaCreate(String nombre, String descripcion) {
    public Categoria toEntity() {
        return new Categoria(nombre, descripcion);
    }
}
