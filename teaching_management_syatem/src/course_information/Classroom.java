/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: course_information 
 * @author: --   
 * @date: 2019年11月21日 下午5:56:14 
 */
package course_information;

/** 
 * @ClassName: Classroom 
 * @Description: 教室信息类
 * @author: --
 * @date: 2019年11月21日 下午5:56:14  
 */
public class Classroom {
	
	private String classroomId;         //教室号
	private String classroomName;       //教室名字
	private int classroomCompacity;     //教室容量
	
	/** 
	 * @Title:Classroom
	 * @Description: 
	 * @param classroomId
	 * @param classroomName
	 * @param classroomCompacity 
	 */  
	public Classroom(String classroomId, String classroomName, int classroomCompacity) {
		super();
		this.classroomId = classroomId;
		this.classroomName = classroomName;
		this.classroomCompacity = classroomCompacity;
	}
	
	
	/**
	 * @return the classroomId
	 */
	public String getClassroomId() {
		return classroomId;
	}
	/**
	 * @param classroomId the classroomId to set
	 */
	public void setClassroomId(String classroomId) {
		this.classroomId = classroomId;
	}
	/**
	 * @return the classroomName
	 */
	public String getClassroomName() {
		return classroomName;
	}
	/**
	 * @param classroomName the classroomName to set
	 */
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	/**
	 * @return the classroomCompacity
	 */
	public int getClassroomCompacity() {
		return classroomCompacity;
	}
	/**
	 * @param classroomCompacity the classroomCompacity to set
	 */
	public void setClassroomCompacity(int classroomCompacity) {
		this.classroomCompacity = classroomCompacity;
	}
	

}
