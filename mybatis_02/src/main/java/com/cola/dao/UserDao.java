package com.cola.dao;

import com.cola.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    //查询全部用户
    List<User> getUserList();

    //根据id查询用户
    User getUserById(int id);

    //增加一个用户
    int addUser(User user);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);

}
