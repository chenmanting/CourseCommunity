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
	private String titleSreach;//搜索课程的名字
	private String teacherSreach;//搜索课程的教师
	private String collegeSreach;//搜索课程的开课部门
	private String ruid;//教师移除学生的学生uid
	private String rcid;//教师移除学生的课程cid
	
	private CourseService courseService;
	
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	//开课
	public void addCourse(){
		
		System.out.println("课程标题： "+course.getTitle());
		User user = (User) session.getAttribute("user");
		
		try {
			String result =   courseService.addCourse(user, course);
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//加入课程
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
	//获取我的课程
	public String getMyCourses(){
		System.out.println("获取我的课程...");
		User user = (User) session.getAttribute("user");
		List<Course> courses = courseService.queryMyCourses(user.getUid());
		session.setAttribute("myCourses", courses);
		System.out.println("我有"+courses.size()+"门课");
		System.out.println("user course: " +  user.getCourses().size());
		
		return "gotoMyCourse";
	}
	//获取所有的课程
	public String getAllCourses(){
		System.out.println("获取所有课程...");
		List<Course> sCourses =courseService.queryAllCourses();
		session.setAttribute("sCourses", sCourses);
		//System.out.println("共找到" + allCourses.size()+"门课程");
		return "gotoCourseRearch";
	}
	//设置要编辑的课程
	public String getEditCourse(){
		int cid = Integer.parseInt(request.getParameter("id"));
		System.out.println("edit cid:" + cid);
		Course course = courseService.getCourse(cid);
		System.out.println("edit title " + course.getTitle());
		session.setAttribute("editCourse", course);
		return "gotoEditCourse";
	}
	//更新课程
	public void editCourse() throws IOException{
		Course t =  (Course) session.getAttribute("editCourse");
		System.out.println("更新课程id ： "+ t.getCid());
		
		String result=courseService.updateCourse(t.getCid(), course);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		out.write(result);
	}
	//删除课程
	public void deleteCourse() throws IOException{
		String result="";
		System.out.println("delcid :" + delCid);
		if(courseService.deleteCourse(Integer.parseInt(delCid))){
			User user = (User) session.getAttribute("user");
			List<Course> courses = courseService.queryMyCourses(user.getUid());
			session.setAttribute("myCourses", courses);
			result = "删除成功！";
		}else{
			result = "删除失败！";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		out.write(result);
	}
	//退出课程
	public void quitCourse() throws IOException{
		String result ="";
		System.out.println("quitCid " + quitCid);
		int qid = Integer.parseInt(quitCid);
		if(courseService.quitCourse(qid)){
			result = "退课成功！";
			User user = (User) session.getAttribute("user");
			List<Course> courses = courseService.queryMyCourses(user.getUid());
			session.setAttribute("myCourses", courses);
		}else{
			result = "退课失败！";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		out.write(result);
		
	}
	//根据课程名称， 授课教师，开课部门搜索课程
	public void searchCourse() throws IOException{
		System.out.println("title " +titleSreach);
		
		List<Course> searchCourse = courseService.searchCourse(titleSreach, teacherSreach, collegeSreach);
		session.setAttribute("sCourses", searchCourse);
		System.out.println("搜索到" + searchCourse.size()+"个课程");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		out.write("搜索成功！");
	}
	
	//获取我开设的课程
	public String getMyTeachCourse(){
		System.out.println("获取我开设的课程...");
		User u = (User) session.getAttribute("user");
		List<Course> myTeachCourse = courseService.queryMyTeachCourse(u.getUid());
		System.out.println("我共开设了" + myTeachCourse.size()+"门课");
		session.setAttribute("myTeachCourse", myTeachCourse);
		return "gotoUserListIndex";
	}
	//移除学生
	public void removeCourse() throws IOException{
		String result ="";
		
		System.out.println("ruid : " + ruid +"  rcid: " + rcid);
		if(courseService.removeCourse(Integer.parseInt(rcid), Integer.parseInt(ruid))){
			result = "移除成功！";
			getCourseUsers(Integer.parseInt(rcid));
		}else{
			result = "移除失败！";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		out.write(result);
	}
	
	public void getCourseUsers(int cid){
		List<User> stus =null;
		stus = new CourseDAOImpl().queryStudents(cid);
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
	

	public String getTitleSreach() {
		return titleSreach;
	}

	public void setTitleSreach(String titleSreach) {
		this.titleSreach = titleSreach;
	}

	public String getTeacherSreach() {
		return teacherSreach;
	}

	public void setTeacherSreach(String teacherSreach) {
		this.teacherSreach = teacherSreach;
	}

	public String getCollegeSreach() {
		return collegeSreach;
	}

	public void setCollegeSreach(String collegeSreach) {
		this.collegeSreach = collegeSreach;
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
