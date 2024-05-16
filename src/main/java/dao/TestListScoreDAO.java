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
	
	public List<TestListScore> studentsearch(String student_no) throws Exception {
	    List<TestListScore> scoreList = new ArrayList<>();
	    Connection con = getConnection();
	    PreparedStatement st = con.prepareStatement(
	    		"SELECT * FROM test INNER JOIN student ON test.student_no = student.no INNER JOIN subject ON subject.cd = test.subject_cd where student.no = ?");
	    	st.setString(1, student_no);
	    	 ResultSet rs = st.executeQuery();
	    	 
	    	 while (rs.next()) {
	 	        TestListScore score = new TestListScore();
	 	        score.setStudent_no(rs.getString("student_no"));
	 	        score.setName(rs.getString("name"));
	 	        score.setSubject_cd(rs.getString("subject_cd"));
	 	        score.setPoint(rs.getInt("point"));
	 	        score.setSubject_name(rs.getString("subject.name"));  
	 	        score.setTest_no(rs.getInt("test.no"));
	 	        scoreList.add(score);
	 	    }

	 	    st.close();
	 	    con.close();

	 	    return scoreList;
	 	    
	}
	 public List<TestListScore>updatesearch(String ent_year, String class_num, String subject_name, String test_no)throws Exception{
		 List<TestListScore> scoreList = new ArrayList<>();
		    Connection con = getConnection();
		    PreparedStatement st = con.prepareStatement(
		    	"SELECT * FROM test INNER JOIN student ON test.student_no = student.no INNER JOIN subject ON subject.cd = test.subject_cd where(? is null or student.ent_year = ?) and(? is null or student.class_num =?) and (? is null or subject.name Like ?) and (?is null or test.no = ? )");
		    
		    st.setString(1, ent_year);
	        st.setString(2, ent_year);
	        st.setString(3, class_num);
	        st.setString(4, class_num);
	        st.setString(5, "%" + subject_name + "%");
	        st.setString(6, subject_name);
	        st.setString(7, test_no);
	        st.setString(8, test_no);

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
	 public int update(String student_no, String subject_cd, int point, int test_no) throws Exception {
		    Connection con = getConnection();
		    PreparedStatement st = con.prepareStatement(
		            "UPDATE test SET point = ? WHERE subject_cd LIKE ? AND no = ? AND student_no = ?");
		    // パラメータの設定
		    st.setInt(1, point);
		    st.setString(2, "%" + subject_cd + "%"); // パターンを指定
		    st.setInt(3, test_no);
		    st.setString(4, student_no);
		    // 更新クエリの実行
		    int rowsAffected = st.executeUpdate();
		    // リソースの解放
		    st.close();
		    con.close();
		    return rowsAffected;
		}
}
