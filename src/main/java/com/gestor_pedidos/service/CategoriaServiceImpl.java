package com.gestor_pedidos.service;

import com.gestor_pedidos.categoria.CategoriaCreate;
import com.gestor_pedidos.categoria.CategoriaDTO;
import com.gestor_pedidos.entities.Categoria;
import com.gestor_pedidos.repository.CategoriaRepository;

import java.util.List;

public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public  CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaDTO save(CategoriaCreate categoriaCreate) {
        Categoria cat = categoriaCreate.toEntity();
        /*Envio una categoria, la persiste y me retorna una categoria*/
        cat = categoriaRepository.save(cat);
        return CategoriaDTO.toDTO(cat);
    }
    @Override
    public CategoriaDTO findById(Long id) {
        return null;
    }
    @Override
    public List<CategoriaDTO> findAll() {
        return null;
    }
    @Override
    public CategoriaDTO update(CategoriaCreate categoriaDTO, Long id) {
        return null;
    }
    @Override
    public void deleteById(Long id) {
    }
}
