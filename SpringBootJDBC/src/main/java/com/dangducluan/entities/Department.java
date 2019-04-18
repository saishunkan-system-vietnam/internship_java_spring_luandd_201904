package com.dangducluan.entities;

public class Department {
	private Long depid;
	private String depno;
	private String depname;
	
	public Department(Long depid, String depno, String depname) {
		super();
		this.depid = depid;
		this.depno = depno;
		this.depname = depname;
	}
	public Long getDepid() {
		return depid;
	}
	public void setDepid(Long depid) {
		this.depid = depid;
	}
	public String getDepno() {
		return depno;
	}
	public void setDepno(String depno) {
		this.depno = depno;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	
}
