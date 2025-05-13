package com.inventario.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String acao;
    private LocalDateTime dataHora;

    @ManyToOne
    private Usuario usuario;

    private String detalhes;

    public Auditoria() {}

    public Auditoria(String acao, Usuario usuario, String detalhes) {
        this.acao = acao;
        this.usuario = usuario;
        this.detalhes = detalhes;
        this.dataHora = LocalDateTime.now();
    }
    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcao() {
        return acao;
    }

    public void setAcao(String acao) {
        this.acao = acao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    // Método auxiliar
    public void registrarAcao(String acao, Usuario usuario, String detalhes) {
        this.acao = acao;
        this.usuario = usuario;
        this.detalhes = detalhes;
        this.dataHora = LocalDateTime.now();
    }
}
