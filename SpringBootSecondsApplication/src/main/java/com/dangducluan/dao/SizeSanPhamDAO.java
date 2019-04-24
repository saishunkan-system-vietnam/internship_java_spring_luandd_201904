package com.dangducluan.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dangducluan.daoimp.SizeSanPhamImp;
import com.dangducluan.entities.SizeSanPham;
import com.dangducluan.mapper.SizeSanPhamMapper;
@Repository
public class SizeSanPhamDAO implements SizeSanPhamImp{

	@Autowired
	SizeSanPhamMapper sizeSanPhamMapper;
	@Override
	public List<SizeSanPham> layDanhSachSizeSanPham() {
		// TODO Auto-generated method stub
		List<SizeSanPham> dsSize = sizeSanPhamMapper.layDanhSachSizeSanPham();
		return dsSize;
	}

}
