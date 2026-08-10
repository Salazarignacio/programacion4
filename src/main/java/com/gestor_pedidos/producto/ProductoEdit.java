package com.gestor_pedidos.producto;

import com.gestor_pedidos.categoria.CategoriaDTO;
import com.gestor_pedidos.entities.Categoria;
import com.gestor_pedidos.entities.Producto;

public record ProductoEdit(String nombre, Double precio, String descripcion, int stock, String imagen, boolean disponible, CategoriaDTO categoriaDTO) {
public void applyTo(Producto prod, Categoria cat){
    if(nombre != null){
        prod.setNombre(nombre);
    }
    if(precio != null){
        prod.setPrecio(precio);
    }
}
}
