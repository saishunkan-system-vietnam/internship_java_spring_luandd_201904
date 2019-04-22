package com.dangducluan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.dangducluan.entities.SanPham;
import com.dangducluan.service.SanPhamService;

@Controller
@RequestMapping(path = "/sanpham")
public class SanPhamController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping(path = "/themsp")
	public String Default(ModelMap modelMap)
	{
		SanPham sanPham = new SanPham();
		modelMap.addAttribute("sanpham", sanPham);
		return "themSanPham";
	}
	@PostMapping(path = "/themsp")
	public String themSanPham(SanPham sanpham)
	{
		boolean ktThemSanPham = sanPhamService.themSanPhamMoi(sanpham);
		if(ktThemSanPham)
		{
			return "redirect:/";
		}
		return "redirect:/sanpham/themsp";
	}
	@GetMapping(path = "/suasp/{masanpham}")
	public String capnhatThongTinSanPhamGET(@PathVariable int masanpham, ModelMap modelMap)
	{
		SanPham sanPham = sanPhamService.layThongTinSanPhamTheoMa(masanpham);
		modelMap.addAttribute("sanpham", sanPham);
		return "themSanPham";
	}
	@PostMapping(path = "/suasp")
	public String capnhatThongTinSanPhamPOST(SanPham sanpham)
	{
		boolean ktCapNhatTT = sanPhamService.suaThongTinSanPhamTheoMa(sanpham);
		if(ktCapNhatTT) {
			return "redirect:/";
		}
		return "redirect:/sanpham/"+sanpham.getMasanpham();
	}
	@PostMapping(path = "/timsptheoten")
	public String timSanPhamTheoTen(@RequestParam String tensanpham,ModelMap modelMap)
	{
		List<SanPham> dsSanPhamTheoTen = sanPhamService.layDanhSachSanPhamTheoTen(tensanpham);
		modelMap.addAttribute("dsSanPham", dsSanPhamTheoTen);
		return "dsSanPhamTimKiem";
	}
	@PostMapping(path = "/timsptheokhoanggia")
	public String timSanPhamTheoKhoangGia(@RequestParam int khoanggiabatdau,@RequestParam int khoanggiaketthuc, ModelMap modelMap)
	{
		List<SanPham> dsSanPhamTheoGia = sanPhamService.layDanhSachSanPhamTheoKhoangGia(khoanggiabatdau, khoanggiaketthuc);
		modelMap.addAttribute("dsSanPham", dsSanPhamTheoGia);
		return "dsSanPhamTimKiem";
	}
	@PostMapping(path = "/timsptheosoluong")
	public String timSanPhamTheoSoLuong(@RequestParam int soluongbatdau, @RequestParam int soluongketthuc, ModelMap modelMap)
	{
		List<SanPham> dsSanPhamTheoSoLuong = sanPhamService.layDanhSachSanPhamTheoKhoangSoLuong(soluongbatdau,soluongketthuc);
		modelMap.addAttribute("dsSanPham", dsSanPhamTheoSoLuong);
		return "dsSanPhamTimKiem";
	}
}
