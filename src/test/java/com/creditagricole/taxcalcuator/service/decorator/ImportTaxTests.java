package com.creditagricole.taxcalcuator.service.decorator;

import com.creditagricole.taxcalcuator.entity.Category;
import com.creditagricole.taxcalcuator.entity.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ImportTaxTests {
    private static ImportTax importTax;

    @BeforeAll
    public static void initImportTaxTax(){
        importTax = new ImportTax();
    }

    @Test
    public void getTax_ReturnImportTax(){
        //Given
        Product p =  Product.builder()
                .description("Flacon de parfum")
                .price(27.99)
                .imported(true)
                .build();
        importTax.setProduct(p);
        //When
        double tax = importTax.getTax();
        //Then
        assertThat(tax).isEqualTo(1.399500020854175);
    }
}
