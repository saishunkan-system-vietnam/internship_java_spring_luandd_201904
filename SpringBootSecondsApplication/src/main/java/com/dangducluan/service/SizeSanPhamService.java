package com.dangducluan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dangducluan.dao.SizeSanPhamDAO;
import com.dangducluan.daoimp.SizeSanPhamImp;
import com.dangducluan.entities.SizeSanPham;

@Service
public class SizeSanPhamService implements SizeSanPhamImp{

	@Autowired
	SizeSanPhamDAO sizeSanPhamDAO;
	@Override
	public List<SizeSanPham> layDanhSachSizeSanPham() {
		// TODO Auto-generated method stub
		return sizeSanPhamDAO.layDanhSachSizeSanPham();
	}

}
