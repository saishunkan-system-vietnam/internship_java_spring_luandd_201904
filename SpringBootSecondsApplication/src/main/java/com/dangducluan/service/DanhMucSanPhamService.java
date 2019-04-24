package com.dangducluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangducluan.dao.DanhMucSanPhamDAO;
import com.dangducluan.daoimp.DanhMucSanPhamImp;
import com.dangducluan.entities.DanhMucSanPham;

@Service
public class DanhMucSanPhamService implements DanhMucSanPhamImp{

	@Autowired
	DanhMucSanPhamDAO danhMucSanPhamDAO;
	@Override
	public List<DanhMucSanPham> layToanBoDanhMucSanPham() {
		// TODO Auto-generated method stub
		return danhMucSanPhamDAO.layToanBoDanhMucSanPham();
	}

}
