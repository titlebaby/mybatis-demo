package com.ling;

import com.ling.dao.UserDao;
import com.ling.pojo.User;
import com.ling.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    @Test
    public void test(){
        // 1. 获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2. 执行sql(方式1)
        UserDao UserDaoMapper = sqlSession.getMapper(UserDao.class);
        List<User> userList = UserDaoMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);

        }
        sqlSession.close();

    }

    @Test
    public void getUserById(){
        // 1. 获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2. 执行sql(方式1)
        UserDao UserDaoMapper = sqlSession.getMapper(UserDao.class);
        User user = UserDaoMapper.getUserById(2);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void getUserById2(){
        // 1. 获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2. 执行sql(方式1)
        UserDao UserDaoMapper = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id",7);
        map.put("name","张三");
        User user = UserDaoMapper.getUserById2(map);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void addUser() {
        // 1. 获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2. 执行sql(方式1)
        UserDao UserDaoMapper = sqlSession.getMapper(UserDao.class);

        int res = UserDaoMapper.addUser(new User("hahah","123456"));
        if (res > 0) {
            System.out.println("成功");
        }

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void addUser2() {
        // 1. 获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2. 执行sql(方式1)
        UserDao UserDaoMapper = sqlSession.getMapper(UserDao.class);
        Map<String, Object> map = new HashMap<String, Object>();
      //  map.put("userid", 5);
        map.put("username", "张三");
        map.put("password", "123432");
        int res = UserDaoMapper.addUser2(map);
        if (res > 0) {
            System.out.println("成功");
        }

        sqlSession.commit();
        sqlSession.close();

    }


    @Test
    public void updateUser() {
        // 1. 获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2. 执行sql(方式1)
        UserDao UserDaoMapper = sqlSession.getMapper(UserDao.class);

        int res = UserDaoMapper.updateUser(new User(3,"hahahlal","123456"));
        if (res > 0) {
            System.out.println("成功");
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delUser() {
        // 1. 获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2. 执行sql(方式1)
        UserDao UserDaoMapper = sqlSession.getMapper(UserDao.class);

        int res = UserDaoMapper.delUser(3);
        if (res > 0) {
            System.out.println("成功");
        }
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testGetUserByLike() {
        // 1. 获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2. 执行sql(方式1)

        UserDao UserDaoMapper = sqlSession.getMapper(UserDao.class);

        List<User> userList = UserDaoMapper.getUserByLike("%三");
        for (User user : userList) {
            System.out.println(user);

        }
        sqlSession.close();

    }
}
