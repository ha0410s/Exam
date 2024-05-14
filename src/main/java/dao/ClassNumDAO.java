package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClassNumDAO extends DAO {
    public List<String> getClassNumsBySchoolCd(String school_cd) throws Exception {
        List<String> list = new ArrayList<>();

        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "select class_num from class_num where school_cd = ?");
        st.setString(1, school_cd);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            list.add(rs.getString("class_num"));
        }

        st.close();
        con.close();

        return list;
    }
}
