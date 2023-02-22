package com.dimple.springbootvalidate.controller;

import com.dimple.springbootvalidate.controller.vo.params.UserVOParams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Min;

/**
 * UserController
 *
 * UserController 使用了 @Validated 注解，
 * 那么 Spring Validation 就会使用 AOP 进行切面，
 * 进行参数校验。而该切面的拦截器，使用的是 MethodValidationInterceptor 。
 *
 * @author BianXiaofeng
 * @date 2/22/2023 10:35 AM
 */
@RestController
@RequestMapping("user")
@Slf4j
@Validated
public class UserController {
    @GetMapping("{id}")
    public void getUser(@PathVariable @Min(1) Integer id) {
        log.info("user id {}.", id);
    }

    @PostMapping
    public void add(@Valid @RequestBody UserVOParams user) {
        log.info("[add][addDTO: {}]", user);
    }
}
