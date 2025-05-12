package com.inventario.controller;

import com.inventario.model.Manutencao;
import com.inventario.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

    @Autowired
    private ManutencaoService manutencaoService;

    @PostMapping
    public void salvar(@RequestBody Manutencao manutencao) {
        manutencaoService.salvar(manutencao);
    }

    @GetMapping
    public List<Manutencao> listarTodos() {
        return manutencaoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Manutencao buscarPorId(@PathVariable int id) {
        return manutencaoService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        Manutencao manutencao = manutencaoService.buscarPorId(id);
        if (manutencao != null) {
            manutencaoService.deletar(manutencao);
        }
    }
}