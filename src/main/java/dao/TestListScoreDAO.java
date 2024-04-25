package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.TestListScore; // TestListSubjectクラスのimportを追加

public class TestListScoreDAO extends DAO {
	
	public List<TestListScore> search(String class_num, String subject_name, String ent_year) throws Exception {
	    List<TestListScore> scoreList = new ArrayList<>();
	    Connection con = getConnection();
	    PreparedStatement st = con.prepareStatement(
	        "SELECT * FROM test INNER JOIN student ON test.student_no = student.no INNER JOIN subject ON subject.cd = test.subject_cd WHERE (? IS NULL OR student.class_num = ?) AND (? IS NULL OR subject.name LIKE ?) AND (? IS NULL OR student.ent_year = ?)");
	    st.setString(1, class_num);  
	    st.setString(2, class_num);  
	    st.setString(3, "%" + subject_name + "%");  
	    st.setString(4, subject_name);  
	    st.setString(5, ent_year);  
	    st.setString(6, ent_year);
	    ResultSet rs = st.executeQuery();

	    while (rs.next()) {
	        TestListScore score = new TestListScore();
	        score.setEnt_year(rs.getInt("ent_year"));
	        score.setStudent_no(rs.getString("student_no"));
	        score.setName(rs.getString("name"));
	        score.setClass_num(rs.getString("class_num"));
	        score.setPoint(rs.getInt("point"));
	        score.setSubject_name(rs.getString("subject.name"));  
	        score.setTest_no(rs.getInt("test.no"));
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
                "SELECT * From test inner join student on test.student_no = student.no inner join subject on subject.cd = test.subject_cd"); // 成績の一覧を取得するSQL文

        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            TestListScore score = new TestListScore();
            score.setEnt_year(rs.getInt("ent_year"));
            score.setStudent_no(rs.getString("student_no"));
            score.setName(rs.getString("name"));
            score.setClass_num(rs.getString("class_num"));
            score.setPoint(rs.getInt("point"));
            score.setSubject_name(rs.getString("subject.name"));
            score.setTest_no(rs.getInt("test.no"));
            scoreList.add(score);
        }

        st.close();
        con.close();

        return scoreList;
    
    }

		
			
    }

