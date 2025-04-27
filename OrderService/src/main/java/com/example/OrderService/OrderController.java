package com.example.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Orders> placeOrder(@RequestBody Orders order) {
        Orders placedOrder = orderService.placeOrder(order);
        return new ResponseEntity<>(placedOrder, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable Long id) {
        Orders order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Orders>> getOrdersByUser(@PathVariable Long userId) {
        List<Orders> orders = orderService.getOrdersByUser(userId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }
}

