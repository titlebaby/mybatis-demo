package com.ling;

import com.ling.dao.UserDao;
import com.ling.pojo.User;
import com.ling.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

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
}
