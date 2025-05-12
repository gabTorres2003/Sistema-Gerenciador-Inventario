package com.inventario.controller;

import com.inventario.model.CategoriaTI;
import com.inventario.service.CategoriaTIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaTIController {

    @Autowired
    private CategoriaTIService categoriaTIService;

    @PostMapping
    public void salvar(@RequestBody CategoriaTI categoria) {
        categoriaTIService.salvar(categoria);
    }

    @GetMapping
    public List<CategoriaTI> listarTodos() {
        return categoriaTIService.listarTodos();
    }

    @GetMapping("/{id}")
    public CategoriaTI buscarPorId(@PathVariable int id) {
        return categoriaTIService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        CategoriaTI categoria = categoriaTIService.buscarPorId(id);
        if (categoria != null) {
            categoriaTIService.deletar(categoria);
        }
    }
}