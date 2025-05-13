package com.inventario.service.impl;

import com.inventario.model.CategoriaTI;
import com.inventario.repository.CategoriaTIRepository;
import com.inventario.service.CategoriaTIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaTIServiceImpl implements CategoriaTIService {

    @Autowired
    private CategoriaTIRepository categoriaTIRepository;

    @Override
    public void salvar(CategoriaTI categoria) {
        categoriaTIRepository.save(categoria);
    }

    @Override
    public CategoriaTI buscarPorId(int id) {
        return categoriaTIRepository.findById(id).orElse(null);
    }

    @Override
    public List<CategoriaTI> listarTodos() {
        return categoriaTIRepository.findAll();
    }

    @Override
    public void deletar(CategoriaTI categoria) {
        categoriaTIRepository.delete(categoria);
    }
} 