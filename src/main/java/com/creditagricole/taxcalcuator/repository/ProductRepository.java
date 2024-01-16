package com.creditagricole.taxcalcuator.repository;

import com.creditagricole.taxcalcuator.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
