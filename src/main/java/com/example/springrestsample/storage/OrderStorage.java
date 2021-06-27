package com.example.springrestsample.storage;

import com.example.springrestsample.entity.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderStorage {

    private List<Order> orders = new ArrayList<>();
    private static long incId;

    private Order incId(Order order){
        order.setId(incId++);
        return order;
    }

    public Order save(Order order){
        incId(order);
        orders.add(order);
        return order;
    }

    public Order getById(long id){
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public boolean deleteById(Long id){
        for (Order order : orders) {
            if (order.getId() == id) {
                orders.remove(order);
                return true;
            }
        }
        return false;
    }
}
