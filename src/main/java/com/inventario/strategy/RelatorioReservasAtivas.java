package com.inventario.strategy;

import com.inventario.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class RelatorioReservasAtivas implements RelatorioStrategy {

    @Autowired
    private ReservaService reservaService;

    @Override
    public String gerar() {
        StringBuilder relatorio = new StringBuilder("Relatório de Reservas Ativas:\n");
        reservaService.listarTodos().stream()
            .filter(r -> "ativa".equalsIgnoreCase(r.getStatus()))
            .forEach(r -> relatorio.append("- ID: ")
                                   .append(r.getIdReserva())
                                   .append(" | Usuário: ")
                                   .append(r.getUsuario().getNomeCompleto())
                                   .append(" | Equipamento: ")
                                   .append(r.getEquipamento().getNome())
                                   .append("\n"));
        return relatorio.toString();
    }
}

