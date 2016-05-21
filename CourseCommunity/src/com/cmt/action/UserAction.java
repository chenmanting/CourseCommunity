package com.cmt.action;

import java.io.*;
import java.sql.Blob;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.LobHelper;
import org.hibernate.Session;

import com.cmt.factory.HibernateSessionFactory;
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
	public static final String FILE_ROOT="D:/temp/test";
	private static Logger logger = Logger.getLogger(UserAction.class);
	
	private User user = new User();
	private String txtOldPassword;
	private String txtNewPassword;
	
	private String check;
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	private UserDAO udao = new UserDAOImpl();
	
	private final static String HIDE_ALL_USERINFO="00000000000";
	
	//用户登录动作
	public String login(){
		
		System.out.println("username :" +  user.getUsername());
		System.out.println("password :" +  user.getPassword());
		
		if(udao.userLogin(user)){
			user = udao.getUserByUsername(user.getUsername());
			session.setAttribute("user", user);
			logger.info("User "+ user.getUsername()
					+" is logining");
			System.out.println("introduction： "+ user.getIntroduction());
			return "login_success";
		}else{
			logger.info("User "+ user.getUsername()
					+" login failed ： 密码错误");
			return "login_failure";
		}
	}
	
	//注册用户
	public String registe() throws IOException{
		user.setDisplay(HIDE_ALL_USERINFO);
		if(udao.addUser(user)){
			//user = udao.getUserByUsername(user.getUsername());
			session.setAttribute("user", user);
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
		//System.out.println("txtOld :"+ txtOldPassword);
		if(!txtOldPassword.equals(user.getPassword())){
			result = "oldPwdError";
		}else{
			if(udao.updatePassword(user, txtNewPassword)){
				result = "updatePwdSuccess";
				user.setPassword(txtNewPassword);
				session.setAttribute("user", user);
				logger.info("user "+user.getUsername()+" update password success");
			}else{
				result = "updatePwdFailure";
				logger.info("user "+user.getUsername()+" update password failed");
			}
		}
		
		try{
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out;
			out = response.getWriter();
			out.write(result);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	// 修改用户信息
	/**
	 * @return
	 * @throws IOException
	 */
	public String editUserinfo() throws IOException {
	
		System.out.println("display: " + check);
		if(user.getDisplay() == null || "".equals(user.getDisplay()))
			user.setDisplay(HIDE_ALL_USERINFO);
		StringBuilder sb = new StringBuilder(HIDE_ALL_USERINFO);
		String[] t = check.split(", ");
		for(int i=0; i<t.length; ++i){
			int pos = Integer.parseInt(t[i]);
			System.out.println("pos :" +pos);
			sb.setCharAt(pos, '1');
		}
		System.out.println(sb.toString());
		user.setDisplay(sb.toString());
		
		String username = ((User) session.getAttribute("user")).getUsername();
		System.out.println("username : "+ username);
		if(udao.updateUserinfo(username, user)){
			session.setAttribute("user", udao.getUserByUsername(username));
			return "editSuccess";
		}
		return "editFailure";
	}
	//更新头像
	public String updateAvatar() throws IOException{
		if(upload==null) return INPUT;
		System.out.println("收到文件了");
		//String 
		String path = ServletActionContext.getServletContext().getRealPath("/images");
		File file = new File(path);
		
		if(!file.exists()){
			file.mkdir();
		}
		FileUtils.copyFile(upload, new File(file, uploadFileName));
		Blob blob =null;
		User loginUser = (User) session.getAttribute("user");
		try {
			InputStream is = new FileInputStream(upload);
			Session session = HibernateSessionFactory.getSession();
			LobHelper lobHelper = session.getLobHelper();
			blob = lobHelper.createBlob(is, is.available());
			is.close();
			loginUser.setAvatar(blob);
			UserDAO udao = new UserDAOImpl();
			udao.updateAvatar(loginUser.getUsername(), blob);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.setAttribute("user", loginUser);
		return "updateAvatarSuccess";
	}
	
	// 注销
	public void logout() throws IOException{
		
		System.out.println("logout is invoke~");
		
		session.setAttribute("user", null);
		
		String path = request.getServletContext().getContextPath();
		System.out.println("path: " + path);
		
		response.sendRedirect(path+"/index.jsp");
		
	}
	
	
	public String getTxtOldPassword() {
		return txtOldPassword;
	}

	public void setTxtOldPassword(String txtOldPassword) {
		this.txtOldPassword = txtOldPassword;
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

	public String getCheck() {
		return check;
	}

	public void setCheck(String check) {
		this.check = check;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

}
