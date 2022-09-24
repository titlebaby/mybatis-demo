package com.ling.dao;

import com.ling.pojo.Blog;


import java.util.List;
import java.util.Map;

public interface BlogMapper {
     int  addBlog(Blog blog);

     List<Blog> queryBlogIf(Map map);

     List<Blog> queryBlogChoose(Map map);
     List<Blog> queryBlogChoose2(Map map);
     // if eles

     int updateBlog(Map map);
}
