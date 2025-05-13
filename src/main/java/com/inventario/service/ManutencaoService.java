package com.inventario.service;

import com.inventario.model.Manutencao;
import java.util.List;

public interface ManutencaoService {
    void salvar(Manutencao manutencao);
    Manutencao buscarPorId(int id);
    List<Manutencao> listarTodos();
    void deletar(Manutencao manutencao);
}