package com.ling.dao;

import com.ling.pojo.Blog;


import java.util.List;
import java.util.Map;

public interface BlogMapper {
     int  addBlog(Blog blog);

     List<Blog> queryBlogIf(Map map);
}
