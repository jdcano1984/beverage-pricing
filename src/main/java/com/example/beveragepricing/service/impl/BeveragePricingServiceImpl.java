package com.example.beveragepricing.service.impl;

import com.example.beveragepricing.converter.GetQuoteResponseConverter;
import com.example.beveragepricing.converter.ProductQuoteConverter;
import com.example.beveragepricing.domain.input.GetQuoteRequest;
import com.example.beveragepricing.domain.output.GetQuoteResponse;
import com.example.beveragepricing.domain.output.ProductQuote;
import com.example.beveragepricing.model.Product;
import com.example.beveragepricing.repositories.CustomerRepository;
import com.example.beveragepricing.repositories.ProductRepository;
import com.example.beveragepricing.service.BeveragePricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BeveragePricingServiceImpl implements BeveragePricingService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public GetQuoteResponse createQuote(GetQuoteRequest request) {
        var customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID"));

        var productQuotes = new ArrayList<ProductQuote>();
        for(var productOrder : request.getProductOrders()){
            Product product = productRepository.findByName(productOrder.getProductName())
                    .orElseThrow(() -> new IllegalArgumentException("Invalid product name"));
            productQuotes.add(ProductQuoteConverter.convert(product, productOrder.getProductQuantity()));
        }

        return GetQuoteResponseConverter.convert(customer,productQuotes);
    }
}
