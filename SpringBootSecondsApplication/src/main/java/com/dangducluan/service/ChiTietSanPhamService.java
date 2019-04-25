package com.dangducluan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangducluan.dao.ChiTietSanPhamDAO;
import com.dangducluan.daoimp.ChiTietSanPhamImp;
import com.dangducluan.entities.ChiTietSanPham;

@Service
public class ChiTietSanPhamService implements ChiTietSanPhamImp{

	@Autowired
	ChiTietSanPhamDAO chiTietSanPhamDAO;
	@Override
	public int themThongTinChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		// TODO Auto-generated method stub
		return chiTietSanPhamDAO.themThongTinChiTietSanPham(chiTietSanPham);
	}
	@Override
	public boolean xoaThongTinChiTietSanPham(int maSanPham) {
		// TODO Auto-generated method stub
		return chiTietSanPhamDAO.xoaThongTinChiTietSanPham(maSanPham);
	}
	@Override
	public boolean capNhatThongTinChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		// TODO Auto-generated method stub
		return chiTietSanPhamDAO.capNhatThongTinChiTietSanPham(chiTietSanPham);
	}

}
