package org.dodream.project;

import java.util.Date;

public class FileVO {

	private int num;
	private String owner;
	private String desc;
	private String fname1;
	private String fname2;
	private long fsize;
	private Date udate;
	private int totalpages;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getFname1() {
		return fname1;
	}
	public void setFname1(String fname1) {
		this.fname1 = fname1;
	}
	public String getFname2() {
		return fname2;
	}
	public void setFname2(String fname2) {
		this.fname2 = fname2;
	}
	public long getFsize() {
		return fsize;
	}
	public void setFsize(long fsize) {
		this.fsize = fsize;
	}
	public Date getUdate() {
		return udate;
	}
	public void setUdate(Date udate) {
		this.udate = udate;
	}
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
}
