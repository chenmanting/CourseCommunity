package com.cmt.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.LobHelper;
import org.hibernate.Session;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.cmt.dao.UserDAO;
import com.cmt.dao.impl.CourseDAOImpl;
import com.cmt.dao.impl.UserDAOImpl;
import com.cmt.pojo.Course;
import com.cmt.pojo.User;
import com.cmt.service.UserService;
import com.cmt.service.impl.UserServiceImpl;
import com.cmt.util.HibernateSessionFactory;
import com.cmt.util.UserPageUtil;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.prism.paint.Gradient;

/**
 * 处理用户业务
 * @author cmt
 */

public class UserAction extends SuperAction implements ModelDriven<User>{

	private static final long serialVersionUID = -7403651972056771426L;
	private static Logger logger = Logger.getLogger(UserAction.class);
	
	private User user = new User();
	private String txtOldPassword;
	private String txtNewPassword;
	
	private String check;//用户信息显示
	private String verify;//用户输入验证码
	private String cid;
	
	private File upload;
	private String uploadContentType;
	private String uploadFileName;
	
	private UserService uService = new UserServiceImpl();
	
	//用户登录动作
	public String login(){
		
		System.out.println("username :" +  user.getUsername());
		System.out.println("password :" +  user.getPassword());
		
		String c = (String) session.getAttribute("checkCode");
		System.out.println("checkcode: " + c
				+"  verify: " +verify);
		if(verify==null ||"".equals(verify)){
			logger.info("User "+ user.getUsername()
					+" login failed ：没有输入验证码");
			return "login_failure";
		}
		
		if(!verify.equals(c)){
			logger.info("User "+ user.getUsername()
					+" login failed ：验证码输入错误");
			return "login_failure";
		}
		user.setUsername(user.getUsername().trim());
		user.setPassword(user.getPassword().trim());
		if(uService.userLogin(user)){
			user = uService.getUserByUsername(user.getUsername());
			List<Course>myCourses =new CourseDAOImpl().queryMyCourses(user.getUid());
			session.setAttribute("myCourses", myCourses);
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
		user.setDisplay(MyConstant.HIDE_ALL_USERINFO);
		if(uService.addUser(user)){
			//user = udao.getUserByUsername(user.getUsername());
			session.setAttribute("user", user);
			session.setAttribute("myCourses", null);
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
			
			if(uService.checkUsername(username)){
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
			if(uService.updatePassword(user, txtNewPassword)){
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
	public void editUserinfo() throws IOException {
	
		System.out.println("display: " + check);
		
		String username = ((User) session.getAttribute("user")).getUsername();
		System.out.println("username : "+ username);
		String result="";
		if(uService.updateUserinfo(username, user,check)){
			session.setAttribute("user", uService.getUserByUsername(username));
			result = "<h2>用户信息更改成功</h2>";
		}else{
			result = "<h2>用户信息更改失败</h2>";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out;
		out = response.getWriter();
		out.write(result);
		
	}
	//更新头像
	public String updateAvatar() throws IOException{
		if(upload==null) return INPUT;
		System.out.println("收到文件了");
		String path ="/avatar"; 
		String spath =MyConstant.FILE_ROOT+path+"/";
		System.out.println(spath);
		File file = new File(spath);
		
		if(!file.exists()){
			file.mkdir();
		}
		User loginUser = (User) session.getAttribute("user");
		try {
			byte[] buffer = new byte[2048];
			InputStream is = new FileInputStream(upload);
			OutputStream os = new FileOutputStream(spath+uploadFileName);
			int count=0;
			while((count = is.read(buffer))>0){
				os.write(buffer,0,count);
			}
			is.close();
			os.close();
				
			uService.updateAvatar(loginUser.getUsername(), spath+uploadFileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		updateSessionUser(loginUser.getUsername());
		return "updateAvatarSuccess";
	}
	//获取头像
	public void getAvatar() throws IOException{
		response.setContentType("image/jpeg");
		user = (User) session.getAttribute("user");
		String file = user.getAvatar();
		if(file == null){
			file = MyConstant.FILE_ROOT+"/avatar/none.gif";
		}
		byte[] buffer = new byte[2048];
		InputStream is = new FileInputStream(file);
		OutputStream out = response.getOutputStream();
		int count=0;
		while((count = is.read(buffer))>0){
			out.write(buffer,0,count);
		}
		is.close();
		out.close();
	}
	
	//获取验证码
	public void getCheckCode() throws IOException{
		
		response.setContentType("image/jpeg");
		OutputStream os =response.getOutputStream();
		int width = 60;
		int height = 20;
		BufferedImage imgbuf = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = imgbuf.createGraphics();
		//g.setBackground(Color.WHITE);
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		String code ="";
		Random r =new Random();
		for(int i=0; i<4; ++i){
			String rand =String.valueOf(r.nextInt(10));
			code+=rand;
			g.setColor(new Color(20+r.nextInt(110), 20+r.nextInt(110),20+r.nextInt(110)));
			g.drawString(rand, 13*i+6, 16);
		}
		session.setAttribute("checkCode", code);
		System.out.println("随机数为："+ code);
		ImageIO.write(imgbuf, "JPEG", os);
		os.close();
	}
	
	// 注销
	public String logout() throws IOException{
		System.out.println("logout is invoke~");
		session.invalidate();
		return "logout";
	}
	//更新用户在session中的状态
	private void updateSessionUser(String username){
		user = uService.getUserByUsername(username);
		session.setAttribute("user", user);
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

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
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
