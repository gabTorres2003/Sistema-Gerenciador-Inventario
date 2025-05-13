package com.inventario.proxy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.inventario.model.EquipamentoTI;
import com.inventario.service.EquipamentoTIService;

@Service
@Primary
public class EquipamentoTIServiceProxy implements EquipamentoTIService {

    private final EquipamentoTIService equipamentoTIService;

    public EquipamentoTIServiceProxy(EquipamentoTIService equipamentoTIService) {
        this.equipamentoTIService = equipamentoTIService;
    }

    @Override
    public void salvar(EquipamentoTI equipamento) {
        if (equipamento.getNome() != null && equipamento.getNumeroSerie() != null) {
            equipamentoTIService.salvar(equipamento);
        } else {
            throw new IllegalArgumentException("Dados do equipamento incompletos");
        }
    }

    @Override
    public EquipamentoTI buscarPorId(int id) {
        return equipamentoTIService.buscarPorId(id);
    }

    @Override
    public java.util.List<EquipamentoTI> listarTodos() {
        return equipamentoTIService.listarTodos();
    }

    @Override
    public void deletar(EquipamentoTI equipamento) {
        equipamentoTIService.deletar(equipamento);
    }
}
