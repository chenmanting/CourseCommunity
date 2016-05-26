package com.cmt.dao.impl;


import java.sql.Blob;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.StyleSheet.ListPainter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cmt.dao.UserDAO;
import com.cmt.pojo.User;
import com.cmt.util.HibernateSessionFactory;

public class UserDAOImpl implements UserDAO {

	// 用户登录
	@Override
	public String queryPassword(User user) {

		String hql = "";
		
		try{
			
			Session session = HibernateSessionFactory.getSession();
			
			hql= "from User as user where user.username=:u";
			
			Query query = session.createQuery(hql);
			query.setString("u", user.getUsername());
			
			List list  = query.list();
			
//			System.out.println("list size: " + list.size()
//					+ " username : " + user.getUsername()
//					+" password: " +user.getPassword());
			
			if(list.size()>0){
				User u = (User) list.get(0);
				return u.getPassword();
			}else{
				System.out.println("没有查询到用户");
				return null;
			}
			
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally{
			
			
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
			transaction.rollback();
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
			if(list.size()>0){
				//System.out.println("list0  introduction: " + list.get(0).getIntroduction());
				return  list.get(0);
			}
			else return null;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	// 修改密码
	@Override
	public boolean updatePassword(User user,String password) {
		Transaction transaction = null;
		String hql ="";
		try{
			
			Session session = HibernateSessionFactory.getSession();
			transaction =session.beginTransaction();
			hql = "update User u set u.password=:p where u.username =:uname";
			Query query =session.createQuery(hql);
			query.setString("p", password);
			query.setString("uname", user.getUsername());
			int ret = query.executeUpdate();
			System.out.println("ret: " + ret);
			transaction.commit();
			if(ret > 0)
				return true;
			return false;
			
		}catch(Exception ex){
			transaction.rollback();
			ex.printStackTrace();
			return false;
		}finally{
			if(transaction != null)
				transaction =null;
			
		}
	}

	//修改用户信息
	@Override
	public boolean updateUserinfo(String username, User user) {
		
		Transaction transaction = null;
		String hql = "";
		try{
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			hql = "update User as u set u.name =:name,"
					+ " u.sex =:sex,"
					+ " u.number =:number,"
					+ " u.birthday =:birthday,"
					+ " u.location =:location,"
					+ " u.type =:type,"
					+ " u.email =:email,"
					+ " u.qq =:qq,"
					+ " u.telphone =:telphone,"
					+ " u.mobilephone =:mobilephone,"
					+ " u.company =:company,"
					+ " u.occupation =:occupation,"
					+ " u.introduction =:introduction,"
					+ " u.display =:display"
					+ " where u.username =:username";
			
			Query query  = session.createQuery(hql);
			query.setString("name", user.getName());
			query.setString("sex", user.getSex());
			query.setString("number", user.getNumber());
			query.setString("birthday", user.getBirthday());
			query.setString("location", user.getLocation());
			query.setString("type", user.getType());
			query.setString("email", user.getEmail());
			query.setString("qq", user.getQq());
			query.setString("telphone", user.getTelphone());
			query.setString("mobilephone", user.getMobilephone());
			query.setString("company", user.getCompany());
			query.setString("occupation", user.getOccupation());
			query.setString("introduction", user.getIntroduction());
			query.setString("display", user.getDisplay());
			query.setString("username", username);
			
			int ret = query.executeUpdate();
			
			transaction.commit();
			
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return false;
		}finally{
			
			if(transaction!=null)
				transaction = null;
		}
		
		return true;
	}

	@Override
	public boolean updateAvatar(String username, String avatar) {

		Transaction transaction = null;
		
		try{
			
			Session session = HibernateSessionFactory.getSession();
			transaction =session.beginTransaction();
			User user = getUserByUsername(username);
			user.setAvatar(avatar);
			session.update(user);
			transaction.commit();
			
		}catch(Exception e){
			transaction.rollback();
			e.printStackTrace();
			return false;
		}finally{
			if(transaction!=null){
				transaction=null;
			}
		}
		return true;
	}

	@Override
	public boolean updateUser(User user) {
		
		Transaction transaction = null;
		try{
			Session session = HibernateSessionFactory.getSession();
			transaction = session.beginTransaction();
			session.update(user);
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return false;
	}

	@Override
	public User getUser(int uid) {
		String hql ="from User as u where u.uid=:uid";
		Query query =HibernateSessionFactory.getSession().createQuery(hql);
		query.setInteger("uid", uid);
		User u = (User) query.list().get(0);
		return u;
	}

}
