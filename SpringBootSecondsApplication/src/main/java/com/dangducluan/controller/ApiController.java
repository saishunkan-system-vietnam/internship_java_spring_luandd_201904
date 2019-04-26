package com.dangducluan.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	@Autowired
	ServletContext servletContext;
	@PostMapping(path = "/themsanpham")
	@ResponseBody
	public String themSanPhamMoi(@RequestParam String sanpham)
	{
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			SanPham sanPham = objectMapper.readValue(sanpham,SanPham.class);
			System.out.println("Hin san pham : "+sanPham.getHinhsanpham());
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
	
	@PostMapping(path = "/capnhatthongtinsanpham")
	@ResponseBody
	public String capNhatThongTinSanPham(@RequestParam String sanpham) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			SanPham sanPham = objectMapper.readValue(sanpham, SanPham.class);
			SanPham sanPham2 = layThongTinSanPhamTheoId(sanPham.getMasanpham()); 
			Set<ChiTietSanPham> chiTietSanPhams = sanPham.getDsChiTietSanPham();
			Set<ChiTietSanPham> chiTietSanPhams2 = sanPham2.getDsChiTietSanPham();
			int []arrayMaChiTiet = new int[chiTietSanPhams2.size()];
			int i = 0;
			for(ChiTietSanPham chiTietSanPham2 : chiTietSanPhams2) {
				int machitiet = chiTietSanPham2.getMaChiTietSanPham();
				arrayMaChiTiet[i] = machitiet;
				i++;
			}
			i = 0;
			for(ChiTietSanPham chiTietSanPham : chiTietSanPhams ) {
				int machitiet = arrayMaChiTiet[i];
				chiTietSanPham.setMaChiTietSanPham(machitiet);
				chiTietSanPham.setSanPham(sanPham);
				boolean ktCapNhatChiTiet = chiTietSanPhamService.capNhatThongTinChiTietSanPham(chiTietSanPham);
				if(!ktCapNhatChiTiet) {
					return "false";
				}
				i++;
			}
			boolean ktCapNhapSp = sanPhamService.capNhatThongTinSanPham(sanPham);
			if(ktCapNhapSp) {
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
	@PostMapping(path = "/uploadhinhsanpham")
	@ResponseBody
	public String uploadHinhSanPham(@RequestParam MultipartFile[] hinhsanpham) {
		
		for(int i = 0; i < hinhsanpham.length; i++) {
			MultipartFile multipartFile = hinhsanpham[i];
			String pathSave = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\image\\sanpham";
			String nameFile = multipartFile.getOriginalFilename();
			if(nameFile.equals("")) {
				continue;
			}
			File file = new File(pathSave,nameFile);
			try {
				multipartFile.transferTo(file);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "false";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "false";
			}
		}
		return "true";
	}
}
