package cn.edu.imnu.cnt.pro;

public class Kind {
	private int kid;
	private String kname;
	public int getKid() {
		return kid;
	}
	public void setKid(int kid) {
		this.kid = kid;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public Kind() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Kind(int kid, String kname) {
		super();
		this.kid = kid;
		this.kname = kname;
	}
	@Override
	public String toString() {
		return "Kind [kid=" + kid + ", kname=" + kname + "]";
	}
	
	
}
