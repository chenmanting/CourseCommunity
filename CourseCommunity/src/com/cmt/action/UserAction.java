package com.cmt.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.cmt.pojo.User;
import com.cmt.service.UserDAO;
import com.cmt.service.impl.UserDAOImpl;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 处理用户业务
 * @author cmt
 */

public class UserAction extends SuperAction implements ModelDriven<User>{

	private static final long serialVersionUID = -7403651972056771426L;
	private static Logger logger = Logger.getLogger(UserAction.class);
	
	private User user = new User();
	private String txtNewPassword;
	
	
	private UserDAO udao = new UserDAOImpl();
	
	//用户登录动作
	public String login(){
		if(udao.userLogin(user)){
			user = udao.getUserByUsername(user.getUsername());
			session.setAttribute("user", user);
			logger.info("User "+ user.getUsername()
					+" is logining");
			return "login_success";
		}else{
			logger.info("User "+ user.getUsername()
					+" login failed");
			return "login_failure";
		}
	}
	
	//注册用户
	public String registe() throws IOException{
		
		if(udao.addUser(user)){
			logger.info("user " + user.getUsername()
					+" registe success");
			return "registe_success";
		}else{
			logger.info("user " + user.getUsername()
					+" registe failed");
			return "registe_failure";
		}
	}
	//判断用户名是否存在
	public void checkUsername(){
		
		String result="";
		
		try {
			String username = user.getUsername();
			String password = user.getPassword();
			
			if(udao.checkUsername(username)){
				System.out.println("该账户已存在");
				result = "true";
			}else{
				System.out.println("该账户未存在");
				result = "false";
			}
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.write(result);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 修改密码
	public void updatePassword(){
		User user = (User) session.getAttribute("user");
		String result="";
		try{
			if(udao.updatePassword(user.getUsername(), txtNewPassword)){
				result = "updatePwdSuccess";
				logger.info("user"+user.getUsername()+" update password success");
			}else{
				result = "updatePwdFailure";
				logger.info("user"+user.getUsername()+" update password failed");
			}
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.write(result);
			
		}catch(Exception ex){
			
			ex.printStackTrace();
		}
	}
	

	public String getTxtNewPassword() {
		return txtNewPassword;
	}

	public void setTxtNewPassword(String txtNewPassword) {
		this.txtNewPassword = txtNewPassword;
	}

	@Override
	public User getModel() {
		return this.user;
	}

}
