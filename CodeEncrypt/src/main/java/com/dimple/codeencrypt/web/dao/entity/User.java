package com.dimple.codeencrypt.web.dao.entity;

import lombok.Data;

/**
 * User
 *
 * @author BianXiaofeng
 * @date 2022/11/17 14:10
 */
@Data
public class User {
    private Long id;

    private String userName;

    private String realName;

    private String password;

    private Integer gender;

    private String email;
}
