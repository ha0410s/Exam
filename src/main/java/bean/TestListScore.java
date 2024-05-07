package bean;

public class TestListScore implements java.io.Serializable {
	// Beanで使用する変数（フィールド名）を宣言
	private int ent_year;
	private String student_no;
	private String name;
	private String class_num;
	private int point;
	private String subject_name;
	private int test_no;

	
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
	public int getPoint() {
		return point;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public int getTest_no() {
		return test_no;
	}
	
	public void setEnt_year(int ent_year) {
		this.ent_year=ent_year;
	}
	public void setStudent_no(String student_no) {
		this.student_no=student_no;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setClass_num(String class_num) {
		this.class_num=class_num;
	}
	public void setPoint(int point) {
		this.point=point;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name=subject_name;
	}
	public void setTest_no(int test_no) {
		this.test_no=test_no;
	}
}

