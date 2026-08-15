package com.gestor_pedidos.service;

import com.gestor_pedidos.producto.ProductoCreate;
import com.gestor_pedidos.producto.ProductoDTO;
import com.gestor_pedidos.producto.ProductoEdit;

import java.util.List;

public interface ProductoService  {
    public ProductoDTO save(ProductoCreate productoCreate);
    public ProductoDTO findById(Long id);
    public List<ProductoDTO> findAll();
    public ProductoDTO update(ProductoEdit prodEdit, Long id);
    public void deleteById(Long id);
}
