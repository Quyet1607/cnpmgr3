package com.moldels;

public class thuoc {
	private String idthuoc;
	private String tenthuoc;
	private String mota;
	private int lieumax;
	private int lieumin;
	private int tsmax;
	private int unit;
	public thuoc() {
		super();
	}
	public thuoc(String idthuoc, String tenthuoc, String mota, int lieumax, int lieumin, int tsmax, int unit) {
		super();
		this.idthuoc = idthuoc;
		this.tenthuoc = tenthuoc;
		this.mota = mota;
		this.lieumax = lieumax;
		this.lieumin = lieumin;
		this.tsmax = tsmax;
		this.unit = unit;
	}
	public String getIdthuoc() {
		return idthuoc;
	}
	public void setIdthuoc(String idthuoc) {
		this.idthuoc = idthuoc;
	}
	public String getTenthuoc() {
		return tenthuoc;
	}
	public void setTenthuoc(String tenthuoc) {
		this.tenthuoc = tenthuoc;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public int getLieumax() {
		return lieumax;
	}
	public void setLieumax(int lieumax) {
		this.lieumax = lieumax;
	}
	public int getLieumin() {
		return lieumin;
	}
	public void setLieumin(int lieumin) {
		this.lieumin = lieumin;
	}
	public int getTsmax() {
		return tsmax;
	}
	public void setTsmax(int tsmax) {
		this.tsmax = tsmax;
	}
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
}
