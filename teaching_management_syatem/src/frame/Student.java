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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/** 
 * @ClassName: Student 
 * @Description: TODO
 * @author: --
 * @date: 2019年11月21日 上午8:38:19  
 */
public class Student extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student frame = new Student();
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
	public Student() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		labelId.setBounds(15, 73, 149, 21);
		contentPane.add(labelId);
		
		JLabel labelName = new JLabel("姓名：");
		labelName.setBounds(15, 159, 149, 21);
		contentPane.add(labelName);
		
		JButton btnLogout = new JButton("注销");
		btnLogout.setBorder(BorderFactory.createEtchedBorder());
		btnLogout.setBounds(512, 15, 54, 29);
		contentPane.add(btnLogout);
		
		JButton btnModifyPassword = new JButton("修改密码");
		btnModifyPassword.setBounds(15, 282, 105, 29);
		contentPane.add(btnModifyPassword);
		
		JButton btnSelectCourses = new JButton("选课");
		btnSelectCourses.setBounds(376, 129, 98, 29);
		contentPane.add(btnSelectCourses);
		
		JButton btnLookScores = new JButton("查看成绩");
		btnLookScores.setBorder(BorderFactory.createEtchedBorder());
		btnLookScores.setBounds(376, 222, 98, 29);
		contentPane.add(btnLookScores);
	}

}
