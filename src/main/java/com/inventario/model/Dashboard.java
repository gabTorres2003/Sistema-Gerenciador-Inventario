package com.inventario.model;

import java.util.List;

public class Dashboard {

    // Exibe o uso dos equipamentos: quantas reservas existem
    public void exibirUsoDeEquipamento(List<Reserva> reservas) {
        System.out.println("\n=== Uso de Equipamentos ===");
        reservas.forEach(reserva -> {
            System.out.println("Equipamento: " + reserva.getEquipamento().getNome() + " | Status: " + reserva.getStatus());
        });
    }

    // Monitora status de reservas (quantas estão solicitadas, em uso, concluídas, canceladas)
    public void monitorarStatus(List<Reserva> reservas) {
        System.out.println("\n=== Monitoramento de Status de Reservas ===");

        long solicitadas = reservas.stream().filter(r -> "Solicitada".equalsIgnoreCase(r.getStatus())).count();
        long emUso = reservas.stream().filter(r -> "Em uso".equalsIgnoreCase(r.getStatus())).count();
        long concluidas = reservas.stream().filter(r -> "Concluída".equalsIgnoreCase(r.getStatus())).count();
        long canceladas = reservas.stream().filter(r -> "Cancelada".equalsIgnoreCase(r.getStatus())).count();

        System.out.println("Solicitadas: " + solicitadas);
        System.out.println("Em uso: " + emUso);
        System.out.println("Concluídas: " + concluidas);
        System.out.println("Canceladas: " + canceladas);
    }

    // Rastreia reservas e manutenções pendentes
    public void rastrearReservasManutencoes(List<Reserva> reservas, List<Manutencao> manutencoes) {
        System.out.println("\n=== Rastreamento de Reservas e Manutenções ===");

        System.out.println("\nReservas Pendentes:");
        reservas.stream()
                .filter(r -> "Solicitada".equalsIgnoreCase(r.getStatus()))
                .forEach(r -> System.out.println("Reserva ID: " + r.getIdReserva() + " | Equipamento: " + r.getEquipamento().getNome()));

        System.out.println("\nManutenções Agendadas:");
        manutencoes.stream()
                .filter(m -> "Agendada".equalsIgnoreCase(m.getStatus()))
                .forEach(m -> System.out.println("Manutenção ID: " + m.getIdManutencao() + " | Equipamento: " + m.getEquipamento().getNome()));
    }

    // Exibe mapeamento de setores baseado nos departamentos dos usuários
    public void exibirMapeamentoSetores(List<Usuario> usuarios) {
        System.out.println("\n=== Mapeamento de Setores ===");
        usuarios.forEach(usuario -> {
            System.out.println("Usuário: " + usuario.getNomeCompleto() + " | Departamento: " + usuario.getDepartamento());
        });
    }
}
