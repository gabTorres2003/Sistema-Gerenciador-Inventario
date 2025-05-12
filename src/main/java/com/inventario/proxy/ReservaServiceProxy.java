package com.inventario.service.proxy;

import com.inventario.model.Reserva;
import com.inventario.service.ReservaService;

public class ReservaServiceProxy implements ReservaService {

    private final ReservaService reservaService;

    public ReservaServiceProxy(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @Override
    public void salvar(Reserva reserva) {
        if (reserva.getDataDevolucaoPrevista() != null && reserva.getUsuario() != null && reserva.getEquipamento() != null) {
            reservaService.salvar(reserva);
        } else {
            throw new IllegalArgumentException("Dados de reserva incompletos");
        }
    }

    @Override
    public Reserva buscarPorId(int id) {
        return reservaService.buscarPorId(id);
    }

    @Override
    public java.util.List<Reserva> listarTodos() {
        return reservaService.listarTodos();
    }

    @Override
    public void deletar(Reserva reserva) {
        reservaService.deletar(reserva);
    }
}