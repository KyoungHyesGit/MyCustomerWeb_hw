package vo;

import java.sql.Date;

public class CustomerVo {
	private int id;
	private String email;
	private String name;
	private int age;
	private Date entryDate;
	public CustomerVo() {
		super();
	}
	public CustomerVo(int id, String email, String name, int age, Date entryDate) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.age = age;
		this.entryDate = entryDate;

		this.toString();
	}
	@Override
	public String toString() {
		return "CustomerVo [id=" + id + ", email=" + email + ", name=" + name + ", age=" + age + ", entryDate="
				+ entryDate + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
}
