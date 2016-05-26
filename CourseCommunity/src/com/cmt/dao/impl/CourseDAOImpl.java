package com.cmt.dao.impl;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.cmt.dao.CourseDAO;
import com.cmt.pojo.Course;
import com.cmt.pojo.User;

public class CourseDAOImpl implements CourseDAO{
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {   
        return sessionFactory.getCurrentSession();   
    }
	/**
	 * 添加课程， 返回序列化对象
	 */
	@Override
	public int addCourse(Course course) {
		Session session = getSession();
		int id= (int) session.save(course);
		System.out.println("添加Course： "+  course.getTitle()+" " + course.getCode());
		return id;
	}
	/**
	 * 返回所有开设课程
	 */
	@Override
	public List<Course> queryAllCourses() {
		Session session =getSession();
		String hql ="from Course as c where c.role='teacher'";
		Query query  = session.createQuery(hql);
		List<Course> courses = query.list(); 
		return courses;
	}
	/**
	 * 返回我所有的开设以及加入的课程
	 */
	@Override
	public List<Course> queryMyCourses(User user) {
		Session session =getSession();
		String hql ="from Course as c where c.user.uid=:uid";
		Query query  = session.createQuery(hql);
		query.setInteger("uid", user.getUid());
		List<Course> courses = query.list(); 
		return courses;
	}
	
	/**
	 * 通过cid获取课程
	 */
	@Override
	public Course getCourse(int cid) {
		Session session =getSession();
		String hql = "from Course as c where c.cid=:cid";
		Query query = session.createQuery(hql);
		query.setInteger("cid", cid);
		return (Course) query.uniqueResult();
	}
	/**
	 * 更新课程信息
	 */
	@Override
	public void updateCourse(Course course) {
		Session session =getSession();
		session.update(course);
	}
	/**
	 * 删除开设的课程
	 */
	@Override
	public int deleteCourse(Course course) {
		Session session  = getSession();
		String hql = "delete Course as c where c.cid=:cid or c.code=:code";
		Query query = session.createQuery(hql);
		query.setInteger("cid", course.getCid());
		query.setString("code", course.getCid()+"");
		int ret = query.executeUpdate();
		return ret;
	}
	/**
	 * 退出选课
	 */
	@Override
	public int quitCourse(Course course) {
		Session session =getSession();
		String hql = "delete Course as c where c.cid=:cid";
		Query query = session.createQuery(hql);
		query.setInteger("cid", course.getCid());
		int ret = query.executeUpdate();
		return ret;
	}
	
	/**
	 * 根据课程名称、教师名字、开课分院搜索课程
	 */
	@Override
	public List<Course> searchCourse(Course searchModel) {
		Session session = getSession();
		
		StringBuilder hql =new StringBuilder("from Course as c where 1=1");
		 if(null !=searchModel.getTitle() && !"".equals(searchModel.getTitle())){  
	            hql.append(" and c.title like '%"+searchModel.getTitle()+"%'"); 
	     }
		 if(null !=searchModel.getTeacher() && !"".equals(searchModel.getTeacher())){  
	            hql.append(" and c.teacher like '%"+searchModel.getTeacher()+"%'"); 
	     }  
		 if(null !=searchModel.getCollege() && !"".equals(searchModel.getCollege())){  
	            hql.append(" and c.college like '%"+searchModel.getCollege()+"%'"); 
	     }
		 hql.append(" and c.role = 'teacher'");
		Query query = session.createQuery(hql.toString());
		return query.list();
		
	}
	
	/**
	 * 查询我开设的课程
	 */
	@Override
	public List<Course> queryMyTeachCourse(User user) {
		Session session = getSession();
		String hql ="from Course as c where c.uid=:uid"
				+ "	and c.role='teacher'";
		Query query = session.createQuery(hql);
		query.setInteger("uid", user.getUid());
		List<Course> courses = query.list();
		return courses;
	}
	
