$( document ).ready(function(){
	$("body").on("click",".btn-themchitiet",function(){
		var btnXoa = $(this).closest("div").find("button").hasClass("btn-xoachitiet");
		if(btnXoa == true){
			$(this).closest("div").find(".btn-xoachitiet").remove();
		}
		$(this).remove();
		var chitietclone = $("#chitietsanpham").clone().removeAttr("id");
		$("#container-chitietsanpham").append(chitietclone);
	});
	$("body").on("click",".btn-xoachitiet",function(){
		var chitiet = $(this).closest("div");
		var arrayThemChiTiet = $("#container-chitietsanpham").find(".themchitietsanpham");
		var lengthArr = arrayThemChiTiet.length - 2;
		$(chitiet).remove();
		if(lengthArr == 0){
			$(arrayThemChiTiet[lengthArr]).append('<button type="button" class="btn btn-success btn-themchitiet">Thêm</button>');
		}else{
			$(arrayThemChiTiet[lengthArr]).append('<button type="button" class="btn btn-success btn-themchitiet">Thêm</button>');
			$(arrayThemChiTiet[lengthArr]).append('&ensp;<button type="button" class="btn btn-danger btn-xoachitiet">Xóa</button>');
		}
	});
	$(".btn-themsanpham").click(function(){
		var formSanPham = $("#formsanpham").serializeArray();
		var dataSanPham = {};
		var madanhmuc = $("select[id='danhmuc']").val();
		var danhMucSanPham = {
				madanhmuc : madanhmuc
		};
		$.each(formSanPham,function(key,data){
			dataSanPham[data.name] = data.value;
			
		});
		dataSanPham["danhmucsanpham"] = danhMucSanPham;
		var arrayChiTietSanPham = [];
		$("#container-chitietsanpham > .themchitietsanpham").each(function(key,data){
			var objSizeSanPham = {};
			var objMauSanPham = {};
			var objChiTietSanPham = {}
			var mamau = $(this).find("select[name='mamau']").val();
			var masize = $(this).find("select[name='masize']").val();
			objSizeSanPham["masize"] = masize;
			objMauSanPham["mamau"] = mamau;
			objChiTietSanPham["sizeSanPham"] = objSizeSanPham;
			objChiTietSanPham["mauSanPham"] = objMauSanPham;
			arrayChiTietSanPham.push(objChiTietSanPham);
		});
		dataSanPham["dsChiTietSanPham"] = arrayChiTietSanPham;
		var strSanPham = JSON.stringify(dataSanPham);
		$.ajax({
			url : "/api/themsanpham",
			type : "POST",
			data : {
				sanpham : strSanPham
			},
			success : function(value){
				if(value == "true"){
					window.location.href = "/";
				}
			}
		});
	});
	$(".btn-xoasanpham").click(function(){
		var masp = $(this).attr("data-masp");
		$.ajax({
			url : "/api/xoasanpham",
			type : "GET",
			data : {
				masp : masp
			},
			success : function(value){
				if(value == "true"){
					alert("Xóa sản phẩm thành công !");
					window.location.href = "/";
				}
			}
		});
	});
	$(".btn-suasanpham").click(function(){
		var masp = $(this).attr("data-masp");
		var dataSanPham;
		$.ajax({
			url : "/api/laythongtinsanphamtheoid",
			type : "GET",
			data : {
				masp : masp
			},
			success : function(value){
				console.log(value.mota);
				$("#formsanpham").find("input[name='tensanpham']").val(value.tensanpham);
				$("#formsanpham").find("textarea[name='mota']").val(value.mota);
				$("#formsanpham").find("#danhmuc").val(value.danhmucsanpham.madanhmuc);
			}
		});
		$(this).attr("data-toggle","modal");
		$(this).attr("data-target","#myModal");
	});
});