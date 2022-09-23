import com.ling.dao.UserMapper;
import com.ling.pojo.User;
import com.ling.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getUsers();
        for (User user : users) {
            System.out.println(user);
        }
        User user1 = userMapper.getUserById(1);
        System.out.println(user1);


        userMapper.addUser(new User(3,"zhangsan","1234444"));

        sqlSession.close();
    }
}
