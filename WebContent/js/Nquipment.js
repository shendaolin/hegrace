/**
 * 
 */


var Nquipment = function() {

	return {
		init : function() {
			this.nquipmentLoad();
			var dropdownCustom = $("#equipment").find(
					"[data-toggle=dropdownCustom]");
			var menu = $("#equipment").find(".dropdown-menu")
			dropdownCustom.on("click", function() {
				if ($(menu).is(":hidden")) {
					HegraceMap.infoWindow && HegraceMap.infoWindow.close();
					$("#hegraceMapTools").find(".dropdown-menu").hide();
					$(menu).show();
				} else {
					$(menu).hide();
				}
			})
		},
		nquipmentLoad : function() {

			$("#nquipmentFlexigrid").flexigrid({
				url : "nquipment.htm",
				dataType : 'json',
				colModel : [ {
					display : '设备类型',
					name : 'sblx',
					width : 120,
					align : 'center'
				}, {
					display : '设备编号',
					name : 'sbbh',
					width : 80,
					align : 'center'
				}, {
					display : '姓名',
					name : 'xm',
					width : 80,
					align : 'center'
				}, {
					display : '电话',
					name : 'dh',
					width : 100,
					align : 'center'
				} ],
				usepager : true,
				useRp : false,
				rp : 5,
				width : 500,
				height : 200
			});

		}
	};

}();