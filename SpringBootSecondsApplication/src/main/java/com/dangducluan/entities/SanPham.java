package com.dangducluan.entities;

import java.util.Set;

public class SanPham {
	private int masanpham;
	private String tensanpham;
	private String mota;
	private String hinhsanpham;
	private DanhMucSanPham danhmucsanpham;
	private Set<ChiTietSanPham> dsChiTietSanPham;
	public int getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}
	public String getTensanpham() {
		return tensanpham;
	}
	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	public String getHinhsanpham() {
		return hinhsanpham;
	}
	public void setHinhsanpham(String hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}
	public DanhMucSanPham getDanhmucsanpham() {
		return danhmucsanpham;
	}
	public void setDanhmucsanpham(DanhMucSanPham danhmucsanpham) {
		this.danhmucsanpham = danhmucsanpham;
	}
	public Set<ChiTietSanPham> getDsChiTietSanPham() {
		return dsChiTietSanPham;
	}
	public void setDsChiTietSanPham(Set<ChiTietSanPham> dsChiTietSanPham) {
		this.dsChiTietSanPham = dsChiTietSanPham;
	}
}
