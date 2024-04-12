package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;

public class TeacherDAO { // DAOクラスを継承(DAOクラスのメソッドを使えるようにする)
	public Teacher search(String id, String password) // searchメソッドを定義(ユーザの検索機能)
		throws Exception {
		Teacher teacher=null;
		
		 /* 変数のteacher中身はこんな感じ 
		  *   -----------------------  
		  *   | i d | login |password | 
		  *    -----------------------  
		  *   |     |       |         | 
		  *    ----------------------- 
		  */
		
		Connection con=getConnection(); // DB接続

		// 引数で与えられたID、PWDをもつユーザを検索
		PreparedStatement st;
		st=con.prepareStatement(
			"select * from teacher where name=? and password=?");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();

		// 検索結果をTeacherr型の変数に代入
		while (rs.next()) {
			teacher =new Teacher();
			teacher.setId(rs.getString("id"));
			teacher.setName(rs.getString("name"));
			teacher.setPassword(rs.getString("password"));
		}
		
		/* 変数teacherの中身はこんな感じ 
		  *   -----------------------  
		  *   | i d | login |password | 
		  *    -----------------------  
		  *   |  1  |****** |******** | 
		  *    ----------------------- 
		  */

		st.close();
		con.close();
		return teacher;
	}

	private Connection getConnection() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
}
