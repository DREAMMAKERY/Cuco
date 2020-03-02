package tj.ustb.studentFunding.memberList.memberList.domain;

public class MemberList {
	private String department;
	private String major;
	private String classno;
	private byte[] file;
	public MemberList() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getClassno() {
		return classno;
	}
	public void setClassno(String classno) {
		this.classno = classno;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	
}
