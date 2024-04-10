package com.example.beveragepricing.converter;


import com.example.beveragepricing.domain.output.GetQuoteResponse;
import com.example.beveragepricing.domain.output.ProductQuote;
import com.example.beveragepricing.model.Customer;

import java.util.List;

public class GetQuoteResponseConverter {

    public static GetQuoteResponse convert(Customer customer, List<ProductQuote> input) {
        if (input == null || customer == null) {
            return null;
        }

        var subtotal = input.stream().mapToDouble(ProductQuote::getProductTotal).sum();
        var discount = customer.getBasicDiscount();
        if(subtotal > 30000){
            discount += customer.getBulkDiscountOver30k();
        } else if (subtotal > 10000){
            discount += customer.getBulkDiscountOver10k();
        }
        return new GetQuoteResponse(input, subtotal, subtotal*((100-discount))/100);
    }

    private GetQuoteResponseConverter(){
        // Do nothing on purpose
    }
}
