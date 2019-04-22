package com.dangducluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dangducluan.entities.SanPham;
import com.dangducluan.service.SanPhamService;

@Controller
@RequestMapping(path = "/")
public class TrangChuController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping
	public String Default(ModelMap modelMap)
	{
		List<SanPham> dsSanPham = sanPhamService.layDanhSachSanPham();
		modelMap.addAttribute("dsSanPham", dsSanPham);
		return "dsSanPham";
	}
	
}
