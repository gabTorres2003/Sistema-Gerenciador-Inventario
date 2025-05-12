package com.inventario.controller;

import com.inventario.facade.SistemaInventarioFacade;
import com.inventario.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired private SistemaInventarioFacade sistemaFacade;

    @GetMapping("/usuarios-view")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", sistemaFacade.listarUsuarios());
        return "usuarios";
    }

    @GetMapping("/usuarios/add")
    public String formNovoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario-form";
    }

    @PostMapping("/usuarios/salvar")
    public String salvarUsuario(@ModelAttribute Usuario usuario) {
        sistemaFacade.salvarUsuario(usuario);
        return "redirect:/usuarios-view";
    }
}
