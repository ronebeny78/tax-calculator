package com.creditagricole.taxcalcuator.service.decorator;


import com.creditagricole.taxcalcuator.entity.Product;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter
public  class TaxDecorator extends Product {
    protected Product product;

    public TaxDecorator(Product product) {
        this.product = product;
    }

}
