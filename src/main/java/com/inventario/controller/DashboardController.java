package com.inventario.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.inventario.model.EquipamentoTI;
import com.inventario.service.EquipamentoTIService;

@Controller
public class DashboardController {
@Autowired
    private EquipamentoTIService equipamentoTIService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<EquipamentoTI> equipamentos = equipamentoTIService.listarTodos();

        int totalEquipamentos = equipamentos.size();
        int emManutencao = (int) equipamentos.stream()
            .filter(e -> "manutencao".equalsIgnoreCase(e.getEstado()))
            .count();
        int disponiveis = (int) equipamentos.stream()
            .filter(e -> "disponivel".equalsIgnoreCase(e.getEstado()))
            .count();
        int alocados = (int) equipamentos.stream()
            .filter(e -> "alocado".equalsIgnoreCase(e.getEstado()))
            .count();
            
        model.addAttribute("totalEquipamentos", totalEquipamentos);
        model.addAttribute("emManutencao", emManutencao);
        model.addAttribute("disponiveis", disponiveis);
        model.addAttribute("alocados", alocados);
        
        return "layout"; // nome do arquivo sem .html
    }
}