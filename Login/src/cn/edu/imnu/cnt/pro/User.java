package cn.edu.imnu.cnt.pro;

public class User {
 private int uid;
 private String userName;
 private String passWord;
 private String info;
 private String sex;
 private String picture;

 
 @Override
public String toString() {
	return "User [email=" + email + ", info=" + info + ", passWord=" + passWord
			+ ", picture=" + picture + ", sex=" + sex + ", uid=" + uid
			+ ", userName=" + userName + "]";
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getPicture() {
	return picture;
}
public void setPicture(String picture) {
	this.picture = picture;
}
private String email;
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassWord() {
	return passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int uid, String userName, String passWord) {
	super();
	this.uid = uid;
	this.userName = userName;
	this.passWord = passWord;
}






 
}
