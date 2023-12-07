package com.moldels;

public class ctdonthuoc {
	private int iddt;
	private String idthuoc;
	private int lieuluong;
	private int ts;
	private int sl;
	private String dang;
	
	public ctdonthuoc() {
		super();
	}

	public ctdonthuoc(int iddt, String idthuoc, int lieuluong, int ts, int sl, String dang) {
		super();
		this.iddt = iddt;
		this.idthuoc = idthuoc;
		this.lieuluong = lieuluong;
		this.ts = ts;
		this.sl = sl;
		this.dang = dang;
	}

	public int getIddt() {
		return iddt;
	}

	public void setIddt(int iddt) {
		this.iddt = iddt;
	}

	public String getIdthuoc() {
		return idthuoc;
	}

	public void setIdthuoc(String idthuoc) {
		this.idthuoc = idthuoc;
	}

	public int getLieuluong() {
		return lieuluong;
	}

	public void setLieuluong(int lieuluong) {
		this.lieuluong = lieuluong;
	}

	public int getTs() {
		return ts;
	}

	public void setTs(int ts) {
		this.ts = ts;
	}

	public int getSl() {
		return sl;
	}

	public void setSl(int sl) {
		this.sl = sl;
	}

	public String getDang() {
		return dang;
	}

	public void setDang(String dang) {
		this.dang = dang;
	}
	
	
}
