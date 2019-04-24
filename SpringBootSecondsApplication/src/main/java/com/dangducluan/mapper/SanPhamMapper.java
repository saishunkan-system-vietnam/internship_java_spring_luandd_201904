package com.dangducluan.mapper;

import java.util.List;

import com.dangducluan.entities.SanPham;

public interface SanPhamMapper {
	public abstract List<SanPham> layTatCaSanPham();
	public abstract SanPham layThongTinSanPhamTheoMa(int maSanPham);
	public abstract int themSanPham(SanPham sanPham);
	public abstract boolean xoaSanPhamTheoMa(int maSanPham);
}
