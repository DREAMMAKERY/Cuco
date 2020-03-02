package tj.ustb.studentFunding.application.domain;

import java.io.File;
import java.sql.Blob;
import java.sql.Date;

public class Application {
	private String id;
	private String name;
	private String department;
	private String major;
	private String grade;
	private String classno;
	private byte[] application_file;
	private byte[] application_picture;
	
	
	
	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public byte[] getApplication_file() {
		return application_file;
	}

	public void setApplication_file(byte[] application_file) {
		this.application_file = application_file;
	}

	public byte[] getApplication_picture() {
		return application_picture;
	}

	public void setApplication_picture(byte[] application_picture) {
		this.application_picture = application_picture;
	}

	
	

	
}
