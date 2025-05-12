package com.inventario.service.impl;

import com.inventario.model.Auditoria;
import com.inventario.repository.AuditoriaRepository;
import com.inventario.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    public void salvar(Auditoria auditoria) {
        auditoriaRepository.save(auditoria);
    }

    public List<Auditoria> listarTodos() {
        return auditoriaRepository.findAll();
    }
}
