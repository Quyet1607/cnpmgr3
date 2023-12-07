package com.moldels;

import java.io.Serializable;

public class BN {
	private String idbn;
	private String tenbn;
	private String ns;
	private String gt;
	private String sdt;
	private String dc;
	
	public BN() {
		super();
	}

	public BN(String idbn, String tenbn, String ns, String gt, String sdt, String dc) {
		super();
		this.idbn = idbn;
		this.tenbn = tenbn;
		this.ns = ns;
		this.gt = gt;
		this.sdt = sdt;
		this.dc = dc;
	}

	public String getIdbn() {
		return idbn;
	}

	public void setIdbn(String idbn) {
		this.idbn = idbn;
	}

	public String getTenbn() {
		return tenbn;
	}

	public void setTenbn(String tenbn) {
		this.tenbn = tenbn;
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

	public String getDc() {
		return dc;
	}

	public void setDc(String dc) {
		this.dc = dc;
	}
}