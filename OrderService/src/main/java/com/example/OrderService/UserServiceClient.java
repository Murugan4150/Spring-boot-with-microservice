package com.example.OrderService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", url = "http://localhost:8082")
public interface UserServiceClient {

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable("id") Long id);

    @PostMapping("/users/validate")
    boolean validateUser(@RequestBody User user);
}
