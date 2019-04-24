package com.dangducluan.controller;

import java.io.IOException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dangducluan.entities.ChiTietSanPham;
import com.dangducluan.entities.SanPham;
import com.dangducluan.service.ChiTietSanPhamService;
import com.dangducluan.service.SanPhamService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping(path = "/api")
public class ApiController {
	
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	ChiTietSanPhamService chiTietSanPhamService;
	
	@PostMapping(path = "/themsanpham")
	@ResponseBody
	public String themSanPhamMoi(@RequestParam String sanpham)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			SanPham sanPham = objectMapper.readValue(sanpham,SanPham.class);
			int ktThemSanPham = sanPhamService.themSanPham(sanPham);
			Set<ChiTietSanPham> dsChiTietSanPham = sanPham.getDsChiTietSanPham();
			for(ChiTietSanPham chiTietSanPham : dsChiTietSanPham)
			{
				chiTietSanPham.setSanPham(sanPham);
				int maChiTietSp = chiTietSanPhamService.themThongTinChiTietSanPham(chiTietSanPham);
				if(maChiTietSp == 0) {
					return "false";
				}
			}
			if(ktThemSanPham != 0) {
				return "true";
			}
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "false";
	}
	@GetMapping(path = "/xoasanpham")
	@ResponseBody
	public String xoaSanPhamTheoMa(@RequestParam int masp) {
		boolean ktXoaChiTiet = chiTietSanPhamService.xoaThongTinChiTietSanPham(masp);
		if(ktXoaChiTiet) {
			boolean ktXoaSanPham = sanPhamService.xoaSanPhamTheoMa(masp);
			if(ktXoaSanPham) {
				return "true";
			}
		}
		return "false";
	}
	@GetMapping(path = "/laythongtinsanphamtheoid", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public SanPham layThongTinSanPhamTheoId(@RequestParam int masp) {
		SanPham sanPham = sanPhamService.layThongTinSanPhamTheoMa(masp);
		return sanPham;
	}
}
