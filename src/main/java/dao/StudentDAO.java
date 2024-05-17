package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;



public class StudentDAO extends DAO { // DAOクラスを継承(DAOクラスのメソッドが使えるようになる)
	public List<Student> searchall(String teacher_school_cd) 
			throws Exception { // searchメソッドを定義
		List<Student> list=new ArrayList<>(); // Product型の配列を作成

		Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

		// select文を実行
		PreparedStatement st=con.prepareStatement(
			"select * from student where school_cd = ?");
		st.setString(1, teacher_school_cd);
		ResultSet rs=st.executeQuery();
		

		// データを順に取得
		while (rs.next()) {
			Student p=new Student();
			p.setNo(rs.getString("no"));
			p.setName(rs.getString("name"));
			p.setEnt_year(rs.getInt("ent_year"));
			p.setClass_num(rs.getString("class_num"));
			p.setIs_attend(rs.getBoolean("is_attend"));
			p.setSchool_cd(rs.getString("school_cd"));
			list.add(p); // データを一件取得するごとにlistに追記する		
		}
		st.close();
		con.close(); // DB接続を閉じる

		return list; 
		
	}
		public List<Student> search1(int select_ent_year, String select_class_num, Boolean select_is_attend, String teacher_school_cd) 
				throws Exception { // searchメソッドを定義
			List<Student> list=new ArrayList<>(); // Product型の配列を作成

			Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

			// select文を実行
			PreparedStatement st=con.prepareStatement(
				"select * from student where ent_year = ? and class_num = ? and is_attend = ? and school_cd = ?");
			st.setInt(1, select_ent_year);
			st.setString(2, select_class_num);
			st.setBoolean(3, select_is_attend);
			st.setString(4, teacher_school_cd);
			ResultSet rs=st.executeQuery();

			// データを順に取得
			while (rs.next()) {
				Student p=new Student();
				p.setNo(rs.getString("no"));
				p.setName(rs.getString("name"));
				p.setEnt_year(rs.getInt("ent_year"));
				p.setClass_num(rs.getString("class_num"));
				p.setIs_attend(rs.getBoolean("is_attend"));
				p.setSchool_cd(rs.getString("school_cd"));
				list.add(p); // データを一件取得するごとにlistに追記する		
			}

			st.close();
			con.close(); // DB接続を閉じる

			return list; // listの値を返却する


}
		
		public List<Student> search2(int select_ent_year, Boolean select_is_attend, String teacher_school_cd) 
				throws Exception { // searchメソッドを定義
			List<Student> list=new ArrayList<>(); // Product型の配列を作成

			Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

			// select文を実行
			PreparedStatement st=con.prepareStatement(
				"select * from student where ent_year = ? and is_attend = ? and school_cd = ? ");
			st.setInt(1, select_ent_year);
			st.setBoolean(2, select_is_attend);
			st.setString(3, teacher_school_cd);
			ResultSet rs=st.executeQuery();

			// データを順に取得
			while (rs.next()) {
				Student p=new Student();
				p.setNo(rs.getString("no"));
				p.setName(rs.getString("name"));
				p.setEnt_year(rs.getInt("ent_year"));
				p.setClass_num(rs.getString("class_num"));
				p.setIs_attend(rs.getBoolean("is_attend"));
				p.setSchool_cd(rs.getString("school_cd"));
				list.add(p); // データを一件取得するごとにlistに追記する		
			}

			st.close();
			con.close(); // DB接続を閉じる

			return list; // listの値を返却する


}
		public List<Student> search3(Boolean select_is_attend, String teacher_school_cd) 
				throws Exception { // searchメソッドを定義
			List<Student> list=new ArrayList<>(); // Product型の配列を作成

			Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

			// select文を実行
			PreparedStatement st=con.prepareStatement(
				"select * from student where is_attend = ? and school_cd = ? ");
			st.setBoolean(1, select_is_attend);
			st.setString(2, teacher_school_cd);
			ResultSet rs=st.executeQuery();

			// データを順に取得
			while (rs.next()) {
				Student p=new Student();
				p.setNo(rs.getString("no"));
				p.setName(rs.getString("name"));
				p.setEnt_year(rs.getInt("ent_year"));
				p.setClass_num(rs.getString("class_num"));
				p.setIs_attend(rs.getBoolean("is_attend"));
				p.setSchool_cd(rs.getString("school_cd"));
				list.add(p); // データを一件取得するごとにlistに追記する		
			}

			st.close();
			con.close(); // DB接続を閉じる

			return list; // listの値を返却する


}


		public int insert(Student student) throws Exception {

			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
				"insert into student values(?,?,?,?,?,?)");
			st.setString(1, student.getNo());
			st.setString(2, student.getName());
			st.setInt(3, student.getEnt_year());
			st.setString(4, student.getClass_num());
			st.setBoolean(5, student.getIs_attend());
			st.setString(6, student.getSchool_cd());
			int line=st.executeUpdate();
		
			st.close();
			con.close();
			return line;
		}
		public Student searchstudent(String no) 
				throws Exception { // searchメソッドを定義
			

			Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

			// select文を実行
			PreparedStatement st=con.prepareStatement(
				"select * from student where no = ?");
			st.setString(1, no);
			ResultSet rs=st.executeQuery();

			
			Student p=null;
			// データを順に取得
			while (rs.next()) {
				p=new Student();
				p.setNo(rs.getString("no"));
				p.setName(rs.getString("name"));
				p.setEnt_year(rs.getInt("ent_year"));
				p.setClass_num(rs.getString("class_num"));
				p.setIs_attend(rs.getBoolean("is_attend"));
				p.setSchool_cd(rs.getString("school_cd"));
			}
			st.close();
			con.close(); // DB接続を閉じる

			return p; 
			
		}
		public int update(String no, String update_name, String update_class_num, Boolean update_is_attend) 
				throws Exception { // searchメソッドを定義

			Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

			// select文を実行
			PreparedStatement st=con.prepareStatement(
					"UPDATE student SET name = ?, class_num= ?, is_attend=? WHERE no = ?");
			st.setString(1, update_name);
			st.setString(2, update_class_num);
			st.setBoolean(3, update_is_attend);
			st.setString(4, no);
			int line=st.executeUpdate();

			st.close();
			con.close();
			return line;

}
		
}

