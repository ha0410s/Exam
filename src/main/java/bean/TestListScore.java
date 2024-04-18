package bean;

public class TestListScore implements java.io.Serializable {
	// Beanで使用する変数（フィールド名）を宣言
	private int ent_year;
	private String student_no;
	private String name;
	private String class_num;
	private String school_cd;
	private int point;
	
	public int getEnt_year() {
		return ent_year;
	}
	public String getStudent_no() {
		return student_no;
	}
	public String getName() {
		return name;
	}
	public String getClass_num() {
		return class_num;
	}
	public String getSchool_cd() {
		return school_cd;
	}
	public int getPoint() {
		return point;
	}
	
	public void setEnt_year(int ent_year) {
		this.ent_year=ent_year;
	}
	public void setStudent_no(String student_no) {
		this.student_no=student_no;
	}
	public void setStudent_name(String name) {
		this.name=name;
	}
	public void setClass_num(String class_num) {
		this.class_num=class_num;
	}
	public void setSchool_cd(String school_cd) {
		this.school_cd=school_cd;
	}
	public void setPoint(int point) {
		this.point=point;
	}
}

