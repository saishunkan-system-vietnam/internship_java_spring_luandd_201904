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

import com.dangducluan.entities.SanPham;
import com.dangducluan.form.TimSanPham;
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
	@PostMapping(path = "/timsptheotieuchi")
	public String timSanPhamTheoTieuChi(TimSanPham timSanPham,ModelMap modelMap)
	{
		String tenSanPham = timSanPham.getTenSanPham();
		int giaBD = timSanPham.getGiaBatDau();
		int giaKT = timSanPham.getGiaKetThuc();
		int soLuongBD = timSanPham.getSoLuongBatDau();
		int soLuongKT = timSanPham.getSoLuongKetThuc();
		System.out.println("so luong bd : "+soLuongBD);
		System.out.println("so luong kt : "+soLuongKT);
		List<SanPham> dsSanPham = null;
		if(!tenSanPham.trim().isEmpty())
		{
			dsSanPham = sanPhamService.layDanhSachSanPhamTheoTen(tenSanPham);
		}
		if(giaBD != 0 && giaKT != 0) {
			dsSanPham = sanPhamService.layDanhSachSanPhamTheoGia(giaBD, giaKT);
		}
		if(soLuongBD != 0 && soLuongKT != 0) {
			dsSanPham = sanPhamService.layDanhSachSanPhamTheoSoLuong(soLuongBD, soLuongKT);
		}
		modelMap.addAttribute("dsSanPham",dsSanPham);
		return "dsSanPhamTimKiem";
	}
	
}
