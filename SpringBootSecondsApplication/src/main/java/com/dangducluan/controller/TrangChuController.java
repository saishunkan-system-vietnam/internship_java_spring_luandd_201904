package com.dangducluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dangducluan.entities.DanhMucSanPham;
import com.dangducluan.entities.MauSanPham;
import com.dangducluan.entities.SanPham;
import com.dangducluan.entities.SizeSanPham;
import com.dangducluan.service.DanhMucSanPhamService;
import com.dangducluan.service.MauSanPhamService;
import com.dangducluan.service.SanPhamService;
import com.dangducluan.service.SizeSanPhamService;

@Controller
@RequestMapping(path = "/")
public class TrangChuController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	
	@Autowired
	MauSanPhamService mauSanPhamService;
	
	@Autowired
	SizeSanPhamService sizeSanPhamService;
	@GetMapping
	public String Default(ModelMap modelMap)
	{
		List<SanPham> dsSanPham = sanPhamService.layTatCaSanPham();
		List<DanhMucSanPham> dsDanhMuc = danhMucSanPhamService.layToanBoDanhMucSanPham();
		List<MauSanPham> dsMau = mauSanPhamService.layDanhSachMauSanPham();
		List<SizeSanPham> dsSize = sizeSanPhamService.layDanhSachSizeSanPham();
		modelMap.addAttribute("dsSanPham",dsSanPham);
		modelMap.addAttribute("dsDanhMuc", dsDanhMuc);
		modelMap.addAttribute("dsMau", dsMau);
		modelMap.addAttribute("dsSize", dsSize);
		return "trangchu";
	}
}
