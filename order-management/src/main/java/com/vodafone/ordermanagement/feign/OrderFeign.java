package com.vodafone.ordermanagement.feign;

import com.vodafone.ordermanagement.dto.CreateOrderDto;
import com.vodafone.ordermanagement.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.NoSuchElementException;

@FeignClient("orders")
public interface OrderFeign {

    @RequestMapping(method = RequestMethod.GET, path="/orders/{id}")
    OrderDto getOrderById(@PathVariable(value = "id") Long id);

    @RequestMapping(method = RequestMethod.POST, path="/orders")
    OrderDto addOrder(@RequestBody CreateOrderDto orderDto);

    @RequestMapping(method = RequestMethod.DELETE, path="/orders/{id}")
    void deleteOrderById(@PathVariable(value = "id") Long id) throws NoSuchElementException;

}
