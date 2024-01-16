package com.creditagricole.taxcalcuator.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor @AllArgsConstructor @Builder @Getter @Setter
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Order order;

    @Override
    public String toString() {
        String newLine = System.lineSeparator();
        return String.join(newLine,String.format("### Facture n°: %d",this.id),this.order.toString(),newLine);

    }
}
