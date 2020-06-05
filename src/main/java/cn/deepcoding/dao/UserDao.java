package cn.deepcoding.dao;

import cn.deepcoding.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by admin on 2020-06-05 02:11
 */
public interface UserDao {

    void save(User user);

    User login(@Param("username") String username,
               @Param("password") String password);

}
