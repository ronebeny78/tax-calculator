package com.creditagricole.taxcalcuator;

import com.creditagricole.taxcalcuator.entity.Category;
import com.creditagricole.taxcalcuator.entity.Product;
import com.creditagricole.taxcalcuator.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class TaxCalcuatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaxCalcuatorApplication.class, args);
    }


}
