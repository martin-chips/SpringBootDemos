package com.dimple.codeencrypt.web.controller;

import com.dimple.codeencrypt.web.controller.vo.UserVO;
import com.dimple.codeencrypt.web.controller.vo.params.UserVOParams;
import com.dimple.codeencrypt.web.service.UserService;
import com.dimple.codeencrypt.web.service.bo.UserBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author BianXiaofeng
 * @date 2022/11/17 10:36
 */
@RestController
@RequestMapping("api/user/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public UserVO getUser(@PathVariable Long id) {
        UserBO userBO = userService.getUserBy(id);
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userBO, userVO);
        return userVO;
    }

    @PostMapping
    public void saveUser(@RequestBody UserVOParams params) {
        UserBO userBO = new UserBO();
        BeanUtils.copyProperties(params, userBO);
        userService.saveUser(userBO);
    }
}
