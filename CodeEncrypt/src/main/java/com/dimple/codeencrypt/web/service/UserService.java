package com.dimple.codeencrypt.web.service;

import com.dimple.codeencrypt.web.service.bo.UserBO;

import java.util.List;

/**
 * UserService
 *
 * @author BianXiaofeng
 * @date 2022/11/17 10:38
 */
public interface UserService {
    UserBO getUserBy(Long id);

    void saveUser(UserBO userBO);

    void updateUser(UserBO userBO);

    void deleteUser(Long id);

    List<UserBO> list();
}
