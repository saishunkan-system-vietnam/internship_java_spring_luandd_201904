package com.dangducluan.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dangducluan.daoimp.DanhMucSanPhamImp;
import com.dangducluan.entities.DanhMucSanPham;
import com.dangducluan.mapper.DanhMucSanPhamMapper;

@Repository
public class DanhMucSanPhamDAO implements DanhMucSanPhamImp{
	@Autowired
	DanhMucSanPhamMapper danhMucSanPhamMapper;

	@Override
	public List<DanhMucSanPham> layToanBoDanhMucSanPham() {
		// TODO Auto-generated method stub
		List<DanhMucSanPham> dsDanhMuc = danhMucSanPhamMapper.layToanBoDanhMucSanPham();
		return dsDanhMuc;
	}
}
