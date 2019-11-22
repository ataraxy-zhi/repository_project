/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: course_information 
 * @author: --   
 * @date: 2019年11月21日 下午5:54:10 
 */
package course_information;

/** 
 * @ClassName: College 
 * @Description: 学院信息类
 * @author: --
 * @date: 2019年11月21日 下午5:54:10  
 */
public class College {

	private String collegeId;      //学院号
	private String collegeName;    //学院名
	
	
	
	/** 
	 * @Title:College
	 * @Description:TODO 
	 * @param collegeId
	 * @param collegeName 
	 */  
	public College(String collegeId, String collegeName) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
	}
	
	
	/**
	 * @return the collegeId
	 */
	public String getCollegeId() {
		return collegeId;
	}
	/**
	 * @param collegeId the collegeId to set
	 */
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	/**
	 * @return the collegeName
	 */
	public String getCollegeName() {
		return collegeName;
	}
	/**
	 * @param collegeName the collegeName to set
	 */
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	
}
