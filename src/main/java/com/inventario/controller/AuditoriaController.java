package com.inventario.controller;

import com.inventario.model.Auditoria;
import com.inventario.service.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/auditorias")
public class AuditoriaController {

    @Autowired
    private AuditoriaService auditoriaService;

    @PostMapping
    public void salvar(@RequestBody Auditoria auditoria) {
        auditoriaService.salvar(auditoria);
    }

    @GetMapping
    public List<Auditoria> listarTodos() {
        return auditoriaService.listarTodos();
    }
}
