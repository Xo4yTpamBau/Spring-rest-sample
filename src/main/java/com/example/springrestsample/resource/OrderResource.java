package com.example.springrestsample.resource;

import com.example.springrestsample.entity.Order;
import com.example.springrestsample.repository.OrderRepository;
import com.example.springrestsample.storage.OrderStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("order")
public class OrderResource {

    @Autowired
    private OrderRepository orderRepository;

    @PostMapping("save")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        Order save = orderRepository.save(order);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @PostMapping("getById")
    public ResponseEntity<Order> getById(long id) {
        Optional<Order> byId = orderRepository.findById(id);
        return new ResponseEntity<>(byId.get(), HttpStatus.OK);
    }

    @PostMapping("deleteById")
    public ResponseEntity<Order> deleteById(long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

