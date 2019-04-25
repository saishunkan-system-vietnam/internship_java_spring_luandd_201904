package com.dangducluan.mapper;

import com.dangducluan.entities.ChiTietSanPham;

public interface ChiTietSanPhamMapper {
	public abstract int themThongTinChiTietSanPham(ChiTietSanPham chiTietSanPham);
	public abstract boolean xoaThongTinChiTietSanPham(int maSanPham);
	public abstract boolean capNhatThongTinChiTietSanPham(ChiTietSanPham chiTietSanPham);
}
