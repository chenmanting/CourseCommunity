package com.cmt.service;

import com.cmt.pojo.User;

public interface UserDAO {
	//登录
	public boolean userLogin(User user);
	//添加用户
	public boolean addUser(User user);
	//用户名是否存在
	public boolean checkUsername(String username);
	//根据用户名获取用户
	public User getUserByUsername(String username);
	//修改密码
	public boolean updatePassword(String username,String password);
}
