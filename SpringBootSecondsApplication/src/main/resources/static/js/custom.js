$( document ).ready(function(){
	var luuTenHinhGoc = "";
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
		$("#formsanpham").validate({
			rules : {
				tensanpham : "required",
				mota : "required"
			},messages : {
				tensanpham : "Bạn chưa nhập tên sản phẩm, vui lòng thử lại"
				,mota : "Bạn chưa nhập mô tả sản phẩm, vui lòng thử lại"
			}
		});
		if($("#formsanpham").valid()){
			var form = $('form')[0];
			var formData = new FormData(form);
			$.ajax({
				url : "/api/uploadhinhsanpham",
				type : "POST",
				data : formData,
				contentType : false,
				processData : false,
				enctype: "multipart/form-data",
				success : function(value){
					
				}
			});
			var formSanPham = $("#formsanpham").serializeArray();
			var dataSanPham = {};
			var madanhmuc = $("select[id='danhmuc']").val();
			var hinhsanpham = $("input[type='file']").val().split('\\').pop();
			var danhMucSanPham = {
					madanhmuc : madanhmuc
			};
			$.each(formSanPham,function(key,data){
				if(data.name == 'tensanpham' || data.name == 'mota'){
					dataSanPham[data.name] = data.value;
				}
			});
			dataSanPham["danhmucsanpham"] = danhMucSanPham;
			dataSanPham["hinhsanpham"] = hinhsanpham;
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
		}
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
		luuTenHinhGoc = $(this).closest("tr").find("img").attr("data-hinhsp");
		$.ajax({
			url : "/api/laythongtinsanphamtheoid",
			type : "GET",
			data : {
				masp : masp
			},
			success : function(value){
				$("#container-chitietsanpham").empty();
				$("#formsanpham").find("input[name='tensanpham']").val(value.tensanpham);
				$("#formsanpham").find("input[name='tensanpham']").attr("data-masp",value.masanpham);
				$("#formsanpham").find("textarea[name='mota']").val(value.mota);
				$("#formsanpham").find("#danhmuc").val(value.danhmucsanpham.madanhmuc);
				var countChiTiet = value.dsChiTietSanPham.length;
				for(var i = 0; i < countChiTiet; i++){
					var cloneChiTietSp = $("#chitietsanpham").clone().removeAttr("id");
					cloneChiTietSp.find("button").remove();
					cloneChiTietSp.find("#mamau").val(value.dsChiTietSanPham[i].mauSanPham.mamau);
					cloneChiTietSp.find("#masize").val(value.dsChiTietSanPham[i].sizeSanPham.masize);
					$("#container-chitietsanpham").append(cloneChiTietSp);
				}
				$(".modal-footer").find("button").remove();
				$(".modal-footer").append('<button type="button" class="btn btn btn-info btn-capnhatsanpham">Cập nhật</button>');
				$(".modal-footer").append('<button type="button" class="btn btn-default btn-huyform" data-dismiss="modal">Đóng</button>');
			}
		});
	});
	$("body").on("click",".btn-huyform",function(){
		$("#container-chitietsanpham").empty();
		var cloneChiTietSp = $("#chitietsanpham").clone().removeAttr("id");
		$("#container-chitietsanpham").append(cloneChiTietSp);
	});
	$("body").on("click",".btn-capnhatsanpham",function(){
		var form = $('form')[0];
		var formData = new FormData(form);
		$.ajax({
			url : "/api/uploadhinhsanpham",
			type : "POST",
			data : formData,
			contentType : false,
			processData : false,
			enctype: "multipart/form-data",
			success : function(value){
				
			}
		});
		var dataForm = $("#formsanpham").serializeArray();
		var masanpham = $("#formsanpham").find("input[name='tensanpham']").attr('data-masp');
		var hinhsanpham = $("input[type='file']").val().split('\\').pop();
		var dataSanPham = {};
		var danhmuc = {};
		if(hinhsanpham == ''){
			dataSanPham['hinhsanpham'] = luuTenHinhGoc;
		}else{
			dataSanPham['hinhsanpham'] = hinhsanpham;
		}
		dataSanPham['masanpham'] = masanpham;
		var dsChiTietSanPham = [];
		$.each(dataForm,function(key,data){
			if(data.name == 'tensanpham' || data.name == 'mota'){
				dataSanPham[data.name] = data.value;
			}
			if(data.name == 'madanhmuc'){
				danhmuc[data.name] = data.value;
				dataSanPham['danhmucsanpham'] = danhmuc;
			}
		});
		$("#container-chitietsanpham > .themchitietsanpham").each(function(key,data){
			var sizeSanPham = {};
			var mauSanPham = {};
			var chiTietSanPham = {};
			var mamau = $(data).find('#mamau').val();
			var masize = $(data).find('#masize').val();
			sizeSanPham['masize'] = masize;
			mauSanPham['mamau'] = mamau;
			chiTietSanPham['sizeSanPham'] = sizeSanPham;
			chiTietSanPham['mauSanPham'] = mauSanPham;
			dsChiTietSanPham.push(chiTietSanPham);
		});
		dataSanPham['dsChiTietSanPham'] = dsChiTietSanPham;
		var strDataSp = JSON.stringify(dataSanPham);
		var strSanPham = JSON.stringify(dataSanPham);
		$.ajax({
			url : "/api/capnhatthongtinsanpham",
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
	$("#btn-themsp").click(function(){
		$("#formsanpham").find("#tensanpham-error").remove();
		$("#formsanpham").find("#mota-error").remove();
		$("#formsanpham").find("input[name='tensanpham']").removeClass('error');
		$("#formsanpham").find("textarea[name='mota']").removeClass('error');
		$("#formsanpham").find("input[name='tensanpham']").val("");
		$("#formsanpham").find("textarea[name='mota']").val("");
	});


});