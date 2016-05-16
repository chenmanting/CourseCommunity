package com.cmt.pojo;

import java.util.HashSet;
import java.util.Set;

public class CourseMember {
	private int cid;//课程id
	private int sid;//学生id
	private String role;//学生或管理员
	
	
	public CourseMember() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getCid() {
		return cid;
	}


	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "CourseMember [cid=" + cid + ", sid=" + sid + ", role=" + role
				+ "]";
	}

	
}
