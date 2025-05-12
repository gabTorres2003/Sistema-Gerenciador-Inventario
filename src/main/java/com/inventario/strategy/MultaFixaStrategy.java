package com.inventario.strategy;

import com.inventario.model.Reserva;
import java.math.BigDecimal;

public class MultaFixaStrategy implements MultaStrategy {
    @Override
    public BigDecimal calcular(Reserva reserva) {
        return BigDecimal.valueOf(20); // valor fixo
    }
}
