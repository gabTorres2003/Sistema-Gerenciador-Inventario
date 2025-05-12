package com.inventario.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.inventario.model.EquipamentoTI;
import com.inventario.service.CategoriaTIService;
import com.inventario.service.EquipamentoTIService;

@Controller
public class EquipamentoFormController {

    @Autowired
    private EquipamentoTIService equipamentoTIService;

    @Autowired
    private CategoriaTIService categoriaTIService;

    @GetMapping("/equipamentos/add")
    public String formNovoEquipamento(Model model) {
        model.addAttribute("equipamento", new EquipamentoTI());
        model.addAttribute("categorias", categoriaTIService.listarTodos());
        return "equipamento-form";
    }

    @PostMapping("/equipamentos/salvar")
    public String salvarEquipamento(@ModelAttribute EquipamentoTI equipamento) {
        equipamentoTIService.salvar(equipamento);
        return "redirect:/equipamentos-view";
    }
}