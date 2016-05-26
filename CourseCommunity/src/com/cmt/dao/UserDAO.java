package com.cmt.dao;

import java.sql.Blob;
import java.util.*;

import com.cmt.pojo.User;

public interface UserDAO {
	//添加用户
	public int addUser(User user);
	//根据用户名获取用户
	public User getUserByUsername(String username);
	//根据uid获取user
	public User getUser(int uid);
	//更新用户
	public void updateUser(User user);
	
}
