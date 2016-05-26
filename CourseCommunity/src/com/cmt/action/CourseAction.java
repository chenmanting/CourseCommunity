package com.cmt.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.cmt.dao.CourseDAO;
import com.cmt.dao.impl.CourseDAOImpl;
import com.cmt.dao.impl.UserDAOImpl;
import com.cmt.pojo.Course;
import com.cmt.pojo.User;
import com.cmt.service.CourseService;
import com.cmt.service.impl.CourseServiceImpl;
import com.opensymphony.xwork2.ModelDriven;

public class CourseAction extends SuperAction implements ModelDriven<Course>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2264290167199067241L;
	private static Logger logger = Logger.getLogger(CourseAction.class);
	
	private Course course = new Course();
	private String joinCourseId;//选课cid
	private String delCid;//删除课程的cid
	private String quitCid;//退出课程的cid
	
	private String ruid;//教师移除学生的学生uid
	private String rcid;//教师移除学生的课程cid
	
	private CourseService courseService;
	
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	/**
	 * 处理开课请求
	 */
	public void addCourse(){
		
		System.out.println("课程标题： "+course.getTitle());
		User user = (User) session.getAttribute("user");
		String result="";
		if(courseService.addCourse(user, course)){
			result = "<h2>开课成功！</h2>";
		}else{
			result = "<h2>开课失败！</h2>";
		}
		try{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 处理选课请求
	 * @throws IOException
	 */
	public void joinCourse() throws IOException{
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		
		System.out.println("加入课程...");
		System.out.println("joinCourseId" +joinCourseId);
		String result="";
		User user = (User) session.getAttribute("user");
		int jid =Integer.parseInt(joinCourseId);
		
		result =courseService.joinCourse(user, jid);
		
		out.write(result);
		
	}
	/**
	 * 获取我所有的开设以及加入课程
	 * @return
	 */
	public String getMyCourses(){
		System.out.println("获取我的课程...");
		User user = (User) session.getAttribute("user");
		List<Course> courses = courseService.queryMyCourses(user);
		session.setAttribute("myCourses", courses);
		System.out.println("我有"+courses.size()+"门课");
		System.out.println("user course: " +  user.getCourses().size());
		
		return "gotoMyCourse";
	}
	/**
	 * 获取所有开设的课程
	 * @return
	 */
	public String getAllCourses(){
		System.out.println("获取所有课程...");
		List<Course> sCourses =courseService.queryAllCourses();
		session.setAttribute("sCourses", sCourses);
		//System.out.println("共找到" + allCourses.size()+"门课程");
		return "gotoCourseRearch";
	}
	
	/**
	 * 设置要编辑的课程
	 * @return
	 */
	public String getEditCourse(){
		int cid = Integer.parseInt(request.getParameter("id"));
		System.out.println("edit cid:" + cid);
		Course course = courseService.getCourse(cid);
		System.out.println("edit title " + course.getTitle());
		session.setAttribute("editCourse", course);
		return "gotoEditCourse";
	}
	
	/**
	 * 更新课程
	 */
	public void editCourse() throws IOException{
		Course t =  (Course) session.getAttribute("editCourse");
		System.out.println("更新课程id ： "+ t.getCid());
		String result="";
		try{
			Course eCourse = courseService.getCourse(t.getCid());
			eCourse.setTitle(course.getTitle());
			eCourse.setClassType(course.getClassType());
			eCourse.setCollege(course.getCollege());
			eCourse.setKeyword(course.getKeyword());
			eCourse.setIsPublic(course.getIsPublic());
			eCourse.setIsCheck(course.getIsCheck());
			eCourse.setNotes(course.getNotes());
			eCourse.setBriefIntro(course.getBriefIntro());
			courseService.updateCourse(eCourse);
			result = "<h2>更新成功！</h2>";
		}catch(Exception e){
			result = "<h2>更新失败！</h2>";
			System.out.println("更新失败");
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		out.write(result);
	}
	
	/**
	 * 删除课程
	 * @throws IOException
	 */
	public void deleteCourse() throws IOException{
		String result="";
		System.out.println("delcid :" + delCid);
		Course course = courseService.getCourse(Integer.parseInt(delCid));
		try{
			courseService.deleteCourse(course);
			User user = (User) session.getAttribute("user");
			List<Course> courses = courseService.queryMyCourses(user);
			session.setAttribute("myCourses", courses);
			result = "删除成功！";
		}catch(Exception e){
			result = "删除失败！";
			e.printStackTrace();
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		out.write(result);
	}
	/**
	 * 退出课程
	 * @throws IOException
	 */
	public void quitCourse() throws IOException{
		String result ="";
		System.out.println("quitCid " + quitCid);
		int qid = Integer.parseInt(quitCid);
		Course course = courseService.getCourse(qid);
		if(courseService.quitCourse(course)){
			result = "退课成功！";
			User user = (User) session.getAttribute("user");
			List<Course> courses = courseService.queryMyCourses(user);
			session.setAttribute("myCourses", courses);
		}else{
			result = "退课失败！";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		out.write(result);
		
	}
	/**
	 * 根据课程名称， 授课教师，开课部门搜索课程
	 * @throws IOException
	 */
	public void searchCourse() throws IOException{
		System.out.println("title " +course.getTitle());
		//Course c = new Course();
//		c.setTitle(titleSreach);
//		c.setTeacher(teacherSreach);
//		c.setCollege(collegeSreach);
		List<Course> searchCourse = courseService.searchCourse(course);
		session.setAttribute("sCourses", searchCourse);
		System.out.println("搜索到" + searchCourse.size()+"个课程");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		out.write("搜索成功！");
	}
	
	/**
	 * 获取我开设的课程
	 * @return
	 */
	public String getMyTeachCourse(){
		System.out.println("获取我开设的课程...");
		User u = (User) session.getAttribute("user");
		List<Course> myTeachCourse = courseService.queryMyTeachCourse(u);
		System.out.println("我共开设了" + myTeachCourse.size()+"门课");
		session.setAttribute("myTeachCourse", myTeachCourse);
		return "gotoUserListIndex";
	}
	/**
	 * 移除学生
	 * @throws IOException
	 */
	public void removeCourse() throws IOException{
		String result ="";
		
		System.out.println("ruid : " + ruid +"  rcid: " + rcid);
		if(courseService.removeCourse(rcid, Integer.parseInt(ruid))){
			result = "移除成功！";
			Course course = courseService.getCourse(Integer.parseInt(rcid));
			getCourseUsers(course);
		}else{
			result = "移除失败！";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		out.write(result);
	}
	
	public void getCourseUsers(Course course){
		List<User> stus =null;
		stus = courseService.queryStudents(course);
		System.out.println("有" +stus.size()+"个学生");
		session.setAttribute("students", stus);
	}
	
	public String getJoinCourseId() {
		return joinCourseId;
	}

	public void setJoinCourseId(String joinCourseId) {
		this.joinCourseId = joinCourseId;
	}

	public String getDelCid() {
		return delCid;
	}

	public void setDelCid(String delCid) {
		this.delCid = delCid;
	}
	
	public String getQuitCid() {
		return quitCid;
	}

	public void setQuitCid(String quitCid) {
		this.quitCid = quitCid;
	}
	
	public String getRuid() {
		return ruid;
	}

	public void setRuid(String ruid) {
		this.ruid = ruid;
	}

	public String getRcid() {
		return rcid;
	}

	public void setRcid(String rcid) {
		this.rcid = rcid;
	}

	@Override
	public Course getModel() {
		return course;
	}

}
