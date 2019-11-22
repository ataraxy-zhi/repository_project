/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: frame 
 * @author: --   
 * @date: 2019年11月21日 上午8:35:41 
 */
package frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
 * @ClassName: Teacher 
 * @Description: 老师主界面
 * @author: --
 * @date: 2019年11月21日 上午8:35:41  
 */
public class Teacher extends JFrame {

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
					Teacher frame = new Teacher("020001","mike",new User("020001",
							"mike", "123456", "teacher"));
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
	public Teacher(String id,String name,User user) {
		this.user=user;
		setTitle(name+"老师，欢迎您！");
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
		labelId.setBounds(15, 76, 207, 21);
		contentPane.add(labelId);
		labelId.setText("工号："+id);
		
		JLabel labelName = new JLabel("姓名：");
		labelName.setBounds(15, 147, 207, 21);
		contentPane.add(labelName);
		labelName.setText("姓名："+name);
			
		JButton btnModifyPassword = new JButton("修改密码");
		btnModifyPassword.setBounds(15, 286, 111, 29);
		contentPane.add(btnModifyPassword);
		btnModifyPassword.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnModifyPasswordClicked(e);
			}
		});
		
		JButton btnGrading = new JButton("评定成绩");
		btnGrading.setBounds(419, 125, 111, 29);
		contentPane.add(btnGrading);
		
		JButton btnLogout = new JButton("注销");
		btnLogout.setBounds(553, 29, 81, 29);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogoutClicked(e);				
			}
		});
		
	}
	
	
	/** 
	 * @Title: btnLogoutClicked 
	 * @Description: "注销"按钮点击事件处理
	 * @param event void 
	 * @author: --
	 * @date 2019年11月22日上午9:45:27 
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
