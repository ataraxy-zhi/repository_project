/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: frame 
 * @author: --   
 * @date: 2019年11月21日 上午8:35:41 
 */
package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/** 
 * @ClassName: Teacher 
 * @Description: TODO
 * @author: --
 * @date: 2019年11月21日 上午8:35:41  
 */
public class Teacher extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher frame = new Teacher();
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
	public Teacher() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 684, 527);
		
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
		
		JLabel labelId = new JLabel("工号：");
		labelId.setBounds(15, 76, 81, 21);
		contentPane.add(labelId);
		
		JLabel labelName = new JLabel("姓名：");
		labelName.setBounds(15, 147, 81, 21);
		contentPane.add(labelName);
		
		JButton btnLogout = new JButton("注销");
		btnLogout.setBounds(537, 15, 81, 29);
		contentPane.add(btnLogout);
		
		JButton btnModifyPassword = new JButton("修改密码");
		btnModifyPassword.setBounds(15, 286, 111, 29);
		contentPane.add(btnModifyPassword);
		
		JButton btnGrading = new JButton("评定成绩");
		btnGrading.setBounds(419, 125, 111, 29);
		contentPane.add(btnGrading);
	}

}
