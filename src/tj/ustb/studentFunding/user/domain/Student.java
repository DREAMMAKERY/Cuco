package tj.ustb.studentFunding.user.domain;
/*
 * User的领域对象
 * */
public class Student {
	/*对应数据库表*/
	private String sid;
	private String sname;
	private String department;
	private String major;
	private String grade;
	private String classno;
	private String spassword;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", department="
				+ department + ", major=" + major + ", grade=" + grade
				+ ", classno=" + classno + ", spassword=" + spassword + "]";
	}
	

	
	
	
}
