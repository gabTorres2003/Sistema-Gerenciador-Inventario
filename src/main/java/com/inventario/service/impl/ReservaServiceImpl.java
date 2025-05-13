package com.inventario.service.impl;

import com.inventario.model.Reserva;
import com.inventario.repository.ReservaRepository;
import com.inventario.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public void salvar(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    public Reserva buscarPorId(int id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public List<Reserva> listarTodos() {
        return reservaRepository.findAll();
    }

    public void deletar(Reserva reserva) {
        reservaRepository.delete(reserva);
    }
}