package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Post;

public class PostDAO extends DAO{
	
		public List<Post> searchall(String user_id) 
				throws Exception { // searchメソッドを定義
			List<Post> list=new ArrayList<>(); // Product型の配列を作成

			Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

			// select文を実行
			PreparedStatement st=con.prepareStatement(
				"select * from post");
			ResultSet rs=st.executeQuery();
			

			// データを順に取得
			while (rs.next()) {
				Post p=new Post();
				p.setPost_id(rs.getInt("post_id"));
				p.setUser_id(rs.getString("user_id"));
				p.setContent(rs.getString("content"));
				p.setPost_time(rs.getTimestamp("post_time"));
				list.add(p); // データを一件取得するごとにlistに追記する		
			}
			st.close();
			con.close(); // DB接続を閉じる

			return list; 
			
		}
			
			
			

			public int insert(Post post) throws Exception {

				Connection con=getConnection();

				PreparedStatement st=con.prepareStatement(
					"insert into post(user_id, content, post_time) values(?,?,?)");
				st.setString(1, post.getUser_id());
				st.setString(2, post.getContent());
				st.setTimestamp(3, post.getPost_time());
				int line=st.executeUpdate();
			
				st.close();
				con.close();
				return line;
			}
			
			
			
	}
