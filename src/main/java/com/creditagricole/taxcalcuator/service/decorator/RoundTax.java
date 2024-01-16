package com.creditagricole.taxcalcuator.service.decorator;


import com.creditagricole.taxcalcuator.entity.Product;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @Setter @ToString
public class RoundTax extends TaxDecorator {

    public static final float ROUND_TAX_VALUE = 0.05f;
    public RoundTax(Product product) {
        super(product);
    }

    @Override
    public Double getPrice() {
        return product.getPrice();
    }

    @Override
    public Double getTax() {
        double roundedValue = Math.ceil(product.getTax()/ ROUND_TAX_VALUE) * ROUND_TAX_VALUE;
        return Math.round(roundedValue * 100) / 100.0;
    }

}
