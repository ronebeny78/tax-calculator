package com.creditagricole.taxcalcuator.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder @Data @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode @Setter @Getter
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private Integer amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;





}
