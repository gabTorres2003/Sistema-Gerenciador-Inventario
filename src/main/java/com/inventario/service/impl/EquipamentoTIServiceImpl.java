package com.inventario.service.impl;

import com.inventario.model.EquipamentoTI;
import com.inventario.repository.EquipamentoTIRepository;
import com.inventario.service.EquipamentoTIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoTIServiceImpl implements EquipamentoTIService {

    @Autowired
    private EquipamentoTIRepository equipamentoTIRepository;

    public void salvar(EquipamentoTI equipamento) {
        equipamentoTIRepository.save(equipamento);
    }

    public EquipamentoTI buscarPorId(int id) {
        return equipamentoTIRepository.findById(id).orElse(null);
    }

    public List<EquipamentoTI> listarTodos() {
        return equipamentoTIRepository.findAll();
    }

    public void deletar(EquipamentoTI equipamento) {
        equipamentoTIRepository.delete(equipamento);
    }

    
}