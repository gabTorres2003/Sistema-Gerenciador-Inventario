package com.inventario.controller;

import com.inventario.facade.SistemaInventarioFacade;
import com.inventario.model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReservaController {

    @Autowired private SistemaInventarioFacade sistemaFacade;

    @GetMapping("/reservas-view")
    public String listarReservas(Model model) {
        model.addAttribute("reservas", sistemaFacade.listarReservas());
        return "reservas";
    }

    @GetMapping("/reservas/add")
    public String formNovaReserva(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reserva-form";
    }

    @PostMapping("/reservas")
    public String solicitarReserva(@ModelAttribute Reserva reserva) {
        sistemaFacade.solicitarReservaEquipamento(reserva);
        return "redirect:/reservas-view";
    }
}