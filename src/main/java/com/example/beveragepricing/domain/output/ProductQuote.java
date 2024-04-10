package com.example.beveragepricing.domain.output;

import com.example.beveragepricing.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductQuote {

    private Product product;
    private int quantityOrdered;
    private double productPrice;
    private double productTotal;

}
