package com.gestor_pedidos.producto;

import com.gestor_pedidos.entities.Categoria;
import com.gestor_pedidos.entities.Producto;

public record ProductoCreate(String nombre, Double precio, String descripcion, int stock, String imagen, boolean disponible, Long IdCategoria) {
    public Producto toEntity(Categoria categoria){
        return new Producto(nombre,precio, descripcion,stock,imagen,disponible,categoria);
    }
}
