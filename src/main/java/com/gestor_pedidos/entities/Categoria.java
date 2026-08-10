package com.gestor_pedidos.entities;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Categoria extends Base {
    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

}
