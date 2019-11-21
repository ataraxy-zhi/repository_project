/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: frame 
 * @author: --   
 * @date: 2019年11月21日 上午8:33:27 
 */
package frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
/** 
 * @ClassName: Administrator 
 * @Description: TODO
 * @author: --
 * @date: 2019年11月21日 上午8:33:27  
 */
public class Administrator extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator frame = new Administrator();
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
	public Administrator() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 690, 505);
		
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
		
		JButton btnLogout = new JButton("注销");
		btnLogout.setFocusPainted(false);   //设置不绘制焦点,这样文字就不会有小框了
		btnLogout.setBorderPainted(false);  //设置不显示边框
		btnLogout.setBounds(570, 15, 83, 29);
		contentPane.add(btnLogout);
		
		JLabel labelId = new JLabel("工号：");
		labelId.setBounds(15, 85, 188, 21);
		contentPane.add(labelId);
		
		JLabel labelName = new JLabel("姓名：");
		labelName.setBounds(15, 134, 188, 21);
		contentPane.add(labelName);
		
		JButton btnModifyPassword = new JButton("修改密码");
		btnModifyPassword.setBounds(34, 279, 110, 29);
		contentPane.add(btnModifyPassword);
		
		JButton btnManageUsers = new JButton("管理用户");
		btnManageUsers.setBounds(461, 97, 105, 29);
		contentPane.add(btnManageUsers);
		
		JButton btnManageCourse = new JButton("管理课程");
		btnManageCourse.setBounds(461, 174, 105, 29);
		contentPane.add(btnManageCourse);
		
		JButton btnOfferCourses = new JButton("开课");
		btnOfferCourses.setBounds(461, 254, 105, 29);
		contentPane.add(btnOfferCourses);
	}

}
