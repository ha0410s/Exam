package bean;
public class Student implements java.io.Serializable {
	// Beanで使用する変数（フィールド名）を宣言
	private int no;
	private String name;
	private int ent_year;
	private int class_num;
	private Boolean is_attend;
	private String school_cd;
	// データを取得するメソッドを定義
	public int getno(){
		return no;
	}
	public String getName() {
		return name;
	}
	public int getEnt_year() {
		return ent_year;
	}
	public int getClass_num() {
		return class_num;
	}
	public Boolean getIs_attend() {
		return is_attend;
	}
	public String getSchool_cd() {
		return school_cd;
	}

	// データを設定するメソッドを定義
	public void setNo(int no) {
		this.no=no;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setEnt_year(int ent_year) {
		this.ent_year=ent_year;
	}
	public void setClass_num(int class_num) {
		this.class_num=class_num;
	}
	public void setIs_attend(Boolean is_attend) {
		this.is_attend=is_attend;
	}
	public void setSchool_cd(String school_cd) {
		this.school_cd=school_cd;
	}
	
}

