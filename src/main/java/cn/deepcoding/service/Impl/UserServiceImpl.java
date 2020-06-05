package cn.deepcoding.service.Impl;

import cn.deepcoding.dao.UserDao;
import cn.deepcoding.pojo.User;
import cn.deepcoding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by admin on 2020-06-05 02:25
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /*
           注册方法，无返回值
     */
    @Override
    public void register(User user) {
        user.setId(UUID.randomUUID().toString());
        userDao.save(user);
    }




    /*
         登录方法，返回User
     */
    @Override
    public User login(String username, String password) {
        return userDao.login(username, password);
    }
}
