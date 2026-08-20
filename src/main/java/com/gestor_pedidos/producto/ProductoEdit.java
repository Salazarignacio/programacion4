package com.gestor_pedidos.producto;

import com.gestor_pedidos.entities.Categoria;
import com.gestor_pedidos.entities.Producto;

public record ProductoEdit(String nombre, Double precio, String descripcion, int stock, String imagen, Boolean disponible, Categoria categoria) {
public void applyTo(Producto prod, Categoria cat){
    if(nombre != null){
        prod.setNombre(nombre);
    }
    if(precio != null){
        prod.setPrecio(precio);
    }
    if (descripcion != null){
        prod.setDescripcion(descripcion);
    }
    if (stock != 0){
        prod.setStock(stock);
    }
    if(imagen != null){
        prod.setImagen(imagen);
    }
    if(disponible != null){
        prod.setDisponible(disponible);
    }
    if(cat != null){
        prod.setCategoria(cat);
    }
}
}
