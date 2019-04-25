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
	@Override
	/**
	 * Add new product
	 * @param : SanPham
	 * @return : int
	 */
	public int themSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		System.out.println("Hinh san pham : "+sanPham.getHinhsanpham());
		int maSanPham = sanPhamMapper.themSanPham(sanPham);
		return maSanPham;
	}
	@Override
	/**
	 * Delete product by id
	 * @param : int
	 * @return : boolean
	 */
	public boolean xoaSanPhamTheoMa(int maSanPham) {
		// TODO Auto-generated method stub
		try {
			sanPhamMapper.xoaSanPhamTheoMa(maSanPham);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	@Override
	/**
	 * Update info product
	 * @param : SanPham
	 * @return : boolean
	 */
	public boolean capNhatThongTinSanPham(SanPham sanPham) {
		// TODO Auto-generated method stub
		try {
			sanPhamMapper.capNhatThongTinSanPham(sanPham);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
	

}
