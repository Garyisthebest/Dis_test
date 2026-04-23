package com.example.orderService.controller;

import com.example.orderService.entity.Order;
import com.example.orderService.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping("/list")
    public List<Order> list() {
        return orderRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        orderRepository.deleteById(id);
        return "删除成功";
    }

    // 根据 userId 删除所有订单
    @DeleteMapping("/user/{userId}")
    public String deleteByUserId(@PathVariable Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        orderRepository.deleteAll(orders);
        return "删除用户所有订单成功";
    }
    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderRepository.save(order);
    }
}