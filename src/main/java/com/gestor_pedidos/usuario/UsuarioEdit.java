package com.gestor_pedidos.usuario;

import com.gestor_pedidos.entities.Usuario;
import com.gestor_pedidos.enums.Rol;

public record UsuarioEdit(String nombre, String apellido, String mail, String celular, String contrasenia, Rol rol) {
    public void applyTo(Usuario usuario) {
        if (nombre != null) {
            usuario.setNombre(nombre);
        }
        if (apellido != null) {
            usuario.setApellido(apellido);
        }
        if (mail != null) {
            usuario.setMail(mail);
        }
        if (celular != null) {
            usuario.setCelular(celular);
        }
        if (contrasenia != null) {
            usuario.setContrasenia(contrasenia);
        }
        if (rol != null) {
            usuario.setRol(rol);
        }
    }
}
