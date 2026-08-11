package com.gestor_pedidos.usuario;

import com.gestor_pedidos.entities.Usuario;
import com.gestor_pedidos.enums.Rol;

public record UsuarioDTO(String nombre, String apellido, String mail, String celular, String contrasenia, Rol rol) {
    public static UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(usuario.getNombre(), usuario.getApellido(), usuario.getMail(), usuario.getCelular(), usuario.getContrasenia(), usuario.getRol());
    }
}

