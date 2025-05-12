package com.inventario.controller;

import com.inventario.service.EquipamentoTIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EquipamentoViewController {

    @Autowired
    private EquipamentoTIService equipamentoTIService;

    @GetMapping("/equipamentos-view")
    public String equipamentos(Model model) {
        model.addAttribute("equipamentos", equipamentoTIService.listarTodos());
        return "equipamentos";
    }
}