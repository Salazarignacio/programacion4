package com.gestor_pedidos.controller;

import com.gestor_pedidos.producto.ProductoCreate;
import com.gestor_pedidos.producto.ProductoDTO;
import com.gestor_pedidos.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/producto")
@RequiredArgsConstructor
public class ProductoController {
    private final ProductoService productoService;

    @PostMapping
    public ResponseEntity<ProductoDTO> save(@RequestBody ProductoCreate productoCreate){
        return ResponseEntity.status(HttpStatus.CREATED).body(productoService.save(productoCreate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(productoService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<ProductoDTO>> findAll(){
        return ResponseEntity.ok(productoService.findAll());
    }
}
