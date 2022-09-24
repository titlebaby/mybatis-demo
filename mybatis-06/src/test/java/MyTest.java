import com.ling.dao.StudentMapper;
import com.ling.dao.TeacherMapper;
import com.ling.pojo.Student;
import com.ling.pojo.Teacher;
import com.ling.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    public static void main(String[] args) {
         SqlSession sqlSession = MybatisUtils.getSqlSession();
         TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
         Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void testStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper userMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = userMapper.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
    @Test
    public void testStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper userMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = userMapper.getStudents2();
        for (Student student : students) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
