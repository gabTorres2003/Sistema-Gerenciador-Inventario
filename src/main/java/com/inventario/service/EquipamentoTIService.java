package com.inventario.service;

import com.inventario.model.EquipamentoTI;
import java.util.List;

public interface EquipamentoTIService {
    void salvar(EquipamentoTI equipamento);
    EquipamentoTI buscarPorId(int id);
    List<EquipamentoTI> listarTodos();
    void deletar(EquipamentoTI equipamento);
}