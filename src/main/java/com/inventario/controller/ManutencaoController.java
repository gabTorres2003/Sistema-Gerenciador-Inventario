package com.inventario.controller;

import com.inventario.facade.SistemaInventarioFacade;
import com.inventario.model.Manutencao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ManutencaoController {

    @Autowired private SistemaInventarioFacade sistemaFacade;

    @GetMapping("/manutencoes-view")
    public String listarManutencoes(Model model) {
        model.addAttribute("manutencoes", sistemaFacade.listarManutencoes());
        return "manutencoes";
    }

    @GetMapping("/manutencoes/add")
    public String formNovaManutencao(Model model) {
        model.addAttribute("manutencao", new Manutencao());
        return "manutencao-form";
    }

    @PostMapping("/manutencoes/salvar")
    public String salvarManutencao(@ModelAttribute Manutencao manutencao) {
        sistemaFacade.registrarManutencao(manutencao);
        return "redirect:/manutencoes-view";
    }
}
