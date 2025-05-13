package com.inventario.controller;

import com.inventario.model.EquipamentoTI;
import com.inventario.service.EquipamentoTIService;
import com.inventario.strategy.RelatorioStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class DashboardController {

    @Autowired
    
    private EquipamentoTIService equipamentoTIService;

    @Autowired
    private Map<String, RelatorioStrategy> estrategias;

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam(name = "tipo", required = false, defaultValue = "relatorioReservasAtivas") String tipo,
                            Model model) {

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

        RelatorioStrategy estrategia = estrategias.get(tipo);
        String conteudo = estrategia != null ? estrategia.gerar() : "Relatório não encontrado.";
        model.addAttribute("relatorio", conteudo);

        return "layout"; // nome do arquivo HTML
    }
}
