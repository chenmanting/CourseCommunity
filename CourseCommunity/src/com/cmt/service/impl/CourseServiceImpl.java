package com.cmt.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.cmt.dao.CourseDAO;
import com.cmt.dao.UserDAO;
import com.cmt.dao.impl.CourseDAOImpl;
import com.cmt.dao.impl.UserDAOImpl;
import com.cmt.pojo.Course;
import com.cmt.pojo.User;
import com.cmt.service.CourseService;

public class CourseServiceImpl implements CourseService{

	private CourseDAO courseDao;

	public void setCourseDao(CourseDAO courseDao) {
		this.courseDao = courseDao;
	}
	
	/**
	 * 开设课程
	 * @param user 开课教师
	 * @param course 课程对象
	 * @return 是否开课成功
	 */
	@Override
	public boolean addCourse(User user,Course course) {
		course.setUser(user);
		course.setTeacher(user.getName());
		course.setTid(user.getUid());
		StringBuilder code= new StringBuilder(new Date().toString());
		code.append(user.getUsername());
		code.append(Math.random());
		System.out.println("code: "+  code);
		course.setCode(code.toString());
		String result="";
		course.setRole(MyConstant.UserType_Teacher);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		course.setBeginTime(sdf.format(new Date()));
		
		try{
			int id = courseDao.addCourse(course);
			if(id>0)
				return true;
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * 获取所有开设课程
	 * @return 所有开设课程
	 */
	@Override
	public List<Course> queryAllCourses() {
		return courseDao.queryAllCourses();
	}
	
	/**
	 * 获取我开设以及加入的课程
	 * @param user
	 * @return 课程列表
	 */
	@Override
	public List<Course> queryMyCourses(User user) {
		return courseDao.queryMyCourses(user);
	}
	
	/**
	 * 通过课程id获取课程
	 * @param cid
	 * @return 课程
	 */
	@Override
	public Course getCourse(int cid) {
		return courseDao.getCourse(cid);
	}
	
	/**
	 * 更新课程信息
	 * @param course
	 * @return
	 */
	@Override
	public void updateCourse(Course course) {
		courseDao.updateCourse(course);;
	}
	
	/**
	 * 删除课程
	 * @param cid
	 * @return
	 */
	@Override
	public int deleteCourse(Course course) {
		return courseDao.deleteCourse(course);
	}
	
	/**
	 * 选课
	 * @param user
	 * @param joinCourseId
	 * @return
	 */
	@Override
	public String joinCourse(User user, int joinCourseId) {
		Course c = getCourse(joinCourseId);
		String result="";
		List<Course> cc = queryMyCourses(user);
		boolean flag = true;
		
		for(int i=0; i<cc.size(); ++i){
			System.out.println(cc.get(i).getCid());
			if(cc.get(i).getCode().equals(joinCourseId+"")){
				flag = false;
				result = "你已经选过该课啦~";
				return result;
			}
		}
		Course join = new Course();
		join.setCode(c.getCid()+"");
		join.setTitle(c.getTitle());
		join.setClassType(c.getClassType());
		join.setCollege(c.getCollege());
		join.setTeacher(c.getTeacher());
		join.setTid(c.getTid());
		join.setKeyword(c.getKeyword());
		join.setBeginTime(c.getBeginTime());
		join.setEndTime(c.getEndTime());
		join.setRole("student");
		join.setUser(user);
		if(user ==null){
			return "选课失败！";
		}
		int id = courseDao.addCourse(join);
		System.out.println("添加课程id为： "  + id);
		c.setStudentNumber(c.getStudentNumber()+1);
		courseDao.updateCourse(c);
		result ="选课成功！";
		return result;
	}
	
	/**
	 * 退出课程
	 */
	@Override
	public boolean quitCourse(Course course) {
		try{
			String code = course.getCode();
			courseDao.quitCourse(course);
			Course c= courseDao.getCourse(Integer.parseInt(code));
			c.setStudentNumber(c.getStudentNumber()-1);
			courseDao.updateCourse(c);
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	/**
	 * 搜索课程
	 */
	@Override
	public List<Course> searchCourse(Course searchCourse) {
		return courseDao.searchCourse(searchCourse);
	}
	/**
	 * 获取我开设的课程
	 */
	@Override
	public List<Course> queryMyTeachCourse(User user) {
		return courseDao.queryMyCourses(user);
	}
	/**
	 * 查询我的学生
	 */
	@Override
	public List<User> queryStudents(Course course) {
		return courseDao.queryStudents(course);
	}
	@Override
	public boolean removeCourse(String code, int uid) {
		
		return courseDao.removeCourse(code, uid);
	}
	

//	@Override
//	public List<Course> queryAllCourses() {
//		return courseDao.queryAllCourses();
//	}
//
//	@Override
//	public List<Course> queryMyCourses(int uid) {
//		return courseDao.queryMyCourses(uid);
//	}
//
//	@Override
//	public Course getCourse(int cid) {
//		return courseDao.getCourse(cid);
//	}
//
//	@Override
//	public boolean updateCourse(int cid, Course course) {
//		String result ="";
//		courseDao.updateCourse(course)){
//			result = "<h2>课程成功更新！</h2>";
//		}else{
//			result = "<h2>课程更新失败！</h2>";
//		}
//		return result;
//	}
//
//	@Override
//	public boolean deleteCourse(int cid) {
//		return courseDao.deleteCourse(cid);
//	}
//
//	@Override
//	public String joinCourse(User user, int joinCourseId) {
//		
//		String result ="";
//		List<Course> cc = queryMyCourses(user.getUid());
//		boolean flag = true;
//		
//		Course course = getCourse(joinCourseId);
//		for(int i=0; i<cc.size(); ++i){
//			System.out.println(cc.get(i).getCid());
//			if(cc.get(i).getCode().equals(joinCourseId+"")){
//				flag = false;
//				result = "你已经选过该课啦~";
//				return result;
//			}
//		}
//		
//		Course c =getCourse(joinCourseId);
//		Course join = new Course();
//		join.setCode(c.getCid()+"");
//		join.setTitle(c.getTitle());
//		join.setClassType(c.getClassType());
//		join.setCollege(c.getCollege());
//		join.setTeacher(course.getTeacher());
//		join.setTid(c.getTid());
//		join.setKeyword(c.getKeyword());
//		join.setBeginTime(c.getBeginTime());
//		join.setEndTime(c.getEndTime());
//		join.setRole("student");
//		join.setUser(user);
//		
//		if(joinCourse(join,joinCourseId)){
//			result = "选课成功！";
//		}else{
//			result = "选课失败！";
//		}
//		return result;
//	}
//
//	@Override
//	public boolean quitCourse(int cid) {
//		return courseDao.quitCourse(cid);
//	}
//
//	@Override
//	public List<Course> searchCourse(String sName, String sTeacher,
//			String sCollege) {
//		return courseDao.searchCourse(sName, sTeacher, sCollege);
//	}
//
//	@Override
//	public List<Course> queryMyTeachCourse(int uid) {
//		return courseDao.queryMyTeachCourse(uid);
//	}
//
//	@Override
//	public List<User> queryStudents(int cid) {
//		return courseDao.queryStudents(cid);
//	}
//
//	@Override
//	public boolean removeCourse(int cid, int uid) {
//		return courseDao.removeCourse(cid, uid);
//	}

}
