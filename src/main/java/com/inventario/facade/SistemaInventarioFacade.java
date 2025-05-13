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

    // Equipamentos
    public void cadastrarEquipamentoComInventario(EquipamentoTI equipamento, String localizacao) {
        equipamentoTIService.salvar(equipamento);
        Inventario inventario = new Inventario(0, equipamento, localizacao, 1);
        inventario.setEquipamento(equipamento);
        inventario.setLocalizacao(localizacao);
        inventario.setQuantidadeDisponivel(1);
        inventarioService.salvar(inventario);
    }

    public List<EquipamentoTI> listarEquipamentos() {
        return equipamentoTIService.listarTodos();
    }

    // Reservas
    public void solicitarReservaEquipamento(Reserva reserva) {
        if (!"disponivel".equalsIgnoreCase(reserva.getEquipamento().getEstado())) {
            throw new IllegalStateException("Equipamento indisponível");
        }
        reservaService.salvar(reserva);
    }

    public BigDecimal calcularMultaReserva(Reserva reserva) {
        return BigDecimal.valueOf(reserva.calcularMultaAtraso());
    }

    public List<Reserva> listarReservas() {
        return reservaService.listarTodos();
    }

    // Usuários
    public void salvarUsuario(Usuario usuario) {
        usuarioService.salvar(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioService.listarTodos();
    }

    // Manutenções
    public void registrarManutencao(Manutencao manutencao) {
        manutencaoService.salvar(manutencao);
    }

    public List<Manutencao> listarManutencoes() {
        return manutencaoService.listarTodos();
    }
}
