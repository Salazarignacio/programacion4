package com.gestor_pedidos.controller;

import com.gestor_pedidos.enums.FormaPago;
import com.gestor_pedidos.pedido.PedidoDTO;
import com.gestor_pedidos.pedido.PedidoEdit;
import com.gestor_pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTO> save(@RequestBody FormaPago formaPago,@RequestParam Long idUsuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(formaPago, idUsuario));
    }
    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> findAll(){
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoDTO> update(@RequestBody PedidoEdit pedidoEdit, @PathVariable Long id){
        return ResponseEntity.ok(pedidoService.update(pedidoEdit, id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        pedidoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
