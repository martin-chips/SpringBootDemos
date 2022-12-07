package com.dimple.codeencrypt.web.dao;

import com.dimple.codeencrypt.web.dao.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;

/**
 * UserDao
 *
 * @author BianXiaofeng
 * @date 2022/11/17 14:10
 */
@Repository
public class UserDao {
    private static Map<Long, User> mockUserTable = new ConcurrentHashMap<>();
    private static LongAdder idGen = new LongAdder();

    public List<User> list() {
        Collection<User> users = mockUserTable.values();
        if (!CollectionUtils.isEmpty(users)) {
            return users.stream().collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public User getUserById(Long id) {
        User user = mockUserTable.get(id);
        Assert.notNull(user, "user is not found by id :" + id);
        return user;
    }

    public User save(User user) {
        if (Objects.nonNull(user.getId())) {
            return updateUser(user);
        }
        addUser(user);
        return user;
    }

    private void addUser(User user) {
        idGen.increment();
        user.setId(idGen.longValue());
        mockUserTable.put(user.getId(), user);
    }

    private User updateUser(User userParam) {
        User user = mockUserTable.get(userParam.getId());
        Assert.notNull(user, "update fail, cause user is not found by id :" + user.getId());
        mockUserTable.put(userParam.getId(), userParam);
        return user;
    }

    public boolean delete(Long id) {
        User user = mockUserTable.get(id);
        Assert.notNull(user, "delete fail,cause user is not found by id :" + id);
        mockUserTable.remove(id);
        return true;
    }
}
