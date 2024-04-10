package com.example.beveragepricing.domain.input;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetQuoteRequest {

    @NotNull
    private Long customerId;
    @NotNull
    private List<ProductOrder> productOrders;
}
