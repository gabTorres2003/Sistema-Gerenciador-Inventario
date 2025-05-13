package com.inventario.strategy;
  
  import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.inventario.service.EquipamentoTIService;
  
  @Component
    public class RelatorioUsoPorCategoria implements RelatorioStrategy {

    @Autowired
    private EquipamentoTIService equipamentoTIService;

    @Override
    public String gerar() {
        StringBuilder relatorio = new StringBuilder("Relatório de Uso por Categoria:\n");

        Map<String, Long> contagem = equipamentoTIService.listarTodos().stream()
            .collect(Collectors.groupingBy(
                eq -> eq.getCategoria().getNome(),
                Collectors.counting()
            ));

        contagem.forEach((categoria, total) -> 
            relatorio.append("- ").append(categoria).append(": ").append(total).append("\n")
        );

        return relatorio.toString();
    }
}
