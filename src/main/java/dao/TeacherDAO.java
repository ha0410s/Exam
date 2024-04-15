package dao;

import java.sql.Connection;
//
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;

public class TeacherDAO extends DAO{ // DAOクラスを継承(DAOクラスのメソッドを使えるようにする)
	public Teacher search(String id, String password) 
		throws Exception {
		Teacher teacher=null;
		
		Connection con=getConnection(); // DB接続

		// 引数で与えられたID、PWDをもつユーザを検索
		PreparedStatement st;
		st=con.prepareStatement(
			"select * from teacher where id=? and password=?");
		st.setString(1, id);
		st.setString(2, password);
		ResultSet rs=st.executeQuery();

		// 検索結果をTeacherr型の変数に代入
		while (rs.next()) {
			teacher =new Teacher();
			teacher.setId(rs.getString("id"));
			teacher.setName(rs.getString("name"));
			teacher.setPassword(rs.getString("password"));
			teacher.setSchool_cd(rs.getString("school_cd"));
		}
		st.close();
		con.close();
		return teacher;
		}
}


