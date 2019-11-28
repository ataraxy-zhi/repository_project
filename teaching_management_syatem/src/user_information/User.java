/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: user_information 
 * @author: --   
 * @date: 2019年11月14日 下午6:39:45 
 */
package user_information;

/** 
 * @ClassName: User 
 * @Description: TODO
 * @author: --
 * @date: 2019年11月14日 下午6:39:45  
 */
public class User {
	
	private String userId;          //账号
	private String userName;        //用户名
	private String userPassword;    //密码
	private String userRole;        //身份
	
	
	/** 
	 * @Title:User
	 * @Description:
	 * @param userId
	 * @param userName
	 * @param userPassword
	 * @param userRole 
	 */  
	public User(String userId, String userName, String userPassword, String userRole) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userRole = userRole;
	}
	
	
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	/**
	 * @return the userRole
	 */
	public String getUserRole() {
		return userRole;
	}
	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	
	

}
