package cn.edu.imnu.cnt.pro;

import java.sql.Timestamp;





public class Shopping {
	private int pid;
	private String pname;
	private int price;
	private String pinfo;
	
	private String purl;
	private Timestamp pTime;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPinfo() {
		return pinfo;
	}
	public void setPinfo(String pinfo) {
		this.pinfo = pinfo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPurl() {
		return purl;
	}
	public void setPurl(String purl) {
		this.purl = purl;
	}
	public Timestamp getpTime() {
		return pTime;
	}
	public void setpTime(Timestamp pTime) {
		this.pTime = pTime;
	}
	
	
	@Override
	public String toString() {
		return "Shopping [pTime=" + pTime + ", pid=" + pid + ", pinfo=" + pinfo
				+ ", pname=" + pname + ", price=" + price + ", purl=" + purl
				+ "]";
	}
	
	
	public Shopping(int pid, String pname, int price, String pinfo,
			String purl, Timestamp pTime) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.pinfo = pinfo;
		this.purl = purl;
		this.pTime = pTime;
	}
	public Shopping() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
