package com.ling.dao;

//操作实体类 dao <==> mapper



import com.ling.pojo.User;

import java.util.List;
import java.util.Map;

// mybatis 避免了几乎左右的JDBC代码和手动设置参数 衣机获取结果集
public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);


    List<User> getUserByLimit(Map<String, Integer> map);

}
