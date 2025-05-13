package com.inventario.service.impl;

import com.inventario.model.Manutencao;
import com.inventario.repository.ManutencaoRepository;
import com.inventario.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManutencaoServiceImpl implements ManutencaoService {

    @Autowired
    private ManutencaoRepository manutencaoRepository;

    public void salvar(Manutencao manutencao) {
        manutencaoRepository.save(manutencao);
    }

    public Manutencao buscarPorId(int id) {
        return manutencaoRepository.findById(id).orElse(null);
    }

    public List<Manutencao> listarTodos() {
        return manutencaoRepository.findAll();
    }

    public void deletar(Manutencao manutencao) {
        manutencaoRepository.delete(manutencao);
    }
}
