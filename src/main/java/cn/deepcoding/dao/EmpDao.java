package cn.deepcoding.dao;

import cn.deepcoding.pojo.Emp;

import java.util.List;

/**
 * Created by admin on 2020-06-05 03:50
 */
public interface EmpDao {


    //删除
    void delete(String id);

    //查询所有
    List<Emp> findAll();

    //保存人员
    void save(Emp emp);

    //查询单人
    Emp find(String id);

    //更新方法
    void update(Emp emp);
}
