package com.inventario.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "equipamento_id_equipamento") // ou o nome correto da coluna FK
    private EquipamentoTI equipamento;

    private LocalDate dataReserva;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private String status;
   

    // Construtor padrão
    public Reserva() {
    }

    // Construtor completo (sem id)
    public Reserva(Usuario usuario, EquipamentoTI equipamento, LocalDate dataReserva, LocalDate dataDevolucaoPrevista, String status) {
        this.usuario = usuario;
        this.equipamento = equipamento;
        this.dataReserva = dataReserva;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
        this.status = status;
    }

    // Getters e Setters

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EquipamentoTI getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(EquipamentoTI equipamento) {
        this.equipamento = equipamento;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public LocalDate getDataDevolucaoReal() {
        return dataDevolucaoReal;
    }

    public void setDataDevolucaoReal(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Método de negócio: calcular multa por atraso
    public double calcularMultaAtraso() {
        if (dataDevolucaoReal == null || !dataDevolucaoReal.isAfter(dataDevolucaoPrevista)) {
            return 0.0;
        }
        long diasAtraso = java.time.temporal.ChronoUnit.DAYS.between(dataDevolucaoPrevista, dataDevolucaoReal);
        double valorMultaPorDia = 5.0; // valor simbólico por dia de atraso
        return diasAtraso * valorMultaPorDia;
    }

    // Método de negócio: finalizar reserva
    public void finalizarReserva(LocalDate dataDevolucaoReal) {
        this.dataDevolucaoReal = dataDevolucaoReal;
        this.status = "Finalizada";
    }
}
