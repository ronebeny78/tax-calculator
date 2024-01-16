package com.creditagricole.taxcalcuator.service;

import com.creditagricole.taxcalcuator.entity.Order;
import com.creditagricole.taxcalcuator.entity.Product;
import com.creditagricole.taxcalcuator.repository.OrderRepository;
import com.creditagricole.taxcalcuator.service.decorator.ImportTax;
import com.creditagricole.taxcalcuator.service.decorator.RoundTax;
import com.creditagricole.taxcalcuator.service.decorator.VatTax;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderServiceImp implements OrderService{

    private OrderRepository orderRepository;
    @Override
    public Order createOrder(Order order) {

        Order savedOrder = orderRepository.save(order);
        calculateTotalTax(savedOrder);
        calculateTotalWithTaxPrice(savedOrder);
        return savedOrder;
    }

    private Order calculateTotalTax(Order order){
        double totalTax = order.getOrderLines().stream()
                .map(o -> o.getAmount() * o.getProduct().getTax())
                .reduce(0d, Double::sum);

        order.setTotalTax(totalTax);
        return order;
    }

    private Order calculateTotalWithTaxPrice(Order order){
        double totalWithTaxPrice = order.getOrderLines().stream()
                .map(o -> o.getAmount() * o.getProduct().getWithTaxPrice())
                .reduce(0d, Double::sum);

        order.setTotalPriceWithTax(totalWithTaxPrice);
        return order;
    }
}
