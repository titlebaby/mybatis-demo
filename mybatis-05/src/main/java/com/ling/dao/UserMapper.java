package com.ling.dao;

//操作实体类 dao <==> mapper



import com.ling.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// mybatis 避免了几乎左右的JDBC代码和手动设置参数 衣机获取结果集
public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();

    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id2);

    @Insert("insert into user(id,name,pwd) values (#{id}, #{name}, #{pwd})")
    int addUser(User user);
}
