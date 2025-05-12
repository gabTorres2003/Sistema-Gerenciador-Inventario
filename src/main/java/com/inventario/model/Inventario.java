package com.inventario.model;

import jakarta.persistence.*;

@Entity
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idItem;

    @ManyToOne
    @JoinColumn(name = "equipamento_id_equipamento") // ou o nome correto da coluna FK
    private EquipamentoTI equipamento;
    private String localizacao;
    private int quantidadeDisponivel;

    public Inventario(int idItem, EquipamentoTI equipamento, String localizacao, int quantidadeDisponivel) {
        this.idItem = idItem;
        this.equipamento = equipamento;
        this.localizacao = localizacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    // Getters e Setters
    public int getIdItem() {
        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public EquipamentoTI getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(EquipamentoTI equipamento) {
        this.equipamento = equipamento;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    // Métodos de negócio:

    public void registrarEntrada(int quantidade) {
        if (quantidade > 0) {
            this.quantidadeDisponivel += quantidade;
            System.out.println("[INVENTÁRIO] Entrada registrada: +" + quantidade + " unidades.");
        } else {
            System.out.println("[ERRO] Quantidade inválida para entrada.");
        }
    }

    public void registrarSaida(int quantidade) {
        if (quantidade > 0 && quantidade <= this.quantidadeDisponivel) {
            this.quantidadeDisponivel -= quantidade;
            System.out.println("[INVENTÁRIO] Saída registrada: -" + quantidade + " unidades.");
        } else {
            System.out.println("[ERRO] Quantidade inválida para saída.");
        }
    }

    public void emitirAlertaDeReposicao() {
        if (this.quantidadeDisponivel < 5) {
            System.out.println("[ALERTA] Estoque baixo para o equipamento: " + equipamento.getNome() +
                               " | Quantidade disponível: " + this.quantidadeDisponivel);
        }
    }
}
