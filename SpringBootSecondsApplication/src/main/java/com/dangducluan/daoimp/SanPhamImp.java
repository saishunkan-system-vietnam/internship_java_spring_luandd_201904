package com.dangducluan.daoimp;
import java.util.List;

import com.dangducluan.entities.*;
public interface SanPhamImp {
	public abstract List<SanPham> layTatCaSanPham();
	public abstract SanPham layThongTinSanPhamTheoMa(int maSanPham);
	public abstract int themSanPham(SanPham sanPham);
	public abstract boolean xoaSanPhamTheoMa(int maSanPham);
	public abstract boolean capNhatThongTinSanPham(SanPham sanPham);
}
