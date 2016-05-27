package com.cmt.service;

import java.util.List;

import com.cmt.pojo.Course;
import com.cmt.pojo.User;

public interface CourseService {
	public boolean addCourse(User user,Course course);//开课
	public List<Course> queryAllCourses();//查询所有课程
	public List<Course> queryMyCourses(User user);//查询用户开设已经加入的课程
	public Course getCourse(int cid);//通过课程id获取课程
	public void updateCourse(Course course);//更新课程
	public int deleteCourse(Course course);//删除课程
	public String joinCourse(User user, int joinCourseId);//选课
	public boolean quitCourse(Course course);//退选课
	public List<Course> searchCourse(Course searchCourse); //查询课程
	public List<Course> queryMyTeachCourse(User user);//获取我开设的课程
	public List<User> queryStudents(Course course);//查询该门课的学生
	public boolean removeCourse(String code, int uid);//移除该门课的学生
}
