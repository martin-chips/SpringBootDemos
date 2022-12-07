package com.dimple.codeencrypt.web.controller.vo.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserVOParams
 *
 * @author BianXiaofeng
 * @date 2022/11/17 10:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVOParams {

    private String userName;

    private String realName;

    private String password;

    private Integer gender;

    private String email;
}
