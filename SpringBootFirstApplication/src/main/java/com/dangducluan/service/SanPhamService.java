package com.dangducluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangducluan.dao.SanPhamDAO;
import com.dangducluan.daoimp.SanPhamImp;
import com.dangducluan.entities.SanPham;

@Service
public class SanPhamService implements SanPhamImp{
	@Autowired
	SanPhamDAO sanPhamDAO;

	@Override
	public List<SanPham> layDanhSachSanPham() {
		// TODO Auto-generated method stub
		return sanPhamDAO.layDanhSachSanPham();
	}

	@Override
	public boolean suaThongTinSanPhamTheoMa(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.suaThongTinSanPhamTheoMa(sanPham);
	}

	@Override
	public boolean xoaSanPhamTheoMa(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.xoaSanPhamTheoMa(sanPham);
	}

	@Override
	public boolean themSanPhamMoi(SanPham sanPham) {
		// TODO Auto-generated method stub
		boolean ktThemSanPham = sanPhamDAO.themSanPhamMoi(sanPham);
		return ktThemSanPham;
	}

	@Override
	public SanPham layThongTinSanPhamTheoMa(int maSanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.layThongTinSanPhamTheoMa(maSanPham);
	}

	@Override
	public List<SanPham> layDanhSachSanPhamTheoTen(String tenSanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.layDanhSachSanPhamTheoTen(tenSanPham);
	}

	@Override
	public List<SanPham> layDanhSachSanPhamTheoKhoangGia(int giaSanPhamBd, int giaSanPhamKt) {
		// TODO Auto-generated method stub
		return sanPhamDAO.layDanhSachSanPhamTheoKhoangGia(giaSanPhamBd,giaSanPhamKt);
	}

	@Override
	public List<SanPham> layDanhSachSanPhamTheoKhoangSoLuong(int soLuongBatDau, int soLuongKetThuc) {
		// TODO Auto-generated method stub
		return sanPhamDAO.layDanhSachSanPhamTheoKhoangSoLuong(soLuongBatDau, soLuongKetThuc);
	}
}
