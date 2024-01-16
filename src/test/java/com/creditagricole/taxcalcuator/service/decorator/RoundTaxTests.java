package com.creditagricole.taxcalcuator.service.decorator;

import com.creditagricole.taxcalcuator.entity.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundTaxTests {
    private static RoundTax roundTax;

    @BeforeAll
    public static void initImportTaxTax(){
        roundTax = new RoundTax();
    }

    @Test
    public void getTax_ReturnRoundTax(){
        //Given
        Product p =  Product.builder()
                .description("Flacon de parfum")
                .price(1.99)
                .imported(true)
                .build();
        roundTax.setProduct(p);
        //When
        double tax = roundTax.getTax();
        //Then
        assertThat(tax).isEqualTo(2.0);
    }
}
