package com.example.orderService.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// 调用 userService 服务
@FeignClient(name = "userService")
public interface UserFeignClient {

    // 调用用户服务的接口：根据ID查用户
    @GetMapping("/user/getUserById/{id}")
    Object getUserById(@PathVariable("id") Long id);
}