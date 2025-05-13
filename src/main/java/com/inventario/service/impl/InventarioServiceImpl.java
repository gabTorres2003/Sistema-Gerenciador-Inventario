package com.inventario.service.impl;

import com.inventario.model.Inventario;
import com.inventario.repository.InventarioRepository;
import com.inventario.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public void salvar(Inventario inventario) {
        inventarioRepository.save(inventario);
    }

    public Inventario buscarPorId(int id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    public List<Inventario> listarTodos() {
        return inventarioRepository.findAll();
    }

    public void deletar(Inventario inventario) {
        inventarioRepository.delete(inventario);
    }
}
