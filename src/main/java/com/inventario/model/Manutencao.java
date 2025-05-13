// Manutencao.java
package com.inventario.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idManutencao;
     
    @ManyToOne
    @JoinColumn(name = "equipamento_id_equipamento") // ou o nome correto da coluna FK
    private EquipamentoTI equipamento;
    private String tipo; // preventiva ou corretiva
    private LocalDate dataAgendada;
    private String tecnico;
    private String status; // agendada, em andamento, concluída ou cancelada
    private String descricao;
    private double custoEstimado;
    private double custoReal;

    // Construtor padrão
    public Manutencao() {
    }

    // Construtor completo (sem id)
    public Manutencao(EquipamentoTI equipamento, String tipo, LocalDate dataAgendada, String tecnico, String status, String descricao, double custoEstimado) {
        this.equipamento = equipamento;
        this.tipo = tipo;
        this.dataAgendada = dataAgendada;
        this.tecnico = tecnico;
        this.status = status;
        this.descricao = descricao;
        this.custoEstimado = custoEstimado;
    }

    // Getters e Setters

    public int getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(int idManutencao) {
        this.idManutencao = idManutencao;
    }

    public EquipamentoTI getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(EquipamentoTI equipamento) {
        this.equipamento = equipamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(LocalDate dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getCustoEstimado() {
        return custoEstimado;
    }

    public void setCustoEstimado(double custoEstimado) {
        this.custoEstimado = custoEstimado;
    }

    public double getCustoReal() {
        return custoReal;
    }

    public void setCustoReal(double custoReal) {
        this.custoReal = custoReal;
    }

    // Método de negócio: concluir manutenção
    public void concluirManutencao(double custoRealFinal) {
        this.custoReal = custoRealFinal;
        this.status = "Concluída";
    }

    // Método de negócio: cancelar manutenção
    public void cancelarManutencao() {
        this.status = "Cancelada";
    }

    public String gerarOrdemDeServico() {
        return "Ordem de Serviço - Manutenção ID: " + idManutencao + "\n"
                + "Equipamento: " + (equipamento != null ? equipamento.getNome() : "N/A") + "\n"
                + "Tipo: " + tipo + "\n"
                + "Data Agendada: " + dataAgendada + "\n"
                + "Descrição: " + descricao + "\n"
                + "Custo Estimado: R$" + custoEstimado + "\n"
                + "Status: " + status + "\n";
    }
}

