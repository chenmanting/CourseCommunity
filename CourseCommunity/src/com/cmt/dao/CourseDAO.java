package com.cmt.dao;

import java.util.*;

import org.hibernate.Query;

import com.cmt.pojo.Course;
import com.cmt.pojo.User;

public interface CourseDAO {
	public int addCourse(Course course);//开课
	public List<Course> queryAllCourses();//查询所有课程
	public List<Course> queryMyCourses(User user);//通过用户id查询课程
	public Course getCourse(int cid);//通过课程id获取课程
	public void updateCourse(Course course);//更新课程
	public int deleteCourse(Course course);//删除课程
	public int quitCourse(Course course);//退选课
	public List<Course> searchCourse(Course searchModel); //查询课程
	public List<Course> queryMyTeachCourse(User user);//获取我开设的课程
	public List<User> queryStudents(Course course);
	public boolean removeCourse(String code, int uid);
}
