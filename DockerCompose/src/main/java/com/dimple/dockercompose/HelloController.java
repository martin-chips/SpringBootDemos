package com.dimple.dockercompose;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author BianXiaofeng
 * @date 12/8/2022 4:36 PM
 */
@RestController
@RequestMapping("hello")
public class HelloController {
    @GetMapping
    public String hello() {
        return "Hello";
    }
}
