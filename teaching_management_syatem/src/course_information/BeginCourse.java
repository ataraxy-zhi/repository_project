/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: course_information 
 * @author: --   
 * @date: 2019年11月21日 下午6:00:55 
 */
package course_information;

/**
 * @ClassName: BeginCourse
 * @Description: 开课信息类
 * @author: --
 * @date: 2019年11月21日 下午6:00:55
 */
public class BeginCourse {

	private String bcId;           //开课号
	private String bcCourse;       //开课课程号
	private String bcTeacher;      //授课老师工号
	private String bcClassroom;    //开课教室
	private String bcCapacity;     //开课容量
	private String bcBegintime;    //开始时间
	private String bcEndtime;      //结束时间
	private String bctime;         //上课时间
	
	/** 
	 * @Title:BeginCourse
	 * @Description:TODO 
	 * @param bcId
	 * @param bcCourse
	 * @param bcTeacher
	 * @param bcClassroom
	 * @param bcCapacity
	 * @param bcBegintime
	 * @param bcEndtime
	 * @param bctime 
	 */  
	public BeginCourse(String bcId, String bcCourse, String bcTeacher, String bcClassroom, String bcCapacity,
			String bcBegintime, String bcEndtime, String bctime) {
		super();
		this.bcId = bcId;
		this.bcCourse = bcCourse;
		this.bcTeacher = bcTeacher;
		this.bcClassroom = bcClassroom;
		this.bcCapacity = bcCapacity;
		this.bcBegintime = bcBegintime;
		this.bcEndtime = bcEndtime;
		this.bctime = bctime;
	}

	
	/**
	 * @return the bcId
	 */
	public String getBcId() {
		return bcId;
	}

	/**
	 * @param bcId the bcId to set
	 */
	public void setBcId(String bcId) {
		this.bcId = bcId;
	}

	/**
	 * @return the bcCourse
	 */
	public String getBcCourse() {
		return bcCourse;
	}

	/**
	 * @param bcCourse the bcCourse to set
	 */
	public void setBcCourse(String bcCourse) {
		this.bcCourse = bcCourse;
	}

	/**
	 * @return the bcTeacher
	 */
	public String getBcTeacher() {
		return bcTeacher;
	}

	/**
	 * @param bcTeacher the bcTeacher to set
	 */
	public void setBcTeacher(String bcTeacher) {
		this.bcTeacher = bcTeacher;
	}

	/**
	 * @return the bcClassroom
	 */
	public String getBcClassroom() {
		return bcClassroom;
	}

	/**
	 * @param bcClassroom the bcClassroom to set
	 */
	public void setBcClassroom(String bcClassroom) {
		this.bcClassroom = bcClassroom;
	}

	/**
	 * @return the bcCapacity
	 */
	public String getBcCapacity() {
		return bcCapacity;
	}

	/**
	 * @param bcCapacity the bcCapacity to set
	 */
	public void setBcCapacity(String bcCapacity) {
		this.bcCapacity = bcCapacity;
	}

	/**
	 * @return the bcBegintime
	 */
	public String getBcBegintime() {
		return bcBegintime;
	}

	/**
	 * @param bcBegintime the bcBegintime to set
	 */
	public void setBcBegintime(String bcBegintime) {
		this.bcBegintime = bcBegintime;
	}

	/**
	 * @return the bcEndtime
	 */
	public String getBcEndtime() {
		return bcEndtime;
	}

	/**
	 * @param bcEndtime the bcEndtime to set
	 */
	public void setBcEndtime(String bcEndtime) {
		this.bcEndtime = bcEndtime;
	}

	/**
	 * @return the bctime
	 */
	public String getBctime() {
		return bctime;
	}

	/**
	 * @param bctime the bctime to set
	 */
	public void setBctime(String bctime) {
		this.bctime = bctime;
	}

	

}
