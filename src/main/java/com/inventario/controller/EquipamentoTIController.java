package com.inventario.controller;

import com.inventario.facade.SistemaInventarioFacade;
import com.inventario.model.EquipamentoTI;
import com.inventario.service.CategoriaTIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EquipamentoController {

    @Autowired private SistemaInventarioFacade sistemaFacade;
    @Autowired private CategoriaTIService categoriaTIService;

    @GetMapping("/equipamentos-view")
    public String listarEquipamentos(Model model) {
        model.addAttribute("equipamentos", sistemaFacade.listarEquipamentos());
        return "equipamentos";
    }

    @GetMapping("/equipamentos/add")
    public String formNovoEquipamento(Model model) {
        model.addAttribute("equipamento", new EquipamentoTI());
        model.addAttribute("categorias", categoriaTIService.listarTodos());
        return "equipamento-form";
    }

    @PostMapping("/equipamentos/salvar")
    public String salvarEquipamento(@ModelAttribute EquipamentoTI equipamento,
                                    @RequestParam("localizacao") String localizacao) {
        sistemaFacade.cadastrarEquipamentoComInventario(equipamento, localizacao);
        return "redirect:/equipamentos-view";
    }
}
