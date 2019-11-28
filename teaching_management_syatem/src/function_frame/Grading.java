/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: function_frame 
 * @author: --   
 * @date: 2019年11月27日 下午6:40:27 
 */
package function_frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import data_processing.DataHandling;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

/** 
 * @ClassName: Grading 
 * @Description: 评分界面
 * @author: --
 * @date: 2019年11月27日 下午6:40:27  
 */

public class Grading extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private static String teacId;   //保存所要进行评分的教师工号
	private String courseId;  //保存在下拉选择框里面选择的课程号
	private String stuId;     //保存根据选择的课程号所选课的学生学号
	private double grade;     //保存学生成绩
	
	private JPanel contentPane;
	private static JComboBox<String> cbbSelectStudent;
	private static JComboBox<String> cbbSelectCourse;
	private JLabel labelScore;   
	private JTextField tfScore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				//将swing控件风格类型改为win10
				try {
		            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		        } catch (ClassNotFoundException | InstantiationException | 
		        		IllegalAccessException | UnsupportedLookAndFeelException e) {
		            e.printStackTrace();
		        }
				
				try {
					Grading frame = new Grading("020001");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Grading(String teacId) {
		Grading.teacId=teacId;
		setTitle("评定成绩");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 670, 489);
		
		//让窗口居中
		Toolkit toolkit = getToolkit();
		Dimension dimension = toolkit.getScreenSize();
		int screenHeight = dimension.height;
		int screenWidth = dimension.width;
		int fram_Height = this.getHeight();
		int fram_Width = this.getWidth();
		this.setLocation((screenWidth-fram_Width)/2,(screenHeight-fram_Height)/2 );
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelSelectCourse = new JLabel("请选择课程:");
		labelSelectCourse.setBounds(15, 50, 107, 21);
		contentPane.add(labelSelectCourse);
		
		cbbSelectCourse = new JComboBox<String>();
		try {
			setCbbSelectCourseOptions();    //初始化选项
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		cbbSelectCourse.setBounds(150, 47, 213, 27);
		contentPane.add(cbbSelectCourse);
		cbbSelectCourse.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				cbbSelectCourseItemChanged(e);   //获取所选择的课程的选课学生
				
				try {
					cbbSelectStudent.removeAllItems();
					setCbbSelectStudentOptions(courseId);  //初始化选项
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel labelSelectStudent = new JLabel("请选择学生：");
		labelSelectStudent.setBounds(15, 163, 120, 21);
		contentPane.add(labelSelectStudent);
				
		labelScore = new JLabel("所选择学生成绩为：");
		labelScore.setBounds(15, 283, 219, 21);
		contentPane.add(labelScore);
		
		cbbSelectStudent = new JComboBox<String>();
		cbbSelectStudent.addItem("选择学生");
		cbbSelectStudent.setSelectedIndex(0);
		cbbSelectStudent.setBounds(150, 160, 213, 27);
		contentPane.add(cbbSelectStudent);
		cbbSelectStudent.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				cbbSelectStudentItemChanged(e);	    //获取所选择学生成绩
				labelScore.setText("所选择学生成绩为："+grade);
			}
		});	
				
		JLabel labelGrading = new JLabel("请输入评定分数：");
		labelGrading.setBounds(463, 102, 144, 21);
		contentPane.add(labelGrading);
		
		tfScore = new JTextField();
		tfScore.setBounds(463, 160, 125, 27);
		contentPane.add(tfScore);
		tfScore.setColumns(10);
		
		JButton btnSave = new JButton("保存");
		btnSave.setBounds(463, 268, 87, 29);
		contentPane.add(btnSave);
		btnSave.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbbSelectCourse.getSelectedIndex()==0||cbbSelectStudent.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null, "请选择课程和学生", "提示", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				int flag=btnSaveClicked(e);   //点击保存按钮
				if (flag == 1) {
					JOptionPane.showMessageDialog(null, "输入含有字母或特殊字符，请重新输入", "提示", JOptionPane.ERROR_MESSAGE);
				} else if (flag == 2) {
					JOptionPane.showMessageDialog(null, "成绩超出范围，请重新输入", "提示", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "保存成功", "提示", JOptionPane.PLAIN_MESSAGE);
					double grade1 = 0;
					try {
						grade1 = DataHandling.getGrade(stuId,courseId);
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					labelScore.setText("所选择学生成绩为："+grade1);
				}
			}
		});
		
		JButton btnGoback = new JButton("返回");
		btnGoback.setBounds(553, 389, 87, 29);
		contentPane.add(btnGoback);
		btnGoback.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	

	
    /** 
     * @Title: setCbbSelectCourseOptions 
     * @Description: 设置（初始化“选择课程”下拉选择框的选项）
     * @throws ClassNotFoundException
     * @throws SQLException void 
     * @author: --
     * @date 2019年11月27日下午8:44:54 
     */
    private static void setCbbSelectCourseOptions() throws ClassNotFoundException, SQLException {
		
		cbbSelectCourse.addItem("选择课程");
		ArrayList<String> listCourses=DataHandling.getCourse(teacId);
		for(int i=0;i<listCourses.size();i++) {
			cbbSelectCourse.addItem(listCourses.get(i));
		}
		cbbSelectCourse.setSelectedIndex(0);
	}
    
    /** 
     * @Title: setCbbSelectStudentOptions 
     * @Description: 设置（初始化“选择学生”下拉选择框的选项）
     * @param courseId
     * @throws ClassNotFoundException
     * @throws SQLException void 
     * @author: --
     * @date 2019年11月28日下午1:59:19 
     */
    private static void setCbbSelectStudentOptions(String courseId) throws ClassNotFoundException, SQLException {	
		cbbSelectStudent.addItem("选择学生");
		ArrayList<String> listStudent=DataHandling.getStudent(courseId);
		for(int i=0;i<listStudent.size();i++) {
			cbbSelectStudent.addItem(listStudent.get(i));
		}
		cbbSelectStudent.setSelectedIndex(0);
	}
    
    /** 
     * @Title: cbbSelectCourseItemChanged 
     * @Description: “选择课程”下拉选择框选择选项事件处理
     * @param e void 
     * @author: --
     * @date 2019年11月28日下午2:04:28 
     */
    private void cbbSelectCourseItemChanged(ItemEvent e) {
    	if (e.getStateChange() == ItemEvent.SELECTED) {
    		if(cbbSelectCourse.getSelectedIndex()!=0) {
    			//注意课程下拉列表选项是课程号-课程名的组合形式
    			courseId=
    					e.getItem().toString().substring(0,(e.getItem().toString()).lastIndexOf("-"));
    		}
    	}
  	
    }
    
    
    /** 
     * @Title: cbbSelectStudentItemChanged 
     * @Description: “选择学生”下拉选择框选择选项事件处理 ，获取所选择学生的id
     * @param e void 
     * @author: --
     * @date 2019年11月28日下午3:15:55 
     */
    private void cbbSelectStudentItemChanged(ItemEvent e) {
    	if (e.getStateChange() == ItemEvent.SELECTED) {
    		if(cbbSelectStudent.getSelectedIndex()!=0) {
    			stuId=
    					e.getItem().toString().substring(0,(e.getItem().toString()).lastIndexOf("-"));
    			
    		}
    	}
    	
    	try {
			grade=DataHandling.getGrade(stuId,courseId);  //查询学生成绩
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
    }
    
    /** 
     * @Title: btnSaveClicked 
     * @Description: 保存按钮事件处理,将合法的输入成绩保存在相应的数据库中去
     * @param e
     * @return int 
     * @author: --
     * @date 2019年11月28日下午3:38:52 
     */
    private int btnSaveClicked(ActionEvent e) {
    	boolean isDigit = false;// 定义一个boolean值，用来表示是否包含数字
		boolean isLetter = false;// 定义一个boolean值，用来表示是否包含字母
		boolean isSpecialChar1 = false;
		
		String score=tfScore.getText().toString();
		
		for (int i = 0; i < score.length(); i++) { 
			if (Character.isDigit(score.charAt(i))) { 
				isDigit = true;
			}
			if (Character.isLetter(score.charAt(i))) {
				isLetter = true;
			}
			if (isSpecialChar(score)) {
				isSpecialChar1 = true;
			}
		}
		
		if (isLetter || isSpecialChar1) {
			return 1; // 1表示输入有字母或特殊字符
		} 
		else if (isDigit) {
			grade=Double.parseDouble(tfScore.getText().toString());
			if (grade < 0 || grade > 100) {
				return 2; // 2表示输入超出范围
			} 
			else {
				try {
					DataHandling.updateGrade(stuId, courseId, grade);   //更新成绩
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				return 3; // 3表示正常
			}
		}
		return 0;
    }
    
    /** 
     * @Title: isSpecialChar 
     * @Description: 判断所给字符是否是特殊字符（不包括英文句号）
     * @param str
     * @return boolean 
     * @author: --
     * @date 2019年11月28日下午2:37:50 
     */
    public static boolean isSpecialChar(String str) {
		String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\]<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.find();
	}   
    
    
    
//	/** 
//	 * @Title: setCbbSelectCourseOptions 
//	 * @Description: 设置（初始化“选择课程”下拉选择框的选项）
//	 * @throws ClassNotFoundException
//	 * @throws SQLException void 
//	 * @author: --
//	 * @date 2019年11月27日下午8:13:14 
//	 */
//	public static void setCbbSelectCourseOptions() throws ClassNotFoundException, SQLException {
//		
//		cbbSelectCourse.addItem("选择课程");
//		String[] courses=DataHandling.getCourse(teacId);
//		for(int i=0;i<courses.length;i++) {
//			cbbSelectCourse.addItem(courses[i]);
//		}
//		cbbSelectCourse.setSelectedIndex(0);
//	}
    
    
}
