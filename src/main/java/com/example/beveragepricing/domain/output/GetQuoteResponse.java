package com.example.beveragepricing.domain.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetQuoteResponse {
    private List<ProductQuote> quotes;
    private double subTotal;
    private double total;
}
