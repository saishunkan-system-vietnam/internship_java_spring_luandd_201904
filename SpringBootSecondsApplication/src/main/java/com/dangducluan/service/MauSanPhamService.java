package com.dangducluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangducluan.dao.MauSanPhamDAO;
import com.dangducluan.daoimp.MauSanPhamImp;
import com.dangducluan.entities.MauSanPham;

@Service
public class MauSanPhamService implements MauSanPhamImp{
	
	@Autowired
	MauSanPhamDAO mauSanPhamDAO;
	@Override
	public List<MauSanPham> layDanhSachMauSanPham() {
		// TODO Auto-generated method stub
		return mauSanPhamDAO.layDanhSachMauSanPham();
	}

}
