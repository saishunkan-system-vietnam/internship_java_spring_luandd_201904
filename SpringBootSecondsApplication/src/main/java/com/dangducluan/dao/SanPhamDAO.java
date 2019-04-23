package com.dangducluan.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dangducluan.daoimp.SanPhamImp;
import com.dangducluan.entities.SanPham;
import com.dangducluan.mapper.SanPhamMapper;
@Repository
public class SanPhamDAO implements SanPhamImp{

	@Autowired
	SanPhamMapper sanPhamMapper;
	@Override
	/**
	 * Get all list product in database
	 * @param : none
	 * @return : List
	 */
	public List<SanPham> layTatCaSanPham() {
		// TODO Auto-generated method stub
		List<SanPham> dsSanPham = sanPhamMapper.layTatCaSanPham();
		return dsSanPham;
	}
	@Override
	/**
	 * Get details product by id
	 * @param : int
	 * @return : SanPham
	 */
	public SanPham layThongTinSanPhamTheoMa(int maSanPham) {
		// TODO Auto-generated method stub
		SanPham sanPham = sanPhamMapper.layThongTinSanPhamTheoMa(maSanPham);
		return sanPham;
	}
	

}
