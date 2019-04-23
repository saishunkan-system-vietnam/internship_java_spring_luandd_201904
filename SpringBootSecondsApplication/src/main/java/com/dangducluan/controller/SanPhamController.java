package com.dangducluan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dangducluan.entities.SanPham;
import com.dangducluan.service.SanPhamService;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
	@Autowired
	SanPhamService sanPhamService;
	@GetMapping("/chitietsanpham/{masanpham}")
	public String chiTietSanPham(@PathVariable int masanpham, ModelMap modelMap)
	{
		SanPham sanPham = sanPhamService.layThongTinSanPhamTheoMa(masanpham);
		modelMap.addAttribute("sanPham", sanPham);
		return "chitiet";
	}
}
