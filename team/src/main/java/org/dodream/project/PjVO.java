package org.dodream.project;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class PjVO {

	private int num;
	private String title;
	private String contents;
	private String author;
	private String desc;
	private Date regdate;
	private int ref;
	private int no;
	private int pagenum;
	private int totalpages;
	private List<MultipartFile> files;
	
	
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpage) {
		this.totalpages = totalpage;
	}
	
	
}
