package com.dangducluan.daoimp;
import java.util.List;

import com.dangducluan.entities.*;
public interface SanPhamImp {
	public abstract List<SanPham> layDanhSachSanPham();
	public abstract boolean themSanPhamMoi(SanPham sanPham);
	public abstract SanPham layThongTinSanPhamTheoMa(int maSanPham);
	public abstract boolean suaThongTinSanPhamTheoMa(SanPham sanPham);
	public abstract boolean xoaSanPhamTheoMa(SanPham sanPham);
	public abstract List<SanPham> layDanhSachSanPhamTheoTen(String tenSanPham);
	public abstract List<SanPham> layDanhSachSanPhamTheoGia(int giaBD, int giaKT);
	public abstract List<SanPham> layDanhSachSanPhamTheoSoLuong(int soLuongBD, int soLuongKT);
}
