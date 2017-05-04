package team.user.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class UserVo {
	
	@Size(min=1,max=10, message="1~10�ڷ� �Է����ּ���")
	private String id;
	@NotEmpty(message="�ʼ��Է� �׸��Դϴ�")
	private String pwd;
	private String name;
	private String phone;
	private String email;
	private String gender;
	private String authority;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
