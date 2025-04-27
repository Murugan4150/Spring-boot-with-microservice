package com.example.OrderService;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders,Long> {

	List<Orders> findByUserId(Long userId);

}
