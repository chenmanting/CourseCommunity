package com.cmt.service.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cmt.factory.HibernateSessionFactory;
import com.cmt.pojo.User;
import com.cmt.service.UserDAO;

public class UserDAOImpl implements UserDAO {

	// 用户登录
	@Override
	public boolean userLogin(User user) {

		Transaction transaction = null;
		String sql = "";
		
		try{
			
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			
			sql= "select * from Users where username=? and password=? ";
			
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, user.getUsername());
			query.setParameter(1, user.getPassword());
			
			List list  = query.list();
			transaction.commit();
			
			if(list.size()>0){
				return true;
			}else{
				System.out.println("size  == 0");
				return false;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			
			if(transaction!=null){
				transaction=null;
			}
			
		}
	}

	//添加用户
	@Override
	public boolean addUser(User user) {
		
		Transaction transaction = null;
		
		try{
			
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			if(transaction!=null){
				transaction=null;
			}
		}
		return true;
	}

	// 检查用户名是否存在
	@Override
	public boolean checkUsername(String username) {

		try{
			
			Session session = HibernateSessionFactory.getSession();
			String hql = "from User as u where u.username=:n";
			Query query = session.createQuery(hql);
			query.setString("n", username);
			
			List<User> list = query.list();
			if(list.size()>0)
				return true;
			else return false;
			
		}catch(Exception e){
			e.printStackTrace();
		}
			
		return false;
	}

	//根据用户名获取用户
	@Override
	public User getUserByUsername(String username) {

		try{
			Session session = HibernateSessionFactory.getSession();
			String hql = "from User as u where u.username=:n";
			Query query = session.createQuery(hql);
			query.setString("n", username);
			
			List<User> list = query.list();
			if(list.size()>0)
				return  list.get(0);
			else return null;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	// 修改密码
	@Override
	public boolean updatePassword(String username,String password) {
		Transaction transaction = null;
		String hql ="";
		try{
			
			Session session = HibernateSessionFactory.getSession();
			transaction =session.beginTransaction();
			hql = "update User u set u.password=:p where u.username =:uname";
			Query query =session.createQuery(hql);
			query.setString("p", password);
			query.setString("uname", username);
			int ret = query.executeUpdate();
			System.out.println("ret: " + ret);
			transaction.commit();
			if(ret > 0)
				return true;
			return false;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
		}finally{
			if(transaction != null)
				transaction =null;
			
		}
	}
	
	

}
