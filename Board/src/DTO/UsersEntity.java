package DTO;

public class UsersEntity extends Entity {
	
	public String getId() {
		return attribute.get("id");
	}
	public void setId(String id) {
		attribute.put("id", id);
	}
	
	public String getPw() {
		return attribute.get("pw");
	}
	public void setPw(String pw) {
		attribute.put("pw", pw);
	}
	
	public String getName() {
		return attribute.get("name");
	}
	public void setName(String name) {
		attribute.put("name", name);
	}
	
	public String getBirthday() {
		return attribute.get("birthday");
	}
	public void setBirthday(String birthday) {
		attribute.put("birthday", birthday);
	}
	
	public String getGender() {
		return attribute.get("gender");
	}
	public void setGender(String gender) {
		attribute.put("gender", gender);
	}
	
	public String getPnum() {
		return attribute.get("pnum");
	}
	public void setPnum(String pnum) {
		attribute.put("pnum", pnum);
	}
	
	public String getEmail() {
		return attribute.get("email");
	}
	public void setEmail(String email) {
		attribute.put("email", email);
	}
	
}
