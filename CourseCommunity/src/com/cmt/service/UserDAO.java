package com.cmt.service;

import java.sql.Blob;

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
	public boolean updatePassword(User user,String password);
	//修改用户信息
	public boolean updateUserinfo(String username, User newUserinfo);
	//修改头像
	public boolean updateAvatar(String username, Blob avatar);
	
}
