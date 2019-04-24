package com.dangducluan.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dangducluan.daoimp.MauSanPhamImp;
import com.dangducluan.entities.MauSanPham;
import com.dangducluan.mapper.MauSanPhamMapper;
@Repository
public class MauSanPhamDAO implements MauSanPhamImp{

	@Autowired
	MauSanPhamMapper mauSanPhamMapper;
	@Override
	public List<MauSanPham> layDanhSachMauSanPham() {
		// TODO Auto-generated method stub
		List<MauSanPham> dsMau = mauSanPhamMapper.layDanhSachMauSanPham();
		return dsMau;
	}

}
