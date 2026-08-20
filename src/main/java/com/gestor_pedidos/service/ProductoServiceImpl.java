package com.gestor_pedidos.service;

import com.gestor_pedidos.entities.Categoria;
import com.gestor_pedidos.entities.Producto;
import com.gestor_pedidos.producto.ProductoCreate;
import com.gestor_pedidos.producto.ProductoDTO;
import com.gestor_pedidos.producto.ProductoEdit;
import com.gestor_pedidos.repository.CategoriaRepository;
import com.gestor_pedidos.repository.ProductoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;

@Override
    public ProductoDTO save(ProductoCreate productoCreate){
    Categoria categoria = categoriaRepository.findById(productoCreate.IdCategoria()).orElseThrow(()->new NullPointerException("No se ecnontro categoria con ID: " + productoCreate.IdCategoria()));
    Producto producto = productoCreate.toEntity(categoria);
    producto = productoRepository.save(producto);
    return ProductoDTO.toDTO(producto);
    }
    @Override
    public List<ProductoDTO> findAll() {
    List<Producto> productos = productoRepository.findAll();
        return productos.stream().map(ProductoDTO::toDTO).toList();
    }
@Override
    public ProductoDTO findById(Long id){
    Producto prod = productoRepository.findById(id).orElseThrow(()->new NullPointerException("No se encontro producto con ID: " + id));
    return  ProductoDTO.toDTO(prod);
    }
    @Override
    public ProductoDTO update(ProductoEdit productoEdit, Long id){
    Producto prod = productoRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro producto con ID: " + id));
    Categoria cat = null;
    if(productoEdit.categoria() != null){
        cat = categoriaRepository.findById(productoEdit.categoria().getId()).orElseThrow(()-> new NullPointerException("No se encontro categoria con ID: " + productoEdit.categoria().getId()));
    }
    productoEdit.applyTo(prod, cat);
    prod = productoRepository.save(prod);
    return ProductoDTO.toDTO(prod);
}

    @Override
    public void deleteById(Long id){
        Producto prod = productoRepository.findById(id).orElseThrow(()->new NullPointerException("No se encontro producto con ID: " + id));
        prod.setEliminado(true);
        productoRepository.save(prod);
    }
}
