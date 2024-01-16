package com.creditagricole.taxcalcuator.service;

import com.creditagricole.taxcalcuator.entity.*;
import com.creditagricole.taxcalcuator.model.ShoppingCart;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@AllArgsConstructor
@Service
public class ShoppingCartServiceImp implements ShoppingCartService{


    private OrderService orderService;
    private InvoiceService invoiceService;
    @Override
    public ShoppingCart createShoppingCart() {
       return ShoppingCart.builder()
                .createdDate(LocalDateTime.now())
                .orderLines(new ArrayList<OrderLine>())
                .build();
    }

    @Override
    public void addProduct(ShoppingCart cart, Product product, Integer amount) {
        OrderLine orderLine = OrderLine.builder()
                                .product(product)
                                .amount(amount)
                                .build();

        cart.getOrderLines().add(orderLine);
    }

    @Override
    public Order validate(ShoppingCart cart) {

        //Création de la commande
        Order order = Order.builder()
                //.orderLines(cart.getOrderLines())
                .orderDate(LocalDateTime.now())
                .status(OrderStatus.PENDING)
                .build();

        order.setOrderLines(
               cart.getOrderLines().stream().map(orderLine -> {
                    orderLine.setOrder(order);
                    return orderLine;
               }).toList()
        );
      return orderService.createOrder(order);

    }

    @Override
    public void editInvoice(Order validatedOrder) {
        //Edition de la facture
        Invoice invoice= Invoice.builder()
                .order(validatedOrder)
                .build();
        Invoice editedInvoice = invoiceService.createInvoice(invoice);

        //Impression de la facture
        invoiceService.printInvoice(editedInvoice);
    }
}
