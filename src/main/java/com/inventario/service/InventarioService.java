package com.inventario.service;

import com.inventario.model.Inventario;
import java.util.List;

public interface InventarioService {

    void salvar(Inventario inventario);

    Inventario buscarPorId(int id);

    List<Inventario> listarTodos();

    void deletar(Inventario inventario);
}
