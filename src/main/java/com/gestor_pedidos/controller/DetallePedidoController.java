package com.gestor_pedidos.controller;

import com.gestor_pedidos.detallePedido.DetallePedidoCreate;
import com.gestor_pedidos.detallePedido.DetallePedidoDTO;
import com.gestor_pedidos.service.DetallePedidoService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/detallepedido")
public class DetallePedidoController {
    private final DetallePedidoService detallePedidoService;

    @PostMapping
    public ResponseEntity<DetallePedidoDTO> save(@RequestBody DetallePedidoCreate detallePedidoCreate){
        return ResponseEntity.status(HttpStatus.CREATED).body(detallePedidoService.save(detallePedidoCreate));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedidoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(detallePedidoService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<DetallePedidoDTO>> findAll(){
        return ResponseEntity.ok(detallePedidoService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id ){
        detallePedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
