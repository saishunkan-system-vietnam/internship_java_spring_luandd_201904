package com.dangducluan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dangducluan.mapper.DanhMucSanPhamMapper;

@Repository
public class DanhMucSanPhamDAO {
	@Autowired
	DanhMucSanPhamMapper danhMucSanPhamMapper;
}
