$(document).ready(function() {
	$(".btn-xoasanpham").click(function(){
		swal({
			  title: "Bạn có chắc chắn muốn xóa sản phẩm này không ?",
			  text: "Lưu ý : Sản phẩm bị xóa bỏ sẽ không thể khôi phục",
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
				var masanpham = $(this).attr("data-masanpham");
				$.ajax({
					url : "/api/xoasanpham",
					type : "GET",
					data : {
						maSanPham : masanpham
					},
					success : function(value){
						if(value == "true"){
							swal("Xóa sản phẩm thành công !", {
							      icon: "success",
							});
						}else{
							swal("Đã xảy ra lỗi trong khi xóa vui lòng thử lại !", {
							      icon: "error",
							});
							
						}
					}
				}).done(function(){
					window.location = "/";
				});
			  }
		});
	});
	$.validator.addMethod('minStrict', function (value, el, param) {
		console.log('value : ',value);
		console.log('param : ',param);
	    return value > param;
	});
	$("#formSanPham").validate({
		rules:{
			tensanpham : {
				required : true
			},
			giatien : {
				required : true,
				digits : true,
				minStrict : 0
			},
			soluong : {
				required : true,
				digits : true,
				minStrict : 0
			}
		},messages:{
			tensanpham : {
				required : "Vui lòng nhập tên sản phẩm"
			},
			giatien : {
				required : "Vui lòng nhập giá tiền sản phẩm",
				digits : "Bạn vừa nhập giá tền không hợp lệ, vui lòng thử lại",
				minStrict : "Số tiền bạn vừa nhập nhỏ hơn 0, vui lòng thử lại"
			},
			soluong : {
				required : "Vui lòng nhập số lượng sản phẩm",
				digits : "Bạn vừa nhập số lượng không hợp lệ, vui lòng thử lại",
				minStrict : "Số lượng bạn vừa nhập nhỏ hơn 0, vui lòng thử lại"
			}
		}
	});
//	$("#formTimKiemSp").validate({
//		rules : {
//			giaBatDau : {
//				digits : true,
//				minStrict : 0
//			},
//			giaKetThuc : {
//				digits : true,
//				minStrict : 0
//			},
//			soLuongBatDau : {
//				digits : true,
//				minStrict : 0
//			},
//			soLuongKetThuc : {
//				digits : true,
//				minStrict : 0
//			}
//		},
//		messages : {
//			giaBatDau : {
//				digits : "Số giá tiền bạn nhập không hợp lệ",
//				minStrict : "Số giá tiền bạn nhập không hợp lệ"
//			},
//			giaKetThuc : {
//				digits : "Số giá tiền bạn nhập không hợp lệ",
//				minStrict : "Số giá tiền bạn nhập không hợp lệ"
//			},
//			soLuongBatDau : {
//				digits : "Số lượng bạn nhập không hợp lệ, vui lòng thử lại",
//				minStrict : "Số lượng bạn nhập không hợp lệ, vui lòng thử lại"
//			},
//			soLuongKetThuc : {
//				digits : "Số lượng bạn nhập không hợp lệ, vui lòng thử lại",
//				minStrict : "Số lượng bạn nhập không hợp lệ, vui lòng thử lại"
//			},
//		}
//		
//	});
	function formatCurrency()
	{
		$("td.giatien").each(function(key,value){
			var currency = $(value).text();
			var newCurrency = currency.replace(/(\d)(?=(\d\d\d)+(?!\d))/g, "$1,");
			$(value).text(newCurrency);
		});
	}
	formatCurrency();
});