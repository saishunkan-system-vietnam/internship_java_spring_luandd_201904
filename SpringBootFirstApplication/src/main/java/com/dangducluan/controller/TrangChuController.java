package com.dangducluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dangducluan.entities.SanPham;
import com.dangducluan.form.TimSanPham;
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
		TimSanPham timSanPham = new TimSanPham();
		modelMap.addAttribute("dsSanPham", dsSanPham);
		modelMap.addAttribute("timSanPham", timSanPham);
		return "dsSanPham";
	}
	
}
