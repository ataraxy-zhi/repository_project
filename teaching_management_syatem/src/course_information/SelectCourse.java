/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: course_information 
 * @author: --   
 * @date: 2019年11月21日 下午6:14:27 
 */
package course_information;

/** 
 * @ClassName: SelectCourse 
 * @Description: 选课信息类
 * @author: --
 * @date: 2019年11月21日 下午6:14:27  
 */
public class SelectCourse {

	private String scId;         //选课号
	private String scCourse;     //选课课程号
	private String scStudent;    //选课学生学号
	private String scterm;       //选课学期
	private float scGrade;       //成绩
	
	/** 
	 * @Title:SelectCourse
	 * @Description:TODO 
	 * @param scId
	 * @param scCourse
	 * @param scStudent
	 * @param scterm
	 * @param scGrade 
	 */  
	public SelectCourse(String scId, String scCourse, String scStudent, String scterm, float scGrade) {
		super();
		this.scId = scId;
		this.scCourse = scCourse;
		this.scStudent = scStudent;
		this.scterm = scterm;
		this.scGrade = scGrade;
	}

	
	
	/**
	 * @return the scId
	 */
	public String getScId() {
		return scId;
	}

	/**
	 * @param scId the scId to set
	 */
	public void setScId(String scId) {
		this.scId = scId;
	}

	/**
	 * @return the scCourse
	 */
	public String getScCourse() {
		return scCourse;
	}

	/**
	 * @param scCourse the scCourse to set
	 */
	public void setScCourse(String scCourse) {
		this.scCourse = scCourse;
	}

	/**
	 * @return the scStudent
	 */
	public String getScStudent() {
		return scStudent;
	}

	/**
	 * @param scStudent the scStudent to set
	 */
	public void setScStudent(String scStudent) {
		this.scStudent = scStudent;
	}

	/**
	 * @return the scterm
	 */
	public String getScterm() {
		return scterm;
	}

	/**
	 * @param scterm the scterm to set
	 */
	public void setScterm(String scterm) {
		this.scterm = scterm;
	}

	/**
	 * @return the scGrade
	 */
	public float getScGrade() {
		return scGrade;
	}

	/**
	 * @param scGrade the scGrade to set
	 */
	public void setScGrade(float scGrade) {
		this.scGrade = scGrade;
	}
	
	
}
