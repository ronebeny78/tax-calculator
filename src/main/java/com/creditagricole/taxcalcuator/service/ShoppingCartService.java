package com.creditagricole.taxcalcuator.service;

import com.creditagricole.taxcalcuator.entity.Order;
import com.creditagricole.taxcalcuator.entity.Product;
import com.creditagricole.taxcalcuator.model.ShoppingCart;

import java.time.LocalDateTime;

public interface ShoppingCartService {

    public ShoppingCart createShoppingCart();
    public void addProduct(ShoppingCart cart,Product product, Integer amount);
    public Order validate(ShoppingCart cart);
    public void editInvoice(Order validatedOrder);
}
