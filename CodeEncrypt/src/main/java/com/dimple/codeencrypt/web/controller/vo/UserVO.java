package com.dimple.codeencrypt.web.controller.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserVO
 *
 * @author BianXiaofeng
 * @date 2022/11/17 10:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {
    private Long id;


    private String userName;

    private String realName;

    private String password;

    private Integer gender;

    private String email;
}
