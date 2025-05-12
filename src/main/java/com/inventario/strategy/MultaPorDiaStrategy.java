package com.inventario.strategy;

import com.inventario.model.Reserva;
import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class MultaPorDiaStrategy implements MultaStrategy {
    @Override
    public BigDecimal calcular(Reserva reserva) {
        if (reserva.getDataDevolucaoReal() == null ||
            !reserva.getDataDevolucaoReal().isAfter(reserva.getDataDevolucaoPrevista())) {
            return BigDecimal.ZERO;
        }
        long dias = ChronoUnit.DAYS.between(
            reserva.getDataDevolucaoPrevista(),
            reserva.getDataDevolucaoReal()
        );
        return BigDecimal.valueOf(dias * 5);
    }
}