package com.creditagricole.taxcalcuator.service;

import com.creditagricole.taxcalcuator.entity.Category;
import com.creditagricole.taxcalcuator.entity.Product;
import com.creditagricole.taxcalcuator.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImp productService;

    @Test
    public void calculateTax_ReturnVitalProductTax(){
        //Given
        Product p = Product.builder()
                .description("boîte de pilules contre la migraine")
                .price(9.75)
                .category(Category.VITAL)
                .build();
        //When
        p = productService.calculateTax(p);
        //Then
        assertThat(p.getTax()).isEqualTo(0);
    }

    @Test
    public void calculateTax_ReturnImportedVitalProductTax(){
        //Given
        Product p = Product.builder()
                .description("boîte de pilules contre la migraine")
                .price(9.75)
                .imported(true)
                .category(Category.VITAL)
                .build();
        //When
        p = productService.calculateTax(p);
        //Then
        assertThat(p.getTax()).isEqualTo(0.5);
    }



    @Test
    public void calculateTax_ReturnBookProductTax(){
        //Given
        Product p = Product.builder()
                .description("Livre")
                .price(12.49)
                .category(Category.BOOK)
                .build();
        //When
        p = productService.calculateTax(p);
        //Then
        assertThat(p.getTax()).isEqualTo(1.25);
    }

    @Test
    public void calculateTax_ReturnImportedBookProductTax(){
        //Given
        Product p = Product.builder()
                .description("Livre")
                .price(12.49)
                .imported(true)
                .category(Category.BOOK)
                .build();
        //When
        p = productService.calculateTax(p);
        //Then
        assertThat(p.getTax()).isEqualTo(1.9);
    }


    @Test
    public void calculateTax_ReturnNormalProductTax(){
        //Given
        Product p = Product.builder()
                .description("CD musical")
                .price(14.99)
                .build();
        //When
        p = productService.calculateTax(p);
        //Then
        assertThat(p.getTax()).isEqualTo(3.0);
    }

    @Test
    public void calculateTax_ReturnImportedNormalProductTax(){
        //Given
        Product p = Product.builder()
                .description("CD musical")
                .imported(true)
                .price(14.99)
                .build();
        //When
        p = productService.calculateTax(p);
        //Then
        assertThat(p.getTax()).isEqualTo(3.75);
    }

}
