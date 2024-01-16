package com.creditagricole.taxcalcuator.model;

import com.creditagricole.taxcalcuator.entity.OrderLine;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor @AllArgsConstructor @Builder @Getter @Setter
public class ShoppingCart {

    private LocalDateTime createdDate ;

    private List<OrderLine> orderLines;

}
