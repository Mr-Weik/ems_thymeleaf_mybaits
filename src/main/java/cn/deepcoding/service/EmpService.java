package cn.deepcoding.service;

import cn.deepcoding.pojo.Emp;

import java.util.List;

/**
 * Created by admin on 2020-06-05 03:52
 */
public interface EmpService {

    void save(Emp emp);

    List<Emp> findAll();

    void delete(String id);

    Emp find(String id);

    void update(Emp emp);
}
