package com.inventario.service;

import com.inventario.model.Auditoria;
import java.util.List;

public interface AuditoriaService {
    void salvar(Auditoria auditoria);
    List<Auditoria> listarTodos();
}
