package com.cmt.model;


import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.cmt.dao.CourseDAO;
import com.cmt.dao.impl.CourseDAOImpl;
import com.cmt.dao.impl.UserDAOImpl;
import com.cmt.pojo.Course;
import com.cmt.pojo.User;
import com.cmt.util.HibernateSessionFactory;

public class CourseTest {
	@Test
	public void addCourse(){
		Session session =HibernateSessionFactory.getSession();
		User user = new UserDAOImpl().getUserByUsername("cmt");
		
		Course ci = new Course();
		ci.setTitle("title1");
		
		Course c2 = new Course();
		c2.setTitle("kecheng2");
		user.getCourses().add(c2);
		
		Transaction transaction = session.beginTransaction();
		try{
			session.update(user);
			transaction.commit();
		}catch(Exception e){
			e.printStackTrace();
			transaction.rollback();
		}finally{
			transaction = null;
			
		}
		
	}
	@Test
	public void addCourse2(){
		Course course = new Course();
		course.setTitle("myTileledfs");
		User u = new UserDAOImpl().getUserByUsername("chinn");
		System.out.println("username: "+ u.getUsername());
		course.setUser(u);
		CourseDAO cdao =new CourseDAOImpl();
		if(cdao.addCourse(course)){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败！");
			
		}
	}
}
