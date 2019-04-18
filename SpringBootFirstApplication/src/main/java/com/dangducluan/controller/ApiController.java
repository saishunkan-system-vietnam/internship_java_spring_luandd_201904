package com.dangducluan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dangducluan.entities.SanPham;
import com.dangducluan.service.SanPhamService;

@Controller
@RequestMapping(path = "/api")
public class ApiController {
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping(path = "/xoasanpham")
	@ResponseBody
	public String xoaSanPhamTheoMa(@RequestParam int maSanPham)
	{
		SanPham sanPham = new SanPham();
		sanPham.setMasanpham(maSanPham);
		boolean ktXoaSanPham = sanPhamService.xoaSanPhamTheoMa(sanPham);
		if(ktXoaSanPham) {
			return "true";
		}
		return "false";
	}
	
}
