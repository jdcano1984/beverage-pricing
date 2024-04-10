package com.example.beveragepricing.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    private String name;
    @Column(name = "unit_cost")
    private double unitCost;
    @Column(name = "markup_type")
    @Enumerated(EnumType.STRING)
    private MarkupType markupType;
    private double markup;
    private Double promotion;

}
