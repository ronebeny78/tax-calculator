package com.creditagricole.taxcalcuator.service.decorator;

import com.creditagricole.taxcalcuator.entity.Category;
import com.creditagricole.taxcalcuator.entity.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class VatTaxTests {

    private static VatTax vatTax;

    @BeforeAll
    public static void initVatTax(){
        vatTax= new VatTax();
    }

    @Test
    public void getTax_ReturnBookCategoryTax(){
        //Given
        Product p =  Product.builder()
                .description("Livre")
                .price(12.49)
                .category(Category.BOOK)
                .build();
        vatTax.setProduct(p);
        //When
        double tax = vatTax.getTax();
        //Then
        assertThat(tax).isEqualTo(1.2490000186115504);
    }

    @Test
    public void getTax_ReturnVitalCategoryTax(){
        //Given
        Product p =  Product.builder()
                .description("boîte de pilules contre la migraine")
                .price(9.75)
                .category(Category.VITAL)
                .build();
        vatTax.setProduct(p);
        //When
        double tax = vatTax.getTax();
        //Then
        assertThat(tax).isEqualTo(0);
    }

    @Test
    public void getTax_ReturnNormalCategoryTax(){
        Product p =  Product.builder()
                .description("CD musical")
                .price(14.99)
                .build();
        vatTax.setProduct(p);
        //When
        double tax = vatTax.getTax();
        //Then
        assertThat(tax).isEqualTo(2.9980000446736814);
    }
}
