package com.example.userService.controller;

import com.example.userService.entity.User;
import com.example.userService.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate; // 注入

    // 1. 查询所有
    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // 2. 根据ID查询
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // 3. 新增 / 修改
    @PostMapping
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        // 1. 先调用订单服务，删除该用户的所有订单
        restTemplate.delete("http://localhost:8002/order/user/" + id);

        // 2. 再删除用户
        userRepository.deleteById(id);

        return "用户 + 关联订单全部删除成功！";
    }
}