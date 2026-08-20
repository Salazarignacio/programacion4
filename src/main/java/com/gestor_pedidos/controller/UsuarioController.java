package com.gestor_pedidos.controller;

import com.gestor_pedidos.service.UsuarioService;
import com.gestor_pedidos.usuario.UsuarioCreate;
import com.gestor_pedidos.usuario.UsuarioDTO;
import com.gestor_pedidos.usuario.UsuarioEdit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioDTO>save(@RequestBody UsuarioCreate usuarioCreate){
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuarioCreate));
    }
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(usuarioService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>>findAll(){
        return ResponseEntity.ok(usuarioService.findAll());
    }
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO>update(@RequestBody UsuarioEdit usuarioEdit, @PathVariable Long id){
        return ResponseEntity.ok(usuarioService.update(usuarioEdit, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
