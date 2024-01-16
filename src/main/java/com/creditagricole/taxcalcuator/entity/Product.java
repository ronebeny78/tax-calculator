package com.creditagricole.taxcalcuator.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder @ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double price;
    protected String description;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Builder.Default
    private Boolean imported = false;
    @Transient
    protected Double tax;
    @Transient
    protected Double withTaxPrice;

    public Double getTax() {
        if(tax == null)
            return this.price;
        return tax;
    }

}
