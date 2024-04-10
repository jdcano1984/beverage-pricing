package com.example.beveragepricing.service;


import com.example.beveragepricing.domain.input.GetQuoteRequest;
import com.example.beveragepricing.domain.output.GetQuoteResponse;

public interface BeveragePricingService {

    GetQuoteResponse createQuote(GetQuoteRequest request);
}
