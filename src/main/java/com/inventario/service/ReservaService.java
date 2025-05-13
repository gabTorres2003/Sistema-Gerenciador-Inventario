package com.inventario.service;

import com.inventario.model.Reserva;
import java.util.List;

public interface ReservaService {
    void salvar(Reserva reserva);
    Reserva buscarPorId(int id);
    List<Reserva> listarTodos();
    void deletar(Reserva reserva);
}