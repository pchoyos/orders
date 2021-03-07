package com.vodafone.ordermanagement.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateOrderDto {

    @NotNull
    @NotEmpty
    private Long customerId;
    @NotNull
    @NotEmpty
    private Long productId;
    @NotNull
    @NotEmpty
    private String timestamp;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
