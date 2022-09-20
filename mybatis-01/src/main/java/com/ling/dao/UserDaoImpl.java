package com.ling.dao;

import com.ling.pojo.User;

import java.util.List;

//implements UserDao  这是jdbc的做法
public class UserDaoImpl implements UserDao{
    public List<User> getUserList(){
        //执行sql
        String sql = "select * from user";
        // 执行之后拿到结果集
        return  null;
    }
}
