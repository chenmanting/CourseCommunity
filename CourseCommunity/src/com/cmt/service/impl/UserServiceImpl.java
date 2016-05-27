package com.cmt.service.impl;

import com.cmt.dao.UserDAO;
import com.cmt.dao.impl.UserDAOImpl;
import com.cmt.pojo.User;
import com.cmt.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDAO userDao;

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public boolean userLogin(User user) {
		User u = userDao.getUserByUsername(user.getUsername());
		if(u.getPassword().equals(user.getPassword())){
			return true;
		}
		return false;
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public boolean checkUsername(String username) {
		User u = userDao.getUserByUsername(username);
		if(u!=null) return true;
		return false;
	}

	@Override
	public User getUserByUsername(String username) {
		return userDao.getUserByUsername(username);
	}

	@Override
	public User getUser(int uid) {
		return userDao.getUser(uid);
	}

	@Override
	public void updateUserinfo(String username, User newUserinfo,String check) {
		StringBuilder sb = new StringBuilder(MyConstant.HIDE_ALL_USERINFO);
		if(check != null){
			String[] t = check.split(", ");
			for(int i=0; i<t.length; ++i){
				int pos = Integer.parseInt(t[i]);
				System.out.println("pos :" +pos);
				sb.setCharAt(pos, '1');
			}
			System.out.println(sb.toString());
			newUserinfo.setDisplay(sb.toString());
		}else{
			newUserinfo.setDisplay(MyConstant.HIDE_ALL_USERINFO);
		}
		User u =getUserByUsername(username);
		u.setName(newUserinfo.getName());
		u.setSex(newUserinfo.getSex());
		u.setNumber(newUserinfo.getNumber());
		u.setBirthday(newUserinfo.getBirthday());
		u.setLocation(newUserinfo.getLocation());
		u.setType(newUserinfo.getType());
		u.setEmail(newUserinfo.getEmail());
		u.setQq(newUserinfo.getQq());
		u.setTelphone(newUserinfo.getTelphone());
		u.setMobilephone(newUserinfo.getMobilephone());
		u.setCompany(newUserinfo.getCompany());
		u.setOccupation(newUserinfo.getOccupation());
		u.setIntroduction(newUserinfo.getIntroduction());
		updateUser(u);
	}

	
	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

}
