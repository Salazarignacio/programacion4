package com.gestor_pedidos.service;

import com.gestor_pedidos.categoria.CategoriaCreate;
import com.gestor_pedidos.categoria.CategoriaDTO;

import java.util.List;

public interface CategoriaService {
    public CategoriaDTO save(CategoriaCreate categoriaCreate);
    public CategoriaDTO findById(Long id);
    public List<CategoriaDTO> findAll();
    public CategoriaDTO update(CategoriaCreate categoriaCreate,  Long id);
    public void deleteById(Long id);
}
