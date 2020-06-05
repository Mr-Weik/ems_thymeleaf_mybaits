package cn.deepcoding.service;

import cn.deepcoding.pojo.User;

/**
 * Created by admin on 2020-06-05 02:24
 */
public interface UserService {


    void register(User user);

    User login(String username,String password);
}
