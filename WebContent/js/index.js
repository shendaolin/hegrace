
var HegraceMap = function(){
	return {
		mapObj : null,
		markerJjrys : [],
		markerQjjls : [],
		alljjry:{},
		init : function() {
			var position = new AMap.LngLat(120.121082,30.230878);// 创建中心点坐标
			this.mapObj = new AMap.Map("page-content", {
				center : position,
				level : 17
			});// 创建地图实例
			this.mapObj.setFitView();
			this.getQjjlLngLatsInterval();
			this.getJjryLngLatsInterval();
		},
		
		getJjryLngLatsInterval : function(){
			
			var self = this;
			var getJjryLngLats = function(){
				
				$.get("getJjryLngLats.html", function(data){
					
					if(self.markerJjrys.length > 0){
						self.mapObj.remove(self.markerJjrys);
						self.markerJjrys = [];
					}
					self.alljjry = {};
					var rows = data.rows;
					$(rows).each(function(i, item){
				        var marker = new AMap.Marker({
				        	icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_b.png",
				            position:item.zb.split(",")
				        });
				        marker.setMap(self.mapObj);
				        self.alljjry[item.id] = {
				        		"position" : marker.getPosition(),
				        		"ryid" : item.ryid,
				        		"jlid" : item.jlid
				        };
				        self.markerJjrys.push(marker);
					});
					
				});
			}
			getJjryLngLats();
			setInterval(function() {
				getJjryLngLats();
			}, "60000");
		},
		
		getQjjlLngLatsInterval : function(){
			
			var self = this;
			var getQJJLLngLats = function(){
				
				if(self.markerQjjls.length > 0){
					self.mapObj.remove(self.markerQjjls);
					self.markerQjjls = [];
				}
				
				$.get("getQJJLLngLats.html", function(data){
					var rows = data.rows;
					var infoWindow = new AMap.InfoWindow({offset: new AMap.Pixel(0, -30)});
					$(rows).each(function(i, item){
						if(!item.zb) return;
				        var marker = new AMap.Marker({
				        	icon: "http://webapi.amap.com/theme/v1.3/markers/n/mark_r.png",
				            position:item.zb.split(",")
				        });
				        marker.on('click', function(e){
//				        	var content = "<div>参赛者："+item.xm+"("+item.dh+")</div>"
//				        	content += "<div>事件名称："+item.sjmc+"</div>"
//				        	content += "<div>事件描述："+item.ms+"</div>"
//				        	if(item.jjyxm){
//				        	var jjyxms = item.jjyxm.split("|");
//				        	var jjydhs = item.jjydh.split("|");
//				        	var jjyzts = item.jjyzt.split("|");
//				        	var ztStyle = {
//									"0" : "未接",
//									"1" : "已接",
//							}
//					        	$(jjyxms).each(function(i){
//					        		content += "<div>["+ztStyle[jjyzts[i]]+"]救护员："+jjyxms[i]+"("+jjydhs[i]+")</div>"
//					        	});
//				        	}
				            infoWindow.setContent(content);
				            infoWindow.open(self.mapObj, e.target.getPosition());
				        });
				        
				        if(!item.jjyxm){
					        var circle = new AMap.Circle({
					            center: item.zb.split(","),// 圆心位置
					            radius: 150, //半径
					            strokeColor: "#F33", //线颜色
					            strokeOpacity: 0.3, //线透明度
					            strokeWeight: 1, //线粗细度
					            fillColor: "#ee2200", //填充颜色
					            fillOpacity: 0//填充透明度
					        });
					        circle.setMap(self.mapObj);
					        self.markerQjjls.push(circle);
					        if(self.alljjry){
					        	$(self.alljjry).each(function(i, item){
					        		if(circle.contains(item.position)){
					        			
					        		}
					        	});
					        }
				        }
				        
				        marker.setMap(self.mapObj);
				        self.markerQjjls.push(marker);
				        
					});
					
				});
			}
			setInterval(function() {
				getQJJLLngLats();
			}, "10000");
		}
	}
}();

