package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.TestListScore; // TestListSubjectクラスのimportを追加

public class TestListScoreDAO extends DAO {
	
	public List<TestListScore> search(String keyword) throws Exception { // searchメソッドを定義
		List<TestListScore> scoreList=new ArrayList<>(); // Product型の配列を作成

		Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

		PreparedStatement st=con.prepareStatement(
				"SELECT * From test join student on test.class_num = student.class_num Where student.name like ?"); // 成績の一覧を取得するSQL文
		st.setString(1, "%"+keyword+"%");
		ResultSet rs=st.executeQuery();
		
		
		 while (rs.next()) {
	            TestListScore score = new TestListScore();
	            score.setEnt_year(rs.getInt("ent_year"));
	            score.setStudent_no(rs.getString("student_no"));
	            score.setStudent_name(rs.getString("name"));
	            score.setClass_num(rs.getString("class_num"));
	            score.setSchool_cd(rs.getString("school_cd"));
	            score.setPoint(rs.getInt("point"));
	            scoreList.add(score);
	        }

        st.close();
        con.close();

        return scoreList;
	}

    public List<TestListScore> getAllScore() throws Exception {
        List<TestListScore> scoreList = new ArrayList<>();

        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
                "SELECT * From test join student on test.class_num = student.class_num"); // 成績の一覧を取得するSQL文

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            TestListScore score = new TestListScore();
            score.setEnt_year(rs.getInt("ent_year"));
            score.setStudent_no(rs.getString("student_no"));
            score.setStudent_name(rs.getString("name"));
            score.setClass_num(rs.getString("class_num"));
            score.setSchool_cd(rs.getString("school_cd"));
            score.setPoint(rs.getInt("point"));
            scoreList.add(score);
        }

        st.close();
        con.close();

        return scoreList;
    }
        
		
			
    }

