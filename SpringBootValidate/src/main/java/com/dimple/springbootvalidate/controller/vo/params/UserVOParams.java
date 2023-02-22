package com.dimple.springbootvalidate.controller.vo.params;

import com.dimple.springbootvalidate.controller.customerValidate.annotation.InEnum;
import lombok.Data;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * UserVOParams
 *
 * @author BianXiaofeng
 * @date 2/22/2023 10:36 AM
 */
@Data
public class UserVOParams {

    @NotEmpty(message = "登录账号不能为空")
    @Length(min = 5, max = 16, message = "账号长度为 5-16 位")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "账号格式为数字以及字母")
    private String username;

    @NotEmpty(message = "密码不能为空")
    @Length(min = 4, max = 16, message = "密码长度为 4-16 位")
    private String password;


    @InEnum(value = GenderEnum.class, message = "性别必须是 {value}")
    private Integer gender;
}
