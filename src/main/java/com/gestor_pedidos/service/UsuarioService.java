package com.gestor_pedidos.service;

import com.gestor_pedidos.usuario.UsuarioCreate;
import com.gestor_pedidos.usuario.UsuarioDTO;
import com.gestor_pedidos.usuario.UsuarioEdit;

import java.util.List;

public interface UsuarioService {
    public UsuarioDTO save(UsuarioCreate usuarioCreate);
    public UsuarioDTO findById(Long id);
    public List<UsuarioDTO> findAll();
    public UsuarioDTO update(UsuarioEdit usuarioEdit, Long id);
    public void deleteById(Long id);
    public UsuarioDTO findByMail(String mail);
}
