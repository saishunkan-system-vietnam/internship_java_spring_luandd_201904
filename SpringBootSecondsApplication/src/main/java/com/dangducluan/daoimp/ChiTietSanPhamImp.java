package com.dangducluan.daoimp;

import com.dangducluan.entities.ChiTietSanPham;

public interface ChiTietSanPhamImp {
	public abstract int themThongTinChiTietSanPham(ChiTietSanPham chiTietSanPham);
	public abstract boolean xoaThongTinChiTietSanPham(int maSanPham);
	public abstract boolean capNhatThongTinChiTietSanPham(ChiTietSanPham chiTietSanPham);
}
