package com.example.beveragepricing.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "CUSTOMER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    private int id;
    @Column(name = "basic_discount")
    private double basicDiscount;
    @Column(name = "bulk_discount_over_10k")
    private double bulkDiscountOver10k;
    @Column(name = "bulk_discount_over_30k")
    private double bulkDiscountOver30k;

}
