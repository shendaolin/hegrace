/**
 * 
 */


var Processing = function() {

	return {
		dropdownCustom : null,
		countDown : 0,
		// main function to initiate the module
		init : function() {
			var self = this;
			self.loadCountInterval();
			self.countDownInterval();
			self.processingLoad();

			dropdownCustom = $("#processing").find("[data-toggle=dropdownCustom]");
			var menu = $("#processing").find(".dropdown-menu");
			dropdownCustom.on("click", function() {
				if ($(menu).is(":hidden")) {
					HegraceMap.infoWindow && HegraceMap.infoWindow.close();
					$("#hegraceMapTools").find(".dropdown-menu").hide();
					$(menu).show();
					if (self.countDown > 0) {
						return;
					}
					// 30秒以内再次打开不进行查询；
					HegraceMap.getQJJLLngLats();
					self.countDown = 30;
					self.processingReLoad();
				} else {
					$(menu).hide();
				}
			})
		},

		countDownInterval : function() {
			var self = this;
			var int = setInterval(function() {
				if (self.countDown == 0) {
					return;
				}
				self.countDown--;
			}, "1000");

		},

		loadCountInterval : function() {
			var self = this;
			self.processingCount();
			setInterval(function() {
				self.processingCount();
			}, "60000");
		},

		processingCount : function() {
			jQuery.get("processingCount.html", function(date) {
				$("#processing").find(".badge").text(date.total);
			});
		},

		processingReLoad : function() {
			this.processingCount();
			$("#processingFlexigrid").flexOptions({
				newp : 1
			}).flexReload();
		},

		processingLoad : function() {
			var self = this;
			$("#processingFlexigrid")
					.flexigrid(
							{
								url : "processing.html",
								dataType : 'json',
								colModel : [{
											display : '操作',
											width : 80,
											align : 'center',
											operation : function(tdDiv, row){
												$(tdDiv).html("").append($("<a href=\"#\" class=\"btn mini red\"><i class=\"icon-info\"></i>查看</a>").on("click",function(){
													var markers = HegraceMap.allqjjl;
													HegraceMap.mapObj.setCenter(markers[row.id].marker.getPosition())
													$("#processing").find("[data-toggle=dropdownCustom]").trigger("click");
													AMap.event.trigger(markers[row.id].marker,"click")
												}));
											}
										},{
											display : '参赛者姓名',
											name : 'xm',
											width : 80,
											align : 'center'
										}, {
											display : '参赛者电话',
											name : 'dh',
											width : 100,
											align : 'center'
										}, {
											display : '参赛者编号',
											name : 'bh',
											width : 60,
											align : 'center'
										}, {
											display : '事件',
											name : 'sjmc',
											width : 120,
											align : 'center'
										}, {
											display : '发生时间',
											name : 'xgsj',
											width : 120,
											align : 'center'
										}],
								usepager : true,
								useRp : false,
								rp : 5,
								width : 700,
								height : 200,
								onToggleCol : true,
								onSuccess : function() {
									$("#processingFlexigrid").each(function() {
											$("#processing").find(".badge").text(this.p.total);
									})
								},
								onDoubleClick:function(flexigrid, g, p){
									
								}
							});

		},
		
		cancel : function(id){
			alert(1)
		},
		
		close : function(id){
			alert(2)
		}

	};

}();
