package com.moldels;

public class donthuoc {
	private int iddt;
	private String idbn;
	private String idbs;
	private String ngaytao;
	private String trangthai;
	
	public donthuoc() {
		super();
	}

	public donthuoc(int iddt, String idbn, String idbs, String ngaytao, String trangthai) {
		super();
		this.iddt = iddt;
		this.idbn = idbn;
		this.idbs = idbs;
		this.ngaytao = ngaytao;
		this.trangthai = trangthai;
	}

	public int getIddt() {
		return iddt;
	}

	public void setIddt(int iddt) {
		this.iddt = iddt;
	}

	public String getIdbn() {
		return idbn;
	}

	public void setIdbn(String idbn) {
		this.idbn = idbn;
	}

	public String getIdbs() {
		return idbs;
	}

	public void setIdbs(String idbs) {
		this.idbs = idbs;
	}

	public String getNgaytao() {
		return ngaytao;
	}

	public void setNgaytao(String ngaytao) {
		this.ngaytao = ngaytao;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
}
