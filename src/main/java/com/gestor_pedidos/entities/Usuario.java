package com.gestor_pedidos.entities;

import com.gestor_pedidos.enums.Rol;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Usuario extends Base {
    private String nombre;
    private String apellido;
    private String mail;
    private String celular;
    private String contasenia;
    private Rol rol;

    public Usuario(String nombre, String apellido, String mail, String celular, String contasenia, Rol rol) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.celular = celular;
        this.contasenia = contasenia;
        this.rol = rol;
    }


}
