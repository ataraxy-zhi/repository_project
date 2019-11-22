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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import data_processing.DataHandling;
import user_information.User;

/** 
 * @ClassName: Login 
 * @Description: 登录界面
 * @author: --
 * @date: 2019年11月21日 上午8:17:20  
 */
public class Login extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public static User user;
	
	private String id;
	private String name;
	private String role;
		
	private JPanel contentPane;
	private JRadioButton rbtnAdmin;          //单选框-管理员
	private JRadioButton rbtnTeac;           //单选框-教师
	private JRadioButton rbtnStu;            //单选框-学生
	private JTextField tfAccount;            //输入框-账号
	private JPasswordField pfPassword;       //输入框-密码

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				//将swing控件风格类型改为win10
				try {
		            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
		                | UnsupportedLookAndFeelException e) {
		        	e.printStackTrace();
		        	}
				
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
		this.setTitle("欢迎使用学分制教学信息管理系统");
		this.setIconImage(new ImageIcon("main_icon.png").getImage());
		
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
		
		rbtnAdmin = new JRadioButton("管理员");
		rbtnAdmin.setBounds(141, 98, 94, 29);
		contentPane.add(rbtnAdmin);
		
		rbtnTeac = new JRadioButton("教师");
		rbtnTeac.setBounds(283, 98, 94, 29);
		contentPane.add(rbtnTeac);
		
		rbtnStu = new JRadioButton("学生");
		rbtnStu.setBounds(418, 98, 94, 29);
		contentPane.add(rbtnStu);
		
		//设定单选按钮集合
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtnAdmin);
		bg.add(rbtnTeac);
		bg.add(rbtnStu);
		rbtnStu.setSelected(true);//默认学生身份被选中
		
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
			public void actionPerformed(ActionEvent event) {
				btnLoginClicked(event);
			}
		});
		
		JButton btnLogout = new JButton("注销");
		btnLogout.setBounds(350, 336, 94, 29);
		contentPane.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLogoutClicked(e);
			}
		});
	}
	
		
	/** 
	 * @Title: btnLoginClicked 
	 * @Description: “登录按钮”点击事件处理
	 * @param event void 
	 * @author: --
	 * @date 2019年11月22日上午8:04:54 
	 */
	public void btnLoginClicked(ActionEvent event) {
		try {
			//获取账号和密码，对于密码要用String.valueOf(pfPassword.getPassword())获取
			id=tfAccount.getText();

			//System.out.println("密码为："+String.valueOf(pfPassword.getPassword()));
			//System.out.println("账号为："+id);
			
			//判断输入格式
			if(id.equals("") || String.valueOf(pfPassword.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(null, "账号或密码为空，请重新输入", 
						"提示", JOptionPane.WARNING_MESSAGE);
			}
			else {
				try {
					//根据账号和密码在数据库中搜索相关信息并创建User对象
					//User user=DataHandling.login(id, String.valueOf(pfPassword.getPassword()));
					user=DataHandling.login(id, String.valueOf(pfPassword.getPassword()));
					name=user.getUserName();
					
					if(rbtnAdmin.isSelected()) {
						role="administrator";
					}
					if(rbtnTeac.isSelected()) {
						role="teacher";
					}
					if(rbtnStu.isSelected()) {
						role="student";
					}
					
					if(user.getUserRole().equals(role)) {
						if(role.equals("administrator")) {
							Administrator administrator =new Administrator(id,name,user);
							administrator.setVisible(true);
						}
						else if(role.equals("teacher")) {
							Teacher teacher=new Teacher(id, name, user);
							teacher.setVisible(true);
						}
						else {
							Student student=new Student(id, name, user);
							student.setVisible(true);
						}
						
						JOptionPane.showMessageDialog(null, "登录成功！", 
								"提示", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "输入的账号与选择的身份不符，请重新输入账号或选择身份", 
								"提示", JOptionPane.WARNING_MESSAGE);
						pfPassword.setText("");
						rbtnStu.setSelected(true);
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "账号或密码输入错误，请重新输入",
							"错误", JOptionPane.ERROR_MESSAGE);					
					pfPassword.setText("");
				}
								
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * @Title: btnLogoutClicked 
	 * @Description: "注销"按钮点击事件处理
	 * @param event void 
	 * @author: --
	 * @date 2019年11月22日上午9:45:11 
	 */
	public void btnLogoutClicked(ActionEvent event) {
		tfAccount.setText("");
		pfPassword.setText("");
		JOptionPane.showMessageDialog(null, "谢谢使用，再见", 
				"提示", JOptionPane.WARNING_MESSAGE);
		System.exit(0);
	}
	

}
