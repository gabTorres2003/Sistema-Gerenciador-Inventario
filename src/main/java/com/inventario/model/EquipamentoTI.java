package com.inventario.model;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.*;

@Entity
public class EquipamentoTI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipamento;
    private String nome;
    private String numeroSerie;
    private LocalDate dataCompra;
    private String estado;
    private String localizacao;
    private int quantidade;
    
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private CategoriaTI categoria;

    // Construtor padrão
    public EquipamentoTI() {
    }

    // Construtor completo
    public EquipamentoTI(int idEquipamento, String nome, String numeroSerie, LocalDate dataCompra, String estado, int quantidade, CategoriaTI categoria) {
        this.idEquipamento = idEquipamento;
        this.nome = nome;
        this.numeroSerie = numeroSerie;
        this.dataCompra = dataCompra;
        this.estado = estado;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    // Getters e Setters

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(int idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDate dataCompra) {
        this.dataCompra = dataCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public CategoriaTI getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaTI categoria) {
        this.categoria = categoria;
    }

    // Método de negócio (do seu diagrama): verificarGarantia()
   public boolean verificarGarantia() {
        if (dataCompra == null) {
            return false; // Se não tiver data de compra, consideramos sem garantia
        }
        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataCompra, hoje);

        // Se passaram menos de 2 anos desde a compra
        return periodo.getYears() < 2;
    }
}
