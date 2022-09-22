package ling;

import com.ling.dao.UserMapper;
import com.ling.pojo.User;
import com.ling.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
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
    public void addUser() {
        // 1. 获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //2. 执行sql(方式1)
        UserMapper UserDaoMapper = sqlSession.getMapper(UserMapper.class);

        int res = UserDaoMapper.addUser(new User(3,"hahah","123456"));
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
        UserMapper UserDaoMapper = sqlSession.getMapper(UserMapper.class);

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
        UserMapper UserDaoMapper = sqlSession.getMapper(UserMapper.class);

        int res = UserDaoMapper.delUser(3);
        if (res > 0) {
            System.out.println("成功");
        }
        sqlSession.commit();
        sqlSession.close();

    }

}
