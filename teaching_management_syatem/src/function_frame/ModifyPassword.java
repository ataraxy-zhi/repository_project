/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: function_frame 
 * @author: --   
 * @date: 2019年11月22日 上午10:01:51 
 */
package function_frame;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import data_processing.DataHandling;
import user_information.User;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;

/** 
 * @ClassName: ModifyPassword 
 * @Description: 修改密码界面
 * @author: --
 * @date: 2019年11月22日 上午10:01:51  
 */
public class ModifyPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	private JPanel contentPane;
	JLabel labelAccount;
	private JPasswordField pfOldPassword;
	private JPasswordField pfNewPassword1;
	private JPasswordField pfNewPassword2;
	private JButton btnConfirm;
	private JButton btnClear;

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
					ModifyPassword frame = new ModifyPassword(new User("010001",
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
	public ModifyPassword(User user) {
		this.user=user;
		setTitle("修改密码");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 656, 514);
		
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
		
		labelAccount = new JLabel("所要修改密码的账号为：");
		labelAccount.setBounds(88, 70, 377, 21);
		contentPane.add(labelAccount);
		labelAccount.setText("所要修改密码的账号为："+user.getUserId());
		
		JLabel labelOldPassword = new JLabel("请输入旧密码：");
		labelOldPassword.setBounds(88, 126, 126, 21);
		contentPane.add(labelOldPassword);
		
		pfOldPassword = new JPasswordField();
		pfOldPassword.setBounds(265, 123, 200, 27);
		contentPane.add(pfOldPassword);
		
		JLabel labelNewPassword1 = new JLabel("请输入新密码：");
		labelNewPassword1.setBounds(88, 186, 126, 21);
		contentPane.add(labelNewPassword1);
		
		pfNewPassword1 = new JPasswordField();
		pfNewPassword1.setBounds(265, 183, 200, 27);
		contentPane.add(pfNewPassword1);
		
		JLabel label = new JLabel("请再次输入新密码：");
		label.setBounds(88, 244, 162, 21);
		contentPane.add(label);
		
		pfNewPassword2 = new JPasswordField();
		pfNewPassword2.setBounds(265, 241, 200, 27);
		contentPane.add(pfNewPassword2);
		
		btnConfirm = new JButton("确认");
		btnConfirm.setBounds(58, 361, 69, 29);
		contentPane.add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnConfirmClicked(e);
			}
		});
		
		btnClear = new JButton("清空");
		btnClear.setBounds(432, 361, 69, 29);
		contentPane.add(btnClear);
		btnClear.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				clear();
				JOptionPane.showMessageDialog(null, "清空成功！", 
						"提示", JOptionPane.INFORMATION_MESSAGE);
			}
		});
	}
		
	/** 
	 * @Title: btnConfirmClicked 
	 * @Description: 修改密码确认事件处理
	 * @param event void 
	 * @author: --
	 * @date 2019年11月22日上午11:03:55 
	 */
	public void btnConfirmClicked(ActionEvent event) {
		String oldPassword=String.valueOf(pfOldPassword.getPassword());      //旧密码
		String newPassword1=String.valueOf(pfNewPassword1.getPassword());    //新密码
		String newPassword2=String.valueOf(pfNewPassword2.getPassword());    //再一次确认的新密码
		
		if(!oldPassword.equals(String.valueOf(user.getUserPassword()))) {
			JOptionPane.showMessageDialog(null, "输入旧密码不对，请重新输入！", 
					"错误", JOptionPane.ERROR_MESSAGE);
			clear();
			JOptionPane.showMessageDialog(null, "清空成功！", 
					"提示", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(oldPassword.equals("") || newPassword1.equals("") || newPassword2.equals("")) {
			JOptionPane.showMessageDialog(null, "输入密码不能为空，请重新输入！", 
					"提示", JOptionPane.WARNING_MESSAGE);
		}
		else if(oldPassword.contains(" ") || newPassword1.contains(" ") ||
				newPassword2.contains(" ")) {
			JOptionPane.showMessageDialog(null, "输入密码中不能包含空格，请重新输入！", 
					"提示", JOptionPane.WARNING_MESSAGE);
		}
		else if(!newPassword2.equals(newPassword1)) {
			JOptionPane.showMessageDialog(null, "两次输入的新密码不一样，请重新输入！", 
					"错误", JOptionPane.ERROR_MESSAGE);
			pfNewPassword1.setText("");
			pfNewPassword2.setText("");
		}
		else {
			try {
				DataHandling.modifyPassword(user.getUserId(), oldPassword, newPassword2);
				JOptionPane.showMessageDialog(null, "修改成功！", 
						"提示", JOptionPane.INFORMATION_MESSAGE);
				dispose();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "数据库信息错误！", 
						"错误", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	
	/** 
	 * @Title: clear 
	 * @Description: 清空输入框信息
	 * @author: --
	 * @date 2019年11月22日上午11:00:35 
	 */
	public void clear() {
		pfOldPassword.setText("");
		pfNewPassword1.setText("");
		pfNewPassword2.setText("");
	}
}
