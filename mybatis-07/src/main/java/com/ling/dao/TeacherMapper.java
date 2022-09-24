package com.ling.dao;

import com.ling.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> getTeacherList() ;

    Teacher getStudentByTeacher(@Param("tid") int id);

    Teacher getStudentByTeacher2(@Param("tid") int id);
}
