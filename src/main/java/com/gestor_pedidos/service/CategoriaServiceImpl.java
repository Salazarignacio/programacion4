package com.gestor_pedidos.service;

import com.gestor_pedidos.categoria.CategoriaCreate;
import com.gestor_pedidos.categoria.CategoriaDTO;
import com.gestor_pedidos.categoria.CategoriaEdit;
import com.gestor_pedidos.entities.Categoria;
import com.gestor_pedidos.repository.CategoriaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Override
    public CategoriaDTO save(CategoriaCreate categoriaCreate) {
        Categoria cat = categoriaCreate.toEntity();
        cat = categoriaRepository.save(cat);
        return CategoriaDTO.toDTO(cat);
    }
    @Override
    public CategoriaDTO findById(Long id) {
        Categoria cat = categoriaRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro ID: " + id));
        return CategoriaDTO.toDTO(cat);
    }
    @Override
    public List<CategoriaDTO> findAll() {
        List<CategoriaDTO> categoriasDTO = new ArrayList<>();
        List<Categoria> categorias = categoriaRepository.findAll();
        for(Categoria cat : categorias){
            categoriasDTO.add(CategoriaDTO.toDTO(cat));
        }
        return categoriasDTO;
    }
    @Override
    public CategoriaDTO update(CategoriaEdit categoriaEdit, Long id) {
        Categoria cat = categoriaRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro categoria con id" + id));
        categoriaEdit.applyTo(cat);
        cat = categoriaRepository.save(cat);
        return CategoriaDTO.toDTO(cat);
    }
    @Override
    public void deleteById(Long id) {
        Categoria cat = categoriaRepository.findById(id).orElseThrow(()-> new NullPointerException("No se encontro categoria con id" + id));
        cat.setEliminado(true);
        categoriaRepository.save(cat);
    }
}
