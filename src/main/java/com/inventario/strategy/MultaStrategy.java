package com.inventario.strategy;

import com.inventario.model.Reserva;
import java.math.BigDecimal;

public interface MultaStrategy {
    BigDecimal calcular(Reserva reserva);
}
