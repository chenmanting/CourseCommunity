package com.cmt.service.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Test;









import com.cmt.dao.UserDAO;
import com.cmt.dao.impl.UserDAOImpl;
import com.cmt.pojo.User;
import com.cmt.util.HibernateSessionFactory;


public class TestUserDAOImpl {
	
	@Test
	public void testAddUser(){
		User user = new User();
		user.setName("cmt");
		user.setEmail("chinnmt@163.com");
		user.setUsername("chinn");
		user.setPassword("123");
		
		UserDAO udao  =  new UserDAOImpl();
		
		udao.addUser(user);
		
		//Assert.assertEquals(true,udao.addUser(user));
		
	}
	
	@Test
	public void testCheckUsername(){
//		String username = "chinn";
//		UserDAOImpl udao =  new UserDAOImpl();
//		if(udao.checkUsername(username)){
//			System.out.println("username is existed");
//		}else{
//			System.out.println("username is not existed");
//			
//		}
		
	}
	
	//测试登录
	@Test
	public void testUsersLogin(){
		User student = new User();
		student.setUsername("chinn");
		student.setPassword("123");
		UserDAOImpl udao = new UserDAOImpl();
		//udao.userLogin(student);
		//Assert.assertEquals(true,udao.userLogin(student));
	}
	
	//测试注册用例
	@Test
	public void testRegiste(){
		User user = new User();
		user.setName("cmt");
		user.setEmail("chinnmt@163.com");
		user.setUsername("cmt");
		user.setPassword("123");
		
		UserDAO udao  =  new UserDAOImpl();
		
		udao.addUser(user);
		
	}
	
	//测试根据用户名获取用户
	@Test
	public void testGetUserByUsername(){
		String username = "chinn";
		User user = new UserDAOImpl().getUserByUsername(username);
		System.out.println("name : " +user.getName());
	}
	
	// 测试更新密码
	@Test
	public void testUpdatePassword(){
//		User user1 =  new User();
//		String username = "chinn";
//		user1.setUsername(username);
//		UserDAO udao = new UserDAOImpl();
//		User user = udao.getUserByUsername(username);
//		udao.updatePassword(user1, "zzz");
	}
	
	@Test
	public void testEditUserinfo(){

		UserDAO udao = new UserDAOImpl();
		User user = new User();
		user.setUsername("test3");
		
		try {
			String p="d:/pic/head5.jpg";
			//p = (Blob) Hibernate.createBlob(is);
			user.setAvatar(p);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Transaction transaction = null;
		try{
			
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			
			if(transaction!=null)
				transaction = null;
		}
		
		
	}
	
}
