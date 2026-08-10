package com.gestor_pedidos.usuario;

import com.gestor_pedidos.entities.Usuario;
import com.gestor_pedidos.enums.Rol;

public record UsuarioCreate(String nombre, String apellido, String mail, String celular, String contrasenia, Rol rol) {
    public Usuario toEntity() {
        return new Usuario(nombre, apellido, mail, celular, contrasenia, rol);
    }
}
