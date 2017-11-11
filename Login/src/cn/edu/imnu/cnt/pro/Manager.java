package cn.edu.imnu.cnt.pro;

public class Manager {
	private int mid;
	private String mname;
	private String mpass;
	private String email;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMpass() {
		return mpass;
	}
	public void setMpass(String mpass) {
		this.mpass = mpass;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(int mid, String mname, String mpass, String email) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.mpass = mpass;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Manager [email=" + email + ", mid=" + mid + ", mname=" + mname
				+ ", mpass=" + mpass + "]";
	}
	
	
}
