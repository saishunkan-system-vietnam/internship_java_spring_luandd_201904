package com.dangducluan.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dangducluan.daoimp.SanPhamImp;
import com.dangducluan.entities.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	/***
	 * Get list sanpham from dabatase
	 * Return List<SanPham>
	 */
	public List<SanPham> layDanhSachSanPham() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> dsSanPham = session.createQuery("from sanpham").getResultList();
		return dsSanPham;
	}
	@Transactional
	@Override
	/**
	 * Edit info product
	 * Param : SanPham maSanPham
	 * Return void
	 */
	public boolean suaThongTinSanPhamTheoMa(SanPham sanPham) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			session.update(sanPham);
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	@Transactional
	@Override
	/**
	 * Delete product using id
	 * Param : SanPham sanPham
	 * Return void
	 */
	public boolean xoaSanPhamTheoMa(SanPham sanPham) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			session.delete(sanPham);
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	@Transactional
	@Override
	/**
	 * Add new product
	 * Param : SanPham sanPham
	 * Return boolean
	 */
	public boolean themSanPhamMoi(SanPham sanPham) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		int kt = (int) session.save(sanPham);
		if(kt > 0) {
			return true;
		}
		return false;
	}
	@Transactional
	@Override
	/**
	 * Get info product
	 * Param : int maSanPham
	 * Return SanPham
	 */
	public SanPham layThongTinSanPhamTheoMa(int maSanPham) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		SanPham sanPham = session.get(SanPham.class,maSanPham);
		return sanPham;
	}
	@Transactional
	@Override
	/**
	 * Search list data product using condition
	 * Param : String tenSanPham
	 * Return : List<SanPham>
	 */
	public List<SanPham> layDanhSachSanPhamTheoTen(String tenSanPham) {
		// TODO Auto-generated method stub
		Session sesion = sessionFactory.getCurrentSession();
		String query = "from sanpham where tensanpham LIKE '%"+tenSanPham+"%'";
		List<SanPham> dsSanPhamTheoTen = sesion.createQuery(query).getResultList();
		return dsSanPhamTheoTen;
	}
	@Override
	public List<SanPham> layDanhSachSanPhamTheoKhoangGia(int giaSanPham) {
		// TODO Auto-generated method stub
		return null;
	}

}
