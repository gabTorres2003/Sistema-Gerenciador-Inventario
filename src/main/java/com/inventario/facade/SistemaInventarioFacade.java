package com.inventario.facade;

import com.inventario.model.EquipamentoTI;
import com.inventario.model.Inventario;
import com.inventario.model.Reserva;
import com.inventario.model.Usuario;
import com.inventario.model.Manutencao;
import com.inventario.service.EquipamentoTIService;
import com.inventario.service.InventarioService;
import com.inventario.service.ReservaService;
import com.inventario.service.UsuarioService;
import com.inventario.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class SistemaInventarioFacade {

    @Autowired private EquipamentoTIService equipamentoTIService;
    @Autowired private InventarioService inventarioService;
    @Autowired private ReservaService reservaService;
    @Autowired private UsuarioService usuarioService;
    @Autowired private ManutencaoService manutencaoService;
}