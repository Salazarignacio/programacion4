package com.gestor_pedidos.categoria;

import com.gestor_pedidos.entities.Categoria;

public record CategoriaEdit(String nombre, String descripcion) {
    public void applyTo(Categoria categoria){
        if(nombre != null){
            categoria.setNombre(nombre);
        }
        if (descripcion != null){
            categoria.setDescripcion(descripcion);
        }
    }
}
