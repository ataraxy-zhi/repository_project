/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: course_information 
 * @author: --   
 * @date: 2019年11月21日 下午4:56:38 
 */
package course_information;

/** 
 * @ClassName: Course 
 * @Description: 课程信息类
 * @author: --
 * @date: 2019年11月21日 下午4:56:38  
 */
public class Course {
	
	private String courseId;         //课程号
	private String courseName;       //课程名
	private String courseCredit;     //学分
	private String courseCollege;    //开设学院
	
	
	
	/** 
	 * @Title:Course
	 * @Description:TODO 
	 * @param courseId
	 * @param courseName
	 * @param courseCredit
	 * @param courseCollege 
	 */  
	public Course(String courseId, String courseName, String courseCredit, String courseCollege) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCredit = courseCredit;
		this.courseCollege = courseCollege;
	}
	
	
	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	/**
	 * @return the courseCredit
	 */
	public String getCourseCredit() {
		return courseCredit;
	}
	/**
	 * @param courseCredit the courseCredit to set
	 */
	public void setCourseCredit(String courseCredit) {
		this.courseCredit = courseCredit;
	}
	/**
	 * @return the courseCollege
	 */
	public String getCourseCollege() {
		return courseCollege;
	}
	/**
	 * @param courseCollege the courseCollege to set
	 */
	public void setCourseCollege(String courseCollege) {
		this.courseCollege = courseCollege;
	}
	
	

}
