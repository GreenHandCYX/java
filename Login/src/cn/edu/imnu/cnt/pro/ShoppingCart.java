package cn.edu.imnu.cnt.pro;

import java.sql.Timestamp;

public class ShoppingCart {
	private  int uid;
	private int pid;
	private int scid;
	private Timestamp fdate;
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getScid() {
		return scid;
	}
	public void setScid(int scid) {
		this.scid = scid;
	}
	public Timestamp getFdate() {
		return fdate;
	}
	public void setFdate(Timestamp fdate) {
		this.fdate = fdate;
	}
	@Override
	public String toString() {
		return "ShoppingCart [fdate=" + fdate + ", pid=" + pid + ", scid="
				+ scid + ", uid=" + uid + "]";
	}
	public ShoppingCart(int uid, int pid, int scid, Timestamp fdate) {
		super();
		this.uid = uid;
		this.pid = pid;
		this.scid = scid;
		this.fdate = fdate;
	}
	public ShoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
