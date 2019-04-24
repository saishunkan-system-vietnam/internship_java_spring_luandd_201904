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
	public List<SanPham> layTatCaSanPham() {
		// TODO Auto-generated method stub
		return sanPhamDAO.layTatCaSanPham();
	}

	@Override
	public SanPham layThongTinSanPhamTheoMa(int maSanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.layThongTinSanPhamTheoMa(maSanPham);
	}

	@Override
	public int themSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.themSanPham(sanPham);
	}

	@Override
	public boolean xoaSanPhamTheoMa(int maSanPham) {
		// TODO Auto-generated method stub
		return sanPhamDAO.xoaSanPhamTheoMa(maSanPham);
	}
}