var Processing = function() {

	return {
		countDown : 0,
		// main function to initiate the module
		init : function() {
			var self = this;
			self.loadCountInterval();
			self.countDownInterval();
			self.processingLoad();

			var dropdownCustom = $("#processing").find(
					"[data-toggle=dropdownCustom]");
			var menu = $("#processing").find(".dropdown-menu");
			dropdownCustom.on("click", function() {
				if ($(menu).is(":hidden")) {
					$("#hegraceMapTools").find(".dropdown-menu").hide();
					$(menu).show();
					if (self.countDown > 0) {
						return;
					}
					// 30秒以内再次打开不进行查询；
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

			$("#processingFlexigrid")
					.flexigrid(
							{
								url : "processing.html",
								dataType : 'json',
								colModel : [
										{
											display : '操作',
											width : 60,
											name : "option",
											align : 'center'
										}, {
											display : '参赛者姓名',
											name : 'xm',
											width : 60,
											align : 'center'
										}, {
											display : '参赛者电话',
											name : 'dh',
											width : 80,
											align : 'center'
										}, {
											display : '参赛者编号',
											name : 'bh',
											width : 60,
											align : 'center'
										}, {
											display : '事件',
											name : 'sjmc',
											width : 100,
											align : 'center'
										}, {
											display : '发生时间',
											name : 'xgsj',
											width : 120,
											align : 'center'
										}, {
											display : '急救员分配',
											width : 300,
											name : 'jjyfp',
											align : 'left'
										} ],
								usepager : true,
								useRp : false,
								rp : 5,
								width : 700,
								height : 200,
								onToggleCol : true,
								onSuccess : function() {
									$("#processingFlexigrid").each(
											function() {
												$("#processing").find(".badge")
														.text(this.p.total);
											})
								},
								preProcess : function(date) {
									var rows = date.rows;
									$(rows)
											.each(
													function(i, row) {
														var buttons = "";
														var options = "";
														var jjyxms = row.jjyxm
																.split("|");
														var jjydhs = row.jjydh
																.split("|");
														var bhmss = row.bhms
																.split("|");
														var jjyzts = row.jjyzt
																.split("|");
														var clmss = row.clms
																.split("|");
														var ztStyle = {
															"0" : "",
															"1" : "yellow",
															"2" : "red",
															"3" : "green"
														}
														if (row.jjyzt) {
															$(jjyzts)
																	.each(
																			function(
																					i) {
																				buttons += "<a href=\"javascript:;\" class=\"btn "
																						+ ztStyle[jjyzts[i]]
																						+ " mini\" title=\"电话："
																						+ jjydhs[i];

																				if (jjyzts[i] == "2") {
																					buttons += "&#10;驳回描述："
																							+ bhmss[i];
																				}

																				if (jjyzts[i] == "3") {
																					buttons += "&#10;处理描述："
																							+ clmss[i];
																				}

																				buttons += "\">"
																						+ jjyxms[i]
																						+ "</a> ";
																				
																				
																			});
														}
														row["jjyfp"] = buttons;
														
														options = "<a href=\"javascript:;\" class=\"btn {optionsStyle} mini\" onclick=\"Processing.{method}('"+row["id"]+"')\">{optionsStyleText}</a>";
														if(row["zt"] == "3"){
															options = options.replace("{optionsStyle}", "green");
															options = options.replace("{optionsStyleText}", "关闭");
															options = options.replace("{method}", "close");
														}else{
															options = options.replace("{optionsStyle}", "red");
															options = options.replace("{optionsStyleText}", "取消");
															options = options.replace("{method}", "cancel");
														}
														row["option"] = options;
													});
									return date
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

var Processed = function() {

	return {
		countDown : 0,
		// main function to initiate the module
		init : function() {
			var self = this;
			self.loadCountInterval();
			self.countDownInterval();
			self.processedLoad();

			var dropdownCustom = $("#processed").find(
					"[data-toggle=dropdownCustom]");
			var menu = $("#processed").find(".dropdown-menu");
			dropdownCustom.on("click", function() {
				if ($(menu).is(":hidden")) {
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
			jQuery.get("processedCount.html", function(date) {
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
								url : "processed.html",
								dataType : 'json',
								colModel : [ {
									display : '参赛者姓名',
									name : 'xm',
									width : 60,
									align : 'center'
								}, {
									display : '参赛者电话',
									name : 'dh',
									width : 80,
									align : 'center'
								}, {
									display : '参赛者编号',
									name : 'bh',
									width : 60,
									align : 'center'
								}, {
									display : '事件',
									name : 'sjmc',
									width : 100,
									align : 'center'
								}, {
									display : '发生时间',
									name : 'xgsj',
									width : 120,
									align : 'center'
								}, {
									display : '处理描述',
									width : 200,
									name : 'clms',
									align : 'left'
								} ],
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
								},
								preProcess : function(date) {
									var rows = date.rows;
									$(rows)
											.each(
													function(i, row) {
														var buttons = "";
														var jjyxms = row.jjyxm
																.split("|");
														var jjydhs = row.jjydh
																.split("|");
														var clmss = row.clms
																.split("|");
														$(jjyxms)
																.each(
																		function(
																				i) {
																			buttons += "<a href=\"javascript:;\" class=\"btn green mini\" title=\"电话："
																					+ jjydhs[i]
																					+ "&#10;描述："
																					+ clmss[i]
																					+ "\">"
																					+ jjyxms[i]
																					+ "</a> "
																		});
														row["clms"] = buttons;
													});
									return date
								}
							});

		}

	};

}();

var Nquipment = function() {

	return {
		init : function() {
			this.nquipmentLoad();
			var dropdownCustom = $("#equipment").find(
					"[data-toggle=dropdownCustom]");
			var menu = $("#equipment").find(".dropdown-menu")
			dropdownCustom.on("click", function() {
				if ($(menu).is(":hidden")) {
					$("#hegraceMapTools").find(".dropdown-menu").hide();
					$(menu).show();
				} else {
					$(menu).hide();
				}
			})
		},
		nquipmentLoad : function() {

			$("#nquipmentFlexigrid").flexigrid({
				url : "nquipment.html",
				dataType : 'json',
				colModel : [ {
					display : '设备类型',
					name : 'sblx',
					width : 80,
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

var NoSignIn = function() {

	return {
		countDown : 0,
		// main function to initiate the module
		init : function() {

			var self = this;
			self.loadCountInterval();
			self.countDownInterval();
			self.noSignInLoad();

			var dropdownCustom = $("#noSignIn").find(
					"[data-toggle=dropdownCustom]");
			var menu = $("#noSignIn").find(".dropdown-menu");
			dropdownCustom.on("click", function() {
				if ($(menu).is(":hidden")) {
					$("#hegraceMapTools").find(".dropdown-menu").hide();
					$(menu).show();
					if (self.countDown > 0) {
						return;
					}
					// 30秒以内再次打开不进行查询；
					self.countDown = 30;
					self.noSignInReLoad();
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
			self.noSignInCount();
			setInterval(function() {
				self.noSignInCount();
			}, "60000");
		},

		noSignInCount : function() {
			jQuery.get("noSignInCount.html", function(date) {
				$("#noSignIn").find(".badge").text(date.total);
			});
		},

		noSignInReLoad : function() {
			this.noSignInCount();
			$("#noSignInFlexigrid").flexOptions({
				newp : 1
			}).flexReload();
		},

		noSignInLoad : function() {

			$("#noSignInFlexigrid").flexigrid({
				url : "noSignIn.html",
				dataType : 'json',
				colModel : [ {
					display : '姓名',
					name : 'xm',
					width : 80,
					align : 'center'
				}, {
					display : '性别',
					name : 'xb',
					width : 50,
					align : 'center'
				}, {
					display : '电话',
					name : 'dh',
					width : 100,
					align : 'center'
				}, {
					display : '身份类型',
					name : 'sflx',
					width : 100,
					align : 'center'
				}, {
					display : '类别',
					name : 'lb',
					width : 100,
					align : 'center'
				} ],
				usepager : true,
				useRp : false,
				rp : 5,
				width : 500,
				height : 200,
				onSuccess : function() {
					$("#noSignInFlexigrid").each(function() {
						$("#noSignIn").find(".badge").text(this.p.total);
					})
				},
				preProcess : function(date) {
					var rows = date.rows;
					$(rows).each(function(i, row) {
						var xb = row["xb"];
						row["xb"] = xb == 1 ? "男" : "女";
					});
					return date
				}
			});

		}

	};

}();
