package ling;

import com.ling.dao.UserMapper;
import com.ling.pojo.User;
import com.ling.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void test(){
        // 1. 获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2. 执行sql(方式1)
        UserMapper UserDaoMapper = sqlSession.getMapper(UserMapper.class);
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
        UserMapper UserDaoMapper = sqlSession.getMapper(UserMapper.class);
        User user = UserDaoMapper.getUserById(2);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    public void testLog4j(){
        logger.info("info");
        logger.debug("debug");
        logger.error("error");
    }

    @Test
    public void getUserByLimit(){
        // 1. 获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2. 执行sql(方式1)
        UserMapper UserDaoMapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",2);
        map.put("pageSize",2);
        List<User> userList = UserDaoMapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);

        }
        sqlSession.close();
                
               
    }
}
