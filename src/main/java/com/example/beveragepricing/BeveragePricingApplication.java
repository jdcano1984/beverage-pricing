package com.example.beveragepricing;

import com.example.beveragepricing.domain.input.GetQuoteRequest;
import com.example.beveragepricing.domain.input.ProductOrder;
import com.example.beveragepricing.service.BeveragePricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
@EnableJpaRepositories("com.example.beveragepricing.repositories")
public class BeveragePricingApplication implements CommandLineRunner {

	@Autowired
	BeveragePricingService service;

	public static void main(String[] args) {
		SpringApplication.run(BeveragePricingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the customer ID and the amount to order of every product separated by spaces");
		String inputLine =  scanner.nextLine();
		String[] numbersStr = inputLine.split("\\s+");
		if(numbersStr.length != 5){
			System.out.println("You must enter 5 integers separated by spaces");
			return;
		}

		var orders = new ArrayList<ProductOrder>();

		for(int i=1; i<numbersStr.length; i++){
			if(Integer.parseInt(numbersStr[i]) > 0){
				orders.add(new ProductOrder(getProductNameByIndex(i), Integer.parseInt(numbersStr[i])));
			}
		}

		var result = service.createQuote(new GetQuoteRequest(Long.parseLong(numbersStr[0]), orders));

		for(var productQuote : result.getQuotes()){
			System.out.println("Product: "+productQuote.getProduct().getName()+
					           ". Base Price: "+String.format("%.2f", productQuote.getProductPrice())+
					           ". Total: "+String.format("%.2f", productQuote.getProductTotal())
					);
		}
		System.out.println("Subtotal(Before customer discounts): "+String.format("%.2f", result.getSubTotal()));
		System.out.println("Total(After customer discounts): "+String.format("%.2f", result.getTotal()));

	}

	private String getProductNameByIndex(int index){
		switch (index){
			case 1:
				return "A";
			case 2:
				return "B";
			case 3:
				return "C";
			case 4:
				return "D";
		}
		return "";
	}
}