	@Override
	public List<User> queryStudents(Course course) {
		String hql ="select c.user from Course as c where c.code=:cid";
		Query query = getSession().createQuery(hql);
		query.setString("cid", course.getCid()+"");
		List<User> stuUids = query.list();
		return stuUids;
	}
	@Override
	public boolean removeCourse(String code, int uid) {
		Session session = getSession();
		String hql ="delete Course as c where c.code=:code and c.user.uid=:uid";
		Query query = session.createQuery(hql);
		query.setString("code", code);
		query.setInteger("uid", uid);
		int ret = query.executeUpdate();
		return ret>0;
	}
	
//	@Override
//	public boolean addCourse(Course course) {
//		
//		Transaction transaction = null;
//		try{
//			Session session = getSession();
//			transaction = session.beginTransaction();
//			session.save(course);
//			transaction.commit();
//		}catch(Exception e){
//			//transaction.rollback();
//			e.printStackTrace();
//			return false;
//		}finally{
//			transaction= null;
//		}
//		return true;
//	}
//
//	@Override
//	public List<Course> queryAllCourses() {
//		String hql = "from Course where role=:role";
//		List<Course> courses = null;
//		try{
//			Session session = getSession();
//			Query query = session.createQuery(hql);
//			query.setString("role", "teacher");
//			courses = query.list();
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		return courses;
//	}
//
//	@Override
//	public List<Course> queryMyCourses(int uid) {
//
//		String hql="from Course as c where c.user.uid =:id";
//		Session session = getSession();
//		Query query = session.createQuery(hql);
//		query.setInteger("id", uid);
//		System.out.println("you  " + query.list().size());
//		return (List<Course>)query.list();
//	}
//
//	@Override
//	public Course getCourse(int cid) {
//		List<Course> course = null;
//		String hql ="from Course where cid =:id";
//		Session session =getSession();
//		Query query = session.createQuery(hql);
//		query.setInteger("id", cid);
//		course = query.list();
//		return (course.size()>0)?course.get(0):null;
//	}
//
//	@Override
//	public boolean updateCourse(int cid, Course course) {
//		Transaction transaction = null;
//		String hql ="";
//		try{
//			Session session = getSession();
//			transaction = session.beginTransaction();
//			Course c = getCourse(cid);
//			c.setTitle(course.getTitle());
//			c.setClassType(course.getClassType());
//			c.setCollege(course.getCollege());
//			c.setKeyword(course.getKeyword());
//			c.setIsPublic(course.getIsPublic());
//			c.setIsCheck(course.getIsCheck());
//			c.setNotes(course.getNotes());
//			c.setBriefIntro(course.getBriefIntro());
//			session.save(c);
//			transaction.commit();
//		}catch(Exception e){
//			e.printStackTrace();
//			return false;
//		}finally{
//			
//			transaction = null;
//		}
//		return true;
//	}
//
//	@Override
//	public boolean deleteCourse(int cid) {
//
//		Transaction transaction = null;
//		String hql ="";
//		int ret=0;
//		try{
//			Course course = getCourse(cid);
//			String code = course.getCode();
//			Session session = getSession();
//			transaction = session.beginTransaction();
//			hql = "delete Course as c where c.code=:code";
//			Query query = session.createQuery(hql);
//			query.setString("code", code);
//			ret = query.executeUpdate();
//			transaction.commit();
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			return false;
//		}finally{
//			transaction = null;
//		}
//		
//		return ret>0;
//	}
//
//	@Override
//	public boolean joinCourse(Course join, int joinCid) {
//		
//		Transaction transaction = null;
//		Course course =getCourse(joinCid);
//		course.setStudentNumber(course.getStudentNumber()+1);
//		try{
//			Session session = getSession();
//			transaction = session.beginTransaction();
//			session.save(join);
//			session.update(course);
//			transaction.commit();
//		}catch(Exception e){
//			e.printStackTrace();
//			return false;
//		}finally{
//			transaction = null;
//		}
//		return true;
//	}
//
//	@Override
//	public boolean quitCourse(int cid) {
//		Transaction transaction = null;
//		String hql ="";
//		int ret=0;
//		Course course =getCourse(cid);
//		course.setStudentNumber(course.getStudentNumber()-1);
//		try{
//			Session session = getSession();
//			transaction=session.beginTransaction();
//			hql = "delete Course c where c.cid=:id";
//			Query query = session.createQuery(hql);
//			query.setInteger("id", cid);
//			ret = query.executeUpdate();
//			session.update(course);
//			transaction.commit();
//		}catch(Exception e){
//			e.printStackTrace();
//		}finally{
//			transaction = null;
//		}
//		return ret>0;
//	}
//
//	@Override
//	public List<Course> searchCourse(String sName, String sTeacher,
//			String sCollege) {
//		StringBuilder hql =new StringBuilder("from Course as c where 1=1");
//		 if(null !=sName && !"".equals(sName)){  
//	            hql.append(" and c.title like '%"+sName+"%'"); 
//	     }
//		 if(null !=sTeacher && !"".equals(sTeacher)){  
//	            hql.append(" and c.teacher like '%"+sTeacher+"%'"); 
//	     }  
//		 if(null !=sCollege && !"".equals(sCollege)){  
//	            hql.append(" and c.college like '%"+sCollege+"%'"); 
//	     }
//		 hql.append(" and c.role = 'teacher'");
//		Session session = getSession();
//		Query query = session.createQuery(hql.toString());
//		return query.list();
//	}
//
//	@Override
//	public List<Course> queryMyTeachCourse(int uid) {
//
//		String hql ="from Course as c where c.user.uid=:uid"
//				+ " and c.role='teacher'";
//		Session session = getSession();
//		Query query = session.createQuery(hql);
//		query.setInteger("uid", uid);
//		List<Course> courses = query.list();
//		return courses;
//	}
//
//	@Override
//	public List<User> queryStudents(int cid) {
//		String hql ="select c.user from Course as c where c.code=:cid";
//		Query query = getSession().createQuery(hql);
//		query.setString("cid", cid+"");
//		List<User> stuUids = query.list();
//		return stuUids;
//	}
//
//	
//	@Override
//	public boolean updateCourse(Course course) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	@Override
//	public boolean deleteCourse(Course course) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
