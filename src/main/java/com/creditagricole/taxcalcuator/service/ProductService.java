package com.creditagricole.taxcalcuator.service;

import com.creditagricole.taxcalcuator.entity.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> createProductList(List<Product> products);

    Product calculateTax(Product product);

}
