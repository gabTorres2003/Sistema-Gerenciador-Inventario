package com.inventario.controller;

import com.inventario.model.EquipamentoTI;
import com.inventario.service.EquipamentoTIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/equipamentos")
public class EquipamentoTIController {

    @Autowired
    private EquipamentoTIService equipamentoTIService;

    @PostMapping
    public void salvar(@RequestBody EquipamentoTI equipamento) {
        equipamentoTIService.salvar(equipamento);
    }

    @GetMapping
    public List<EquipamentoTI> listarTodos() {
        return equipamentoTIService.listarTodos();
    }

    @GetMapping("/{id}")
    public EquipamentoTI buscarPorId(@PathVariable int id) {
        return equipamentoTIService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        EquipamentoTI equipamento = equipamentoTIService.buscarPorId(id);
        if (equipamento != null) {
            equipamentoTIService.deletar(equipamento);
        }
    }
}