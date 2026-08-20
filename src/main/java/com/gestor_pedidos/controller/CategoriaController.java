package com.gestor_pedidos.controller;

import com.gestor_pedidos.categoria.CategoriaCreate;
import com.gestor_pedidos.categoria.CategoriaDTO;
import com.gestor_pedidos.categoria.CategoriaEdit;
import com.gestor_pedidos.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/categoria")
@RequiredArgsConstructor
public class CategoriaController {
    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaCreate categoriaCreate){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoriaCreate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaEdit categoriaEdit, @PathVariable Long id){
        return ResponseEntity.ok(categoriaService.update(categoriaEdit, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
