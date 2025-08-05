package com.example.order_service;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface OrderRepository extends CrudRepository<Order, String> {
    // Basic CRUD operations are inherited
    // Add custom query methods if needed
}