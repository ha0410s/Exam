package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Subject;

	public class SubjectDAO extends DAO { // DAOクラスを継承(DAOクラスのメソッドが使えるようになる)

		public List<Subject> search(String keyword) throws Exception { // searchメソッドを定義
			List<Subject> list=new ArrayList<>(); // Product型の配列を作成

			Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

			// select文を実行
			PreparedStatement st=con.prepareStatement(
				"select * from subject");
			ResultSet rs=st.executeQuery();

			// データを順に取得
			while (rs.next()) {
				Subject k=new Subject();
				k.setSchool_cd(rs.getString("school_cd"));
				k.setCD(rs.getString("cd"));
				k.setName(rs.getString("name"));
			    list.add(k); // データを一件取得するごとにlistに追記する
			}

			st.close();
			con.close(); // DB接続を閉じる

			return list; // listの値を返却する
         }
		
		public int insert(Subject subject) throws Exception {
			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
				"insert into subject values(?, ?, ?)");
			st.setString(1, subject.getSchool_cd());
			st.setString(2, subject.getCD());
			st.setString(3, subject.getName());
			int line=st.executeUpdate();

			st.close();
			con.close();
			return line;
		}
		
		//データベースのデータを更新するメソッド
		public int update(Subject subject) throws Exception {
			Connection con=getConnection();
			
			PreparedStatement st=con.prepareStatement(
					"update subject set school_cd=?, name=? where cd=?");
			st.setString(1, subject.getSchool_cd());
			st.setString(2, subject.getName());
			st.setString(3, subject.getCD());
			int line=st.executeUpdate();

			st.close();
			con.close();
			return line;
		}		
		
		public int delete(Subject subject) throws Exception {
			Connection con=getConnection();

			PreparedStatement st=con.prepareStatement(
				"delete from subject where cd=?");
			st.setString(1, subject.getCD());
			int line=st.executeUpdate();

			st.close();
			con.close();
			return line;
		}
	}