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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import function_frame.ModifyPassword;
import user_information.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/** 
 * @ClassName: Administrator 
 * @Description: 管理员主界面
 * @author: --
 * @date: 2019年11月21日 上午8:33:27  
 */
public class Administrator extends JFrame {

	private static final long serialVersionUID = 1L;

	private User user;
	
	private JPanel contentPane;
	
	//private String id;
	//private String name;
	

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
					Administrator frame = new Administrator("010001","bob",new User("010001",
							"bob", "123", "administrator"));
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
	public Administrator(String id,String name,User user) {
		this.user=user;
		setTitle(name+"管理员，欢迎您！");
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
		//btnLogout.setFocusPainted(false);   //设置不绘制焦点,这样文字就不会有小框了
		//btnLogout.setBorderPainted(false);  //设置不显示边框
		btnLogout.setBounds(570, 15, 83, 29);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogoutClicked(e);
			}
		});
		
		JLabel labelId = new JLabel("工号：");
		labelId.setBounds(15, 85, 188, 21);
		contentPane.add(labelId);
		labelId.setText("工号："+id);
		
		JLabel labelName = new JLabel("姓名：");
		labelName.setBounds(15, 134, 188, 21);
		contentPane.add(labelName);
		labelName.setText("姓名："+name);
		
		JButton btnModifyPassword = new JButton("修改密码");
		btnModifyPassword.setBounds(34, 279, 110, 29);
		contentPane.add(btnModifyPassword);
		btnModifyPassword.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnModifyPasswordClicked(e);				
			}
		});
		
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
	
	/** 
	 * @Title: btnLogoutClicked 
	 * @Description: "注销"按钮点击事件处理
	 * @param event void 
	 * @author: --
	 * @date 2019年11月22日上午9:44:59 
	 */
	public void btnLogoutClicked(ActionEvent event) {
		JOptionPane.showMessageDialog(null, "谢谢使用，再见", 
				"提示", JOptionPane.WARNING_MESSAGE);
		dispose();
	}
	
	/** 
	 * @Title: btnModifyPasswordClicked 
	 * @Description: 修改密码按钮点击事件处理
	 * @param event void 
	 * @author: --
	 * @date 2019年11月22日上午11:20:43 
	 */
	public void btnModifyPasswordClicked(ActionEvent event) {
		ModifyPassword frame = new ModifyPassword(user);
		frame.setVisible(true);
	}
	

}
