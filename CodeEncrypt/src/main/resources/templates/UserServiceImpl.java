package templates;

import com.dimple.codeencrypt.web.dao.UserDao;
import com.dimple.codeencrypt.web.dao.entity.User;
import com.dimple.codeencrypt.web.service.UserService;
import com.dimple.codeencrypt.web.service.bo.UserBO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * UserServiceImpl
 *
 * @author BianXiaofeng
 * @date 2022/11/17 10:39
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public UserBO getUserBy(Long id) {
        UserBO userBO = new UserBO();
        BeanUtils.copyProperties(userDao.getUserById(id), userBO);
        return userBO;
    }

    @Override
    public void saveUser(UserBO userBO) {
        User user = new User();
        BeanUtils.copyProperties(userBO, user);
        userDao.save(user);
    }

    @Override
    public void updateUser(UserBO userBO) {
        User user = new User();
        BeanUtils.copyProperties(userBO, user);
        userDao.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.delete(id);
    }

    @Override
    public List<UserBO> list() {
        return userDao.list().stream().map(e -> {
            UserBO userBO = new UserBO();
            BeanUtils.copyProperties(e, userBO);
            return userBO;
        }).collect(Collectors.toList());
    }
}
