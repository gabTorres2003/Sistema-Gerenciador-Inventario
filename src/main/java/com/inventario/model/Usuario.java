package com.inventario.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    private String nomeCompleto;
    private String email;
    private String senha;
    private String departamento;
    private boolean ativo;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Reserva> reservas = new ArrayList<>();

    public Usuario() {}

    public Usuario(int idUsuario, String nomeCompleto, String email, String senha, String departamento, boolean ativo) {
        this.idUsuario = idUsuario;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.senha = senha;
        this.departamento = departamento;
        this.ativo = ativo;
    }

    // Getters e Setters
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    // Lógica de negócio
    public void ativar() {
        this.ativo = true;
    }

    public void desativar() {
        this.ativo = false;
    }

    public Reserva solicitarReserva(EquipamentoTI equipamento) {
        Reserva novaReserva = new Reserva(this, equipamento, LocalDate.now(), LocalDate.now().plusDays(7), "Solicitada");
        this.reservas.add(novaReserva);
        System.out.println("[Usuário] Reserva solicitada para equipamento: " + equipamento.getNome());
        return novaReserva;
    }

    public void editarPerfil(String novoNome, String novoEmail, String novaSenha, String novoDepartamento) {
        this.nomeCompleto = novoNome;
        this.email = novoEmail;
        this.senha = novaSenha;
        this.departamento = novoDepartamento;
        System.out.println("[Usuário] Perfil editado com sucesso.");
    }
}
