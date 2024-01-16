package com.creditagricole.taxcalcuator.entity;

import com.creditagricole.taxcalcuator.entity.OrderLine;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @Setter @Getter

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "order",
               cascade = {CascadeType.ALL}
    )
    private List<OrderLine> orderLines;
    private LocalDateTime orderDate;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @Transient
    private Double totalPriceWithTax;
    @Transient
    private Double totalTax;

    @Override
    public String toString() {

        String newLine = System.lineSeparator();
        List<String> orderLines = new ArrayList<>();
        this.orderLines.forEach(orderLine -> {
            orderLines.add(
              String.format("%d * %s à %.2f€ : %.2f€ TTC",
                      orderLine.getAmount(),
                      orderLine.getProduct().getDescription(),
                      orderLine.getProduct().getPrice(),
                      orderLine.getAmount() * orderLine.getProduct().getWithTaxPrice()
              )
            );
        });
        return String.join(newLine,
                    String.join(newLine,orderLines),
                    newLine,
                    String.format("Montant des taxes : %.2f€",this.getTotalTax()),
                    String.format("Total : %.2f€",this.getTotalPriceWithTax())
                );

    }


}
