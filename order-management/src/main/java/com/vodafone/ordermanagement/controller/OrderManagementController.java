package com.vodafone.ordermanagement.controller;

import com.vodafone.ordermanagement.dto.CreateOrderDto;
import com.vodafone.ordermanagement.dto.OrderDto;
import com.vodafone.ordermanagement.feign.OrderFeign;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;


@RestController
@RequestMapping(path="/order-management")
public class OrderManagementController {
    
    @Autowired private OrderFeign orderFeign;

    @ApiOperation(value = "Given an order id, retrieves the order information")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", value = "/{id}")
    public OrderDto getOrderById(@PathVariable("id") Long orderId) {
        return orderFeign.getOrderById(orderId);
    }

    @ApiOperation(value = "Stores new order in the system")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public OrderDto addOrder(@RequestBody CreateOrderDto orderDto) {
        return orderFeign.addOrder(orderDto);
    }

    @ApiOperation(value = "Given an order id, deletes the order information. It will throw an exception if the order id is not found")
    @RequestMapping(method = RequestMethod.DELETE, produces = "application/json", value = "/{id}")
    public void deleteOrder(@PathVariable("id") Long orderId) throws NoSuchElementException {
        try {
            orderFeign.deleteOrderById(orderId);
        }catch (Exception e){
            throw new NoSuchElementException(e.getCause().getCause().getMessage());
        }

    }
}
