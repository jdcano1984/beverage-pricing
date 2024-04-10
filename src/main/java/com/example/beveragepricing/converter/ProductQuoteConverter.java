package com.example.beveragepricing.converter;


import com.example.beveragepricing.domain.output.ProductQuote;
import com.example.beveragepricing.model.MarkupType;
import com.example.beveragepricing.model.Product;

public class ProductQuoteConverter {

    public static ProductQuote convert(Product input, int quantity){
        if(input == null){
            return null;
        }

        var unitPrice = input.getUnitCost();
        if(input.getMarkupType() == MarkupType.PER_UNIT){
            unitPrice+= input.getMarkup();
        } else {
            unitPrice*= 1+input.getMarkup()/100;
        }

        if(input.getPromotion() != null){
            unitPrice *= (100-input.getPromotion())/100;
        }

        return new ProductQuote(input, quantity, unitPrice, quantity * unitPrice);
    }

    private ProductQuoteConverter(){
        // Do nothing on purpose
    }
}
