package com.dimple.codeencrypt.web.service.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserBO
 *
 * @author BianXiaofeng
 * @date 2022/11/17 10:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBO {
    private Long id;


    private String userName;

    private String realName;

    private String password;

    private Integer gender;

    private String email;
}
