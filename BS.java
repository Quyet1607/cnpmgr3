package com.moldels;

public class BS{
	private String idbs;
	private String tenbs;
	private String ns;
	private String gt;
	private String sdt;
	private String password;
	private String avt;
	
	public BS() {
		super();
	}

	public BS(String idbs, String tenbs, String ns, String gt, String sdt, String password, String avt) {
		super();
		this.idbs = idbs;
		this.tenbs = tenbs;
		this.ns = ns;
		this.gt = gt;
		this.sdt = sdt;
		this.password = password;
		this.avt = avt;
	}

	public String getIdbs() {
		return idbs;
	}

	public void setIdbs(String idbs) {
		this.idbs = idbs;
	}

	public String getTenbs() {
		return tenbs;
	}

	public void setTenbs(String tenbs) {
		this.tenbs = tenbs;
	}

	public String getNs() {
		return ns;
	}

	public void setNs(String ns) {
		this.ns = ns;
	}

	public String getGt() {
		return gt;
	}

	public void setGt(String gt) {
		this.gt = gt;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAvt() {
		return avt;
	}

	public void setAvt(String avt) {
		this.avt = avt;
	}
}