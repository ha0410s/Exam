
	package dao;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;

	public class StudentDAO extends DAO { // DAOクラスを継承(DAOクラスのメソッドが使えるようになる)

		public List<Student> search(String keyword) throws Exception { // searchメソッドを定義
			List<Student> list=new ArrayList<>(); // Product型の配列を作成

			Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

			// select文を実行
			PreparedStatement st=con.prepareStatement(
				"select * from student");
			ResultSet rs=st.executeQuery();

			// データを順に取得
			while (rs.next()) {
				Student p=new Student();
				p.setNo(rs.getInt("no"));
				p.setName(rs.getString("name"));
				p.setEnt_year(rs.getInt("ent_year"));
				p.setClass_num(rs.getInt("class_num"));
				p.setIs_attend(rs.getBoolean("is_attend"));
				p.setSchool_cd(rs.getString("school_cd"));
				list.add(p); // データを一件取得するごとにlistに追記する		
			}

			st.close();
			con.close(); // DB接続を閉じる

			return list; // listの値を返却する
		}

//		public int insert(Student Studet) throws Exception {
//			Connection con=getConnection();
//
//			PreparedStatement st=con.prepareStatement(
//				"insert into product values(null, ?, ?)");
//			st.setString(1, student.getName());
//			st.setInt(2, student.get());
//			int line=st.executeUpdate();
//
//			st.close();
//			con.close();
//			return line;
//		}
//	}

}
