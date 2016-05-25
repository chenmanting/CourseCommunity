package com.cmt.service;

import java.util.*;

import com.cmt.pojo.Course;
import com.cmt.pojo.User;

public interface CourseDAO {
	public boolean addCourse(Course course);//开课
	public List<Course> queryAllCourses();//查询所有课程
	public List<Course> queryMyCourses(int uid);//通过用户id查询课程
	public Course getCourse(int cid);//通过课程id获取课程
	public boolean updateCourse(int cid, Course course);//更新课程
	public boolean deleteCourse(int cid);//删除课程
	public boolean joinCourse(String username, int cid);//选课
	public boolean quitCourse(int cid);//退选课
	public List<Course> searchCourse(String sName, String sTeacher, String sCollege); //查询课程
	public List<Course> queryMyTeachCourse(int uid);//获取我开设的课程
	public List<User> queryStudents(int cid);//查询该门课的学生
	public boolean removeCourse(int cid, int uid);//移除该门课的学生
}
