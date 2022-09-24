import com.ling.dao.BlogMapper;
import com.ling.pojo.Blog;
import com.ling.utils.IDutils;
import com.ling.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    @Test
    public void addTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("mybatis如此简单");
        blog.setAuthor("lll");
        blog.setCreateTime(new Date());
        blog.setViews(90);
       mapper.addBlog(blog);
        blog.setId(IDutils.getId());
        blog.setTitle("mybatis如此简单11");
        mapper.addBlog(blog);
        blog.setId(IDutils.getId());
        blog.setTitle("mybatis如此简单222");
        mapper.addBlog(blog);

        sqlSession.close();

    }
    @Test
    public void addTestQuery(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap<>();
        map.put("title","mybatis如此简单11");
        map.put("author","lll");
        List<Blog> blogs = mapper.queryBlogIf(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();

    }
}
