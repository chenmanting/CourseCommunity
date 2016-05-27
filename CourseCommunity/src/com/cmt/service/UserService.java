package com.cmt.service;

import com.cmt.pojo.User;

public interface UserService {
	//登录
	public boolean userLogin(User user);
	//添加用户
	public int addUser(User user);
	//用户名是否存在
	public boolean checkUsername(String username);
	//根据用户名获取用户
	public User getUserByUsername(String username);
	//根据uid获取user
	public User getUser(int uid);
	//编辑用户信息
	public void updateUserinfo(String username, User newUserinfo,String check);
	//更新用户
	public void updateUser(User user);
}
