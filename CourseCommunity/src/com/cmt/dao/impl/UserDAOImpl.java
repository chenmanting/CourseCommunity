package com.cmt.dao.impl;


import java.sql.Blob;
import java.util.List;
import java.util.Set;

import javax.swing.text.html.StyleSheet.ListPainter;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cmt.dao.UserDAO;
import com.cmt.pojo.User;

public class UserDAOImpl implements UserDAO {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {   
        return sessionFactory.getCurrentSession();   
    }
	
	@Override
	public int addUser(User user) {
		return (int) getSession().save(user);
	}
	
	@Override
	public User getUserByUsername(String username) {
		Session session = getSession();
		String hql="from User as u where u.username=:u";
		Query query = session.createQuery(hql);
		query.setString("u", username);
		if(query.list().size()==0)
			return null;
		return (User) query.list().get(0);
	}
	@Override
	public User getUser(int uid) {
		Session session = getSession();
		User u = (User) session.get(User.class, uid);
		return u;
	}
	@Override
	public void updateUser(User user) {
		getSession().update(user);
	}

}
