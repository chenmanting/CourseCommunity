package com.cmt.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.cmt.pojo.User;
import com.cmt.service.impl.CourseDAOImpl;
import com.cmt.util.UserPageUtil;

public class UserPageAction extends SuperAction{
	private String cid;
	private int pageNum;
	private static final int pageSize = 5;
	//获取某门课程的学生
	public String gotoUserList(){
		System.out.println("接收到的cid为  "+ cid);
		session.setAttribute("cid", cid);
		List<User> stus =null;
		stus = new CourseDAOImpl().queryStudents(Integer.parseInt(cid));
		System.out.println("有" +stus.size()+"个学生");
		if(stus.size()==0 || stus == null){
			session.setAttribute("students", null);
		}else{
			List<User> sublist= (new UserPageUtil(1,pageSize,stus)).getPage(1);
			session.setAttribute("students", sublist);
		}
		return "gotoUserList";
	}
	
	public void gotoPage() throws IOException{
		String result ="";
		if(pageNum<1){
			result="isFirst";
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.write(result);
			return ;
		}
		
		
		String cid = (String) session.getAttribute("cid");
		List<User> stus =null;
		stus = new CourseDAOImpl().queryStudents(Integer.parseInt(cid));
		System.out.println("有" +stus.size()+"个学生");
		
		
		int t = pageNum*pageSize -pageSize;
		if(t >= stus.size()){
			result="isLast";
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.write(result);
			return ;
		}
		
		UserPageUtil upu = new UserPageUtil(pageNum, pageSize, stus);
		if(stus.size()==0 || stus == null){ 
			session.setAttribute("students", null);
		}else{
			List<User> sublist= upu.getPage(pageNum);
			session.setAttribute("students", sublist);
		}
		
	}
	
	
	
	
	public String getCid() {
		return cid;
	}
	
	public void setCid(String cid) {
		this.cid = cid;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

}
