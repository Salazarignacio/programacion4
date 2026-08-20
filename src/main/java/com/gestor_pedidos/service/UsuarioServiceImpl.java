package com.gestor_pedidos.service;

import com.gestor_pedidos.entities.Usuario;
import com.gestor_pedidos.producto.ProductoDTO;
import com.gestor_pedidos.repository.UsuarioRepository;
import com.gestor_pedidos.usuario.UsuarioCreate;
import com.gestor_pedidos.usuario.UsuarioDTO;
import com.gestor_pedidos.usuario.UsuarioEdit;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService{
    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDTO save(UsuarioCreate usuarioCreate){
        Usuario usuario = usuarioRepository.save(usuarioCreate.toEntity());
        return UsuarioDTO.toDTO(usuario);
    }
    @Override
    public UsuarioDTO findById(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro usuario con ID: " + id));
        return  UsuarioDTO.toDTO(usuario);
    }
    @Override
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::toDTO).toList();
    }

    @Override
    public UsuarioDTO update(UsuarioEdit usuarioEdit, Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro usuario con ID: " + id));
        usuarioEdit.applyTo(usuario);
        usuario = usuarioRepository.save(usuario);
        return UsuarioDTO.toDTO(usuario);
    }

    @Override
    public void deleteById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro usuario con ID: " + id));
        usuario.setEliminado(true);
        usuarioRepository.save(usuario);
    }
    @Override
    public UsuarioDTO findByMail(String mail){
        Usuario usuario = usuarioRepository.findByMail(mail).orElseThrow(()-> new NullPointerException("No se encontro usuario con mail: " + mail ));
        return UsuarioDTO.toDTO(usuario);
    }
}
