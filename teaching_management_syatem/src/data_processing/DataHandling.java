/**   
 * Copyright © 2019 --. All rights reserved.
 * 
 * @Package: data_processing 
 * @author: --   
 * @date: 2019年11月20日 下午6:13:24 
 */
package data_processing;

import java.sql.*;
import user_information.User;

/** 
 * @ClassName: DataHandling 
 * @Description: 涉及数据库信息处理
 * @author: --
 * @date: 2019年11月20日 下午6:13:24  
 */
public class DataHandling {

	/** 
	 * @Title: Init 
	 * @Description: 初始化数据库连接驱动
	 * @throws ClassNotFoundException void 
	 * @author: --
	 * @date 2019年11月21日下午6:26:30 
	 */
	private static void Init() throws ClassNotFoundException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	/** 
	 * @Title: con 
	 * @Description: 连接数据库
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException Connection 
	 * @author: --
	 * @date 2019年11月21日下午6:27:06 
	 */
	private static Connection con() throws SQLException, ClassNotFoundException{
		Init();
		String url = "jdbc:mysql://localhost:3306/teaching_system11.21_1?characterEncoding=utf8&useSSL=false";//utf-8编码
		String user = "root";
		String password = "123456";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	/** 
	 * @Title: login 
	 * @Description: 登录用户时，在数据库中搜索相关信息是否正确，并创建User对象
	 * @param id
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException User 
	 * @author: --
	 * @date 2019年11月21日下午6:42:56 
	 */
	public static User login(String id,String password) throws ClassNotFoundException, SQLException{
		User user=null;
		Connection connection=con();
		Statement statement=connection.createStatement();
		String sql="select * from user where user_id='"+id+"'and user_password='"+password+"'";
		
		try {
			ResultSet resultSet=statement.executeQuery(sql);
			if(resultSet.next()) {
				user=new User(resultSet.getString(1), resultSet.getString(2), 
						resultSet.getString(3), resultSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		statement.close();
		connection.close();
				
		return user;
	}
	
	/** 
	 * @Title: modifyPassword 
	 * @Description: 修改密码
	 * @param id
	 * @param oldPassword
	 * @param newPassword
	 * @throws ClassNotFoundException
	 * @throws SQLException void 
	 * @author: --
	 * @date 2019年11月22日上午9:56:52 
	 */
	public static void modifyPassword(String id,String oldPassword,String newPassword) throws ClassNotFoundException, SQLException {
		Connection connection=con();
		Statement statement=connection.createStatement();
		String sql="select * from user where user_id='"+id+"'and user_password='"+oldPassword+"'";
		ResultSet resultSet=statement.executeQuery(sql);
		
		if(resultSet.next()) {
			resultSet.close();
			sql="update user set user_password='"+newPassword+"' where user_id='"+id+"'";
			statement.executeUpdate(sql);
			return;
		}
		
		statement.close();
		connection.close();
	}

	
	
}
