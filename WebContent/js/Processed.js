/**
 * 
 */

var Processed = function() {

	return {
		countDown : 0,
		// main function to initiate the module
		init : function() {
			var self = this;
			self.loadCountInterval();
			self.countDownInterval();
			self.processedLoad();

			var dropdownCustom = $("#processed").find("[data-toggle=dropdownCustom]");
			var menu = $("#processed").find(".dropdown-menu");
			dropdownCustom.on("click", function() {
				if ($(menu).is(":hidden")) {
					HegraceMap.infoWindow && HegraceMap.infoWindow.close();
					$("#hegraceMapTools").find(".dropdown-menu").hide();
					$(menu).show();
					if (self.countDown > 0) {
						return;
					}
					// 30秒以内再次打开不进行查询；
					self.countDown = 30;
					self.processedReLoad();
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
			self.processedCount();
			setInterval(function() {
				self.processedCount();
			}, "60000");
		},

		processedCount : function() {
			jQuery.get("processedCount.htm", function(date) {
				$("#processed").find(".badge").text(date.total);
			});
		},

		processedReLoad : function() {
			this.processedCount();
			$("#processedFlexigrid").flexOptions({
				newp : 1
			}).flexReload();
		},

		processedLoad : function() {

			$("#processedFlexigrid")
					.flexigrid(
							{
								url : "processed.htm",
								dataType : 'json',
								colModel : [ {
									display : '操作',
									width : 80,
									align : 'center',
									operation : function(tdDiv, row){
										$(tdDiv).html("").append($("<a href=\"#\" class=\"btn mini red\"><i class=\"icon-info\"></i>查看</a>").on("click",function(){
										
											var content = "";
								        	$.get("getQJJLInfomation.htm", {"qjid" : row.id}, function(list){
									        		var ztStyle = {
															"0" : "未接受",
															"1" : "已接受",
															"2" : "已驳回",
															"3" : "已处理"
													}
								        			$.each(list.rows, function(key, xtQjjlDto){
								        				if(key == 0){
								        					content += "<div>参赛者："+xtQjjlDto.xm+"("+xtQjjlDto.dh+")</div>"
								        					content += "<div>事件名称："+xtQjjlDto.sjmc+"</div>"
								        					content += "<div>事件描述："+xtQjjlDto.ms+"</div>"
								        					content += "<br/>";
								        				}
								        				if(xtQjjlDto.jjyxm){
								        					content += "<div>["+ztStyle[xtQjjlDto.jjyzt]+"]救护员："+xtQjjlDto.jjyxm+"("+xtQjjlDto.jjydh+")</div>"
								        				}
								        			});
									        		$("#processed").find("[data-toggle=dropdownCustom]").trigger("click");
									        		content += "<br/><div>";
									        		content += " <a href=\"#\" class=\"btn blue mini\">查看详细</a>";
									        		content += "</div>"
									        		HegraceMap.infoWindow.setContent(content);
									        		HegraceMap.infoWindow.open(HegraceMap.mapObj, row.zb.split(","));
								        	})
											
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
									$("#processedFlexigrid").each(
											function() {
												$("#processed").find(".badge")
														.text(this.p.total);
											})
								}
							});

		}

	};

}();
