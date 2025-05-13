package com.inventario.model;

import java.util.List;


public class Administrador extends Usuario {

    private String nivelDeAcesso; // baixo, médio, alto
    private Dashboard dashboard = new Dashboard(); // Dashboard interno

    public Administrador(int idUsuario, String nomeCompleto, String email, String senha, String departamento, boolean ativo, String nivelDeAcesso) {
        super(idUsuario, nomeCompleto, email, senha, departamento, ativo);
        this.nivelDeAcesso = nivelDeAcesso;
    }

    public String getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(String nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
    }

    // Método: Desativar usuário
    public void desativarUsuario(Usuario usuario) {
        if (usuario != null && usuario.isAtivo()) {
            usuario.desativar();
            System.out.println("[ADMIN] Usuário " + usuario.getNomeCompleto() + " desativado com sucesso.");
        } else {
            System.out.println("[ERRO] Usuário inválido ou já está desativado.");
        }
    }

    // Método: Gerar relatório de movimentações (reservas e manutenções)
    public void gerarRelatorioMovimentacao(List<Reserva> reservas, List<Manutencao> manutencoes) {
        System.out.println("\n=== Relatório de Movimentações ===");
        dashboard.rastrearReservasManutencoes(reservas, manutencoes);
    }

    // Método: Visualizar dashboard (uso e status)
    public void visualizarDashboard(List<Reserva> reservas, List<Manutencao> manutencoes) {
        System.out.println("\n=== Dashboard Geral ===");
        dashboard.exibirUsoDeEquipamento(reservas);
        dashboard.monitorarStatus(reservas);
    }

    // Método: Exibir mapeamento de setores (departamentos)
    public void exibirMapeamentoSetores(List<Usuario> usuarios) {
        System.out.println("\n=== Mapeamento de Setores ===");
        dashboard.exibirMapeamentoSetores(usuarios);
    }

    // Método: Alterar categoria de um equipamento
    public void alterarCategoriaEquipamento(EquipamentoTI equipamento, CategoriaTI novaCategoria) {
        if (equipamento != null && novaCategoria != null) {
            equipamento.setCategoria(novaCategoria);
            System.out.println("[ADMIN] Categoria do equipamento " + equipamento.getNome() + " alterada para: " + novaCategoria);
        } else {
            System.out.println("[ERRO] Equipamento ou categoria inválidos.");
        }
    }
}
