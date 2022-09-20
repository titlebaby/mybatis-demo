package com.ling.dao;

//操作实体类 dao <==> mapper

import com.ling.pojo.User;

import java.util.List;
import java.util.Map;

// mybatis 避免了几乎左右的JDBC代码和手动设置参数 衣机获取结果集
public interface UserDao {
    List<User> getUserList();

    User getUserById(int id);
    User getUserById2(Map<String, Object> map);

    //增删改需要提交事务
    int addUser(User user);
    // 假设，我们的实体类，或者数据库中的表，字段或者参数过多，我们应当考虑使用map（就不需要实体类）{这个是野路子}
    // map 传递参数，直接再sql中取出key即可 【parameterType="map"】
    // 对象传递参数，直接再sql中取对象的属性即可 【parameterType="com.ling.pojo.User"】
    // 只有一个基本类型参数的情况下，可以直接在sql中取到 【parameterType="int"】
    // 多个参数用 Map 或者注解
    int addUser2(Map<String, Object> map);

    int updateUser(User user);

    int delUser(int id);

    List<User> getUserByLike(String value);
}
