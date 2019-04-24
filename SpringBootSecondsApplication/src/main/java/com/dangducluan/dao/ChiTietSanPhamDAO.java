package com.dangducluan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dangducluan.daoimp.ChiTietSanPhamImp;
import com.dangducluan.entities.ChiTietSanPham;
import com.dangducluan.mapper.ChiTietSanPhamMapper;

@Repository
public class ChiTietSanPhamDAO implements ChiTietSanPhamImp{

	@Autowired
	ChiTietSanPhamMapper chiTietSanPhamMapper;
	@Override
	public int themThongTinChiTietSanPham(ChiTietSanPham chiTietSanPham) {
		// TODO Auto-generated method stub
		int maChiTietSp = chiTietSanPhamMapper.themThongTinChiTietSanPham(chiTietSanPham);
		return maChiTietSp;
	}
	@Override
	public boolean xoaThongTinChiTietSanPham(int maSanPham) {
		// TODO Auto-generated method stub
		try {
			chiTietSanPhamMapper.xoaThongTinChiTietSanPham(maSanPham);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	
}
