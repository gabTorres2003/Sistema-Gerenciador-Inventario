package com.inventario.service;

import com.inventario.model.CategoriaTI;
import java.util.List;

public interface CategoriaTIService {
    void salvar(CategoriaTI categoria);
    CategoriaTI buscarPorId(int id);
    List<CategoriaTI> listarTodos();
    void deletar(CategoriaTI categoria);
}