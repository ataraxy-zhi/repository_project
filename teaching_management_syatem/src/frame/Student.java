/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: frame 
 * @author: --   
 * @date: 2019年11月21日 上午8:38:19 
 */
package frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import function_frame.ModifyPassword;
import user_information.User;

/** 
 * @ClassName: Student 
 * @Description: 学生主界面
 * @author: --
 * @date: 2019年11月21日 上午8:38:19  
 */
public class Student extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private JPanel contentPane;

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
					Student frame = new Student("030001","tom",new User("030001",
							"tom", "123456", "student"));
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
	public Student(String id,String name,User user) {
		this.user=user;
		setTitle(name+"学生，欢迎您！");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 652, 507);
			
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
		
		JLabel labelId = new JLabel("学号：");
		labelId.setBounds(15, 73, 183, 21);
		contentPane.add(labelId);
		labelId.setText("学号："+id);
		
		JLabel labelName = new JLabel("姓名：");
		labelName.setBounds(15, 159, 183, 21);
		contentPane.add(labelName);
		labelName.setText("姓名："+name);
		
		JButton btnLogout = new JButton("注销");
		btnLogout.setBorder(BorderFactory.createEtchedBorder());
		btnLogout.setBounds(512, 15, 54, 29);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogoutClicked(e);				
			}
		});
		
		JButton btnModifyPassword = new JButton("修改密码");
		btnModifyPassword.setBounds(15, 282, 105, 29);
		contentPane.add(btnModifyPassword);
		btnModifyPassword.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {	
				btnModifyPasswordClicked(e);
			}
		});
		
		JButton btnSelectCourses = new JButton("选课");
		btnSelectCourses.setBounds(376, 129, 98, 29);
		contentPane.add(btnSelectCourses);
		
		JButton btnLookScores = new JButton("查看成绩");
		btnLookScores.setBorder(BorderFactory.createEtchedBorder());
		btnLookScores.setBounds(376, 222, 98, 29);
		contentPane.add(btnLookScores);
	}
	
	
	/** 
	 * @Title: btnLogoutClicked 
	 * @Description: "注销"按钮点击事件处理
	 * @param event void 
	 * @author: --
	 * @date 2019年11月22日上午9:44:27 
	 */
	public void btnLogoutClicked(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "谢谢使用，再见", 
				"提示", JOptionPane.WARNING_MESSAGE);
		dispose();
	}
	
	
	/** 
	 * @Title: btnModifyPasswordClicked 
	 * @Description: 修改密码按钮事件处理
	 * @param event void 
	 * @author: --
	 * @date 2019年11月22日上午11:19:39 
	 */
	public void btnModifyPasswordClicked(ActionEvent event) {
		ModifyPassword frame = new ModifyPassword(user);
		frame.setVisible(true);
	}
	

}
