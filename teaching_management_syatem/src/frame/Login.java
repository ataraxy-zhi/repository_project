/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: frame 
 * @author: --   
 * @date: 2019年11月21日 上午8:17:20 
 */
package frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/** 
 * @ClassName: Login 
 * @Description: TODO
 * @author: --
 * @date: 2019年11月21日 上午8:17:20  
 */
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfAccount;
	private JPasswordField pfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 471);
		
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
		
		JLabel labelSystemName = new JLabel("学分制教学信息管理系统");
		labelSystemName.setBounds(188, 32, 215, 21);
		contentPane.add(labelSystemName);
		
		JLabel labelIdentity = new JLabel("请选择身份");
		labelIdentity.setBounds(15, 102, 94, 21);
		contentPane.add(labelIdentity);
		
		JRadioButton rbtnAdmin = new JRadioButton("管理员");
		rbtnAdmin.setBounds(141, 98, 94, 29);
		contentPane.add(rbtnAdmin);
		
		JRadioButton rbtnTeac = new JRadioButton("教师");
		rbtnTeac.setBounds(283, 98, 94, 29);
		contentPane.add(rbtnTeac);
		
		JRadioButton rbtnStu = new JRadioButton("学生");
		rbtnStu.setBounds(418, 98, 94, 29);
		contentPane.add(rbtnStu);
		
		//设定单选按钮集合
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtnAdmin);
		bg.add(rbtnTeac);
		bg.add(rbtnStu);
		rbtnStu.setSelected(true);
		
		JLabel labelAccount = new JLabel("账号");
		labelAccount.setBounds(15, 179, 56, 21);
		contentPane.add(labelAccount);
		
		tfAccount = new JTextField();
		tfAccount.setBounds(139, 176, 305, 27);
		contentPane.add(tfAccount);
		tfAccount.setColumns(10);
		
		JLabel labelPassword = new JLabel("密码");
		labelPassword.setBounds(15, 252, 56, 21);
		contentPane.add(labelPassword);
		
		pfPassword = new JPasswordField();
		pfPassword.setBounds(141, 249, 303, 27);
		contentPane.add(pfPassword);
		
		JButton btnLogin = new JButton("登录");
		btnLogin.setBounds(62, 336, 79, 29);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton btnLogout = new JButton("注销");
		btnLogout.setBounds(350, 336, 94, 29);
		contentPane.add(btnLogout);
	}
	
	
	
	
	
	/** 
	 * @Title: isSpecialChar 
	 * @Description: 判断一个字符串是否含有特殊字符 
	 * @param str
	 * @return boolean 
	 * @author: --
	 * @date 2019年11月21日上午9:27:47 
	 */
	public static boolean isSpecialChar(String str) {
		String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.find();
	}

}
