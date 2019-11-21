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
	
	private String name;
	private String id;
	private String password;
	private String role;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	

}
