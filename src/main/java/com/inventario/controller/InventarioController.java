package com.inventario.controller;

import com.inventario.model.Inventario;
import com.inventario.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @PostMapping
    public void salvar(@RequestBody Inventario inventario) {
        inventarioService.salvar(inventario);
    }

    @GetMapping
    public List<Inventario> listarTodos() {
        return inventarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public Inventario buscarPorId(@PathVariable int id) {
        return inventarioService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        Inventario inventario = inventarioService.buscarPorId(id);
        if (inventario != null) {
            inventarioService.deletar(inventario);
        }
    }
}