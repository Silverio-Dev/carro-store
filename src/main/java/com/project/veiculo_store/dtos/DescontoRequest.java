package com.project.veiculo_store.dtos;

import java.math.BigDecimal;

public class DescontoRequest {
    private BigDecimal percentual;

    public BigDecimal getPercentual() {
        return percentual;
    }

    public void setPercentual(BigDecimal percentual) {
        this.percentual = percentual;
    }
}
