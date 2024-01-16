package com.creditagricole.taxcalcuator.repository;

import com.creditagricole.taxcalcuator.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
