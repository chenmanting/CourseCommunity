package com.cmt.pojo;

import java.sql.Date;

/**
 * 开设课程信息的实体类 
 * @author cmt
 */


public class CourseInfo {

	private int cid;// 课程id
	private int tid;// 授课教师的id
	private String title;
	private String college;//开课单位
	private int studentNumber;//课程人数
	private String classType;//课程类型
	private String briefIntro;//课程简介
	private String bulletin;//课程公告
	private String beginTime;
	private String endTime;
	
	public CourseInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
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

	@Override
	public String toString() {
		return "CourseInfo [cid=" + cid + ", tid=" + tid + ", title=" + title
				+ ", college=" + college + ", studentNumber=" + studentNumber
				+ ", classType=" + classType + ", briefIntro=" + briefIntro
				+ ", bulletin=" + bulletin + ", beginTime=" + beginTime
				+ ", endTime=" + endTime + "]";
	}

	
}
