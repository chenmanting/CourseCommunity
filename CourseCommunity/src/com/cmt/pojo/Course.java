package com.cmt.pojo;

import java.sql.Date;

/**
 * 开设课程信息的实体类 
 * @author cmt
 */


public class Course {

	private int cid;// 课程id
	private String code;//课程编号, role为学生时为加入课程的cid
	private String title;
	private String classType;//课程类型
	private String college;//开课部门
	private String teacher;//教师名字
	private int tid;//教师id
	private String keyword;//关键字
	private String isPublic;//是否公开
	private String isCheck;//是否审核
	private String notes;//课程备注
	private String briefIntro;//课程简介
	private String bulletin;//课程公告
	private String beginTime;//创建时间
	private String endTime;
	private String role;//用户类型
	private int studentNumber;//课程人数
	private User user;//用户
	
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}
	
	


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getClassType() {
		return classType;
	}


	public void setClassType(String classType) {
		this.classType = classType;
	}


	public String getCollege() {
		return college;
	}


	public void setCollege(String college) {
		this.college = college;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}


	public String getKeyword() {
		return keyword;
	}


	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	public String getIsPublic() {
		return isPublic;
	}


	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}


	public String getIsCheck() {
		return isCheck;
	}


	public void setIsCheck(String isCheck) {
		this.isCheck = isCheck;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getBriefIntro() {
		return briefIntro;
	}


	public void setBriefIntro(String briefIntro) {
		this.briefIntro = briefIntro;
	}


	public String getBulletin() {
		return bulletin;
	}


	public void setBulletin(String bulletin) {
		this.bulletin = bulletin;
	}


	public String getBeginTime() {
		return beginTime;
	}


	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}


	public String getEndTime() {
		return endTime;
	}


	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public int getStudentNumber() {
		return studentNumber;
	}


	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

}
