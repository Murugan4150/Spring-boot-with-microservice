package com.example.OrderService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private ProductServiceClient productServiceClient;

    @Autowired
    private UserServiceClient userServiceClient;

    @Autowired
    private InventoryServiceClient inventoryServiceClient;

    @Autowired
    private OrderRepository orderRepository;

    public Orders placeOrder(Orders order) {
        // Validate user
        User user = userServiceClient.getUserById(order.getUserId());
        if (user == null) {
            throw new RuntimeException("User not found!");
        }

        // Validate product
        Product product = productServiceClient.getProductById(order.getProductId());
        if (product == null) {
            throw new RuntimeException("Product not found!");
        }

        // Check inventory
        Inventory inventory = inventoryServiceClient.getInventoryByProductId(order.getProductId());
        if (inventory.getStock() < order.getQuantity()) {
            throw new RuntimeException("Not enough stock available!");
        }

        // Deduct stock
        inventory.setStock(inventory.getStock() - order.getQuantity());
        inventoryServiceClient.deductStock(inventory);

        // Place order
        order.setStatus("PLACED");
        return orderRepository.save(order);
    }

    public Orders getOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found!"));
    }

    public List<Orders> getOrdersByUser(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}

