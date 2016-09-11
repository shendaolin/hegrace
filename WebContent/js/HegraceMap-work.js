var HegraceMap = function() {
	return {
		mapObj : null,
		infoWindow : null,
		markerJjrys : [],
		markerQjjls : [],
		alljjry : {},
		allqjjl : {},
		init : function(sslj, fpq) {
			var self = this;
			this.mapObj = new AMap.Map("page-content", {
				level : 17
			});
			if (sslj) {
				var pathArry = new Array();
				var paths = sslj.split(";");
				$(paths).each(function(i, path) {
					pathArry.push(path.split(","))
				});
				var polyline = new AMap.Polyline({
					path : pathArry
				});
				polyline.setMap(this.mapObj);
			}

			$.get("getGwLngLats.htm", function(data) {
				$(data.rows).each(function(i, item) {
					var marker = new AMap.Marker({
						icon : "media/image/" + item.img,
						position : item.dw.split(",")
					});
					marker.setMap(self.mapObj);
				});
			});

			this.mapObj.setFitView();
			this.infoWindow = new AMap.InfoWindow({
				offset : new AMap.Pixel(0, -30)
			});
			this.getQjjlLngLatsInterval(fpq);
			this.getJjryLngLatsInterval(fpq);
		},

		getJjryLngLatsInterval : function(fpq) {

			var self = this;
			var getJjryLngLats = function() {

				$
						.get(
								"getJjryLngLats.htm",
								function(data) {

									if (self.markerJjrys.length > 0) {
										self.mapObj.remove(self.markerJjrys);
										self.markerJjrys = [];
									}
									self.alljjry = {};
									var rows = data.rows;
									$(rows)
											.each(
													function(i, item) {
														var marker = new AMap.Marker(
																{
																	icon : item.sbmc ? "media/image/dsbjjy.png"
																			: "media/image/jjy.png",
																	position : item.zb
																			.split(",")
																});
														marker
																.setMap(self.mapObj);
														marker
																.on(
																		'click',
																		function(
																				e) {

																			var content = "";
																			$
																					.get(
																							"getJjryInfomation.htm",
																							{
																								"jjyid" : item.id
																							},
																							function(
																									list) {
																								var rw = true;
																								$
																										.each(
																												list.rows,
																												function(
																														key,
																														xtSsjjyDto) {
																													if (key == 0) {
																														content += "<div>急救员："
																																+ xtSsjjyDto.xm
																																+ "("
																																+ xtSsjjyDto.dh
																																+ ")</div>"
																														if (xtSsjjyDto.sbmc) {
																															content += "<div>设备名称："
																																	+ xtSsjjyDto.sbmc
																																	+ "</div>"
																														}
																														content += "<div>身份类型："
																																+ xtSsjjyDto.sflx
																																+ "</div>"
																														content += "<div>类别："
																																+ xtSsjjyDto.lb
																																+ "</div>"
																														content += "<br/>";
																													}
																													if (xtSsjjyDto.qjid) {
																														rw = false;
																														content += "<div>正在救助："
																																+ xtSsjjyDto.qjxm
																																+ "("
																																+ xtSsjjyDto.qjdh
																																+ ")</div>"
																													}
																												});
																								content += "<br/>";
																								if (fpq == '1'
																										&& rw) {
																									content += " <a href=\"javascript:;\" class=\"btn red mini\" onclick=\"HegraceMap.belaidOff('"
																											+ item.id
																											+ "')\">下岗</a>";
																								}

																								self.infoWindow
																										.setContent(content);
																								self.infoWindow
																										.open(
																												self.mapObj,
																												marker
																														.getPosition());
																							})
																		});

														var content = item.xm
																+ "(" + item.dh
																+ ")";
														if (item.sbmc) {
															content += "<br/>设备:"
																	+ item.sbmc;
														}

														marker
																.setLabel({// label默认蓝框白底左上角显示，样式className为：amap-marker-label
																	offset : new AMap.Pixel(
																			30,
																			0),// 修改label相对于maker的位置
																	content : content
																});

														self.alljjry[""
																+ item.id] = {
															"marker" : marker,
															"position" : marker
																	.getPosition(),
															"ryid" : item.ryid,
															"jlid" : item.jlid,
															"sbmc" : item.sbmc,
															"xm" : item.xm,
															"dh" : item.dh,
															"id" : item.id
														};

														if (item.sbmc
																.indexOf("救护车") >= 0) {
															self.alljjry[""
																	+ item.id].jlid = '1';
														}

														self.markerJjrys
																.push(marker);
													});

								});
			}
			getJjryLngLats();
			setInterval(function() {
				getJjryLngLats();
			}, "10000");
		},
		getQJJLLngLats : function(fpq) {

			var self = this;
			$
					.get(
							"getQJJLLngLats.htm",
							function(data) {

								if (self.markerQjjls.length > 0) {
									self.mapObj.remove(self.markerQjjls);
									self.markerQjjls = [];
								}
								self.allqjjl = {};
								var rows = data.rows;
								$(rows)
										.each(
												function(i, item) {
													if (!item.zb)
														return;
													var marker = new AMap.Marker(
															{
																icon : "media/image/hjz.png",
																position : item.zb
																		.split(",")
															});
													marker
															.on(
																	'click',
																	function(e) {

																		var content = "";
																		$
																				.get(
																						"getQJJLInfomation.htm",
																						{
																							"qjid" : item.id
																						},
																						function(
																								list) {
																							var ztStyle = {
																								"0" : "未接受",
																								"1" : "已接受",
																								"2" : "已驳回",
																								"3" : "已处理",
																								"4" : "已中断"
																							}
																							$
																									.each(
																											list.rows,
																											function(
																													key,
																													xtQjjlDto) {
																												if (key == 0) {
																													content += "<div>参赛者："
																															+ xtQjjlDto.xm
																															+ "("
																															+ xtQjjlDto.dh
																															+ ")</div>"
																													content += "<div>事件名称："
																															+ xtQjjlDto.sjmc
																															+ "</div>"
																													content += "<div>事件描述："
																															+ xtQjjlDto.ms
																															+ "</div>"
																													content += "<br/>";
																												}
																												if (xtQjjlDto.jjyxm) {
																													content += "<div>";
																													content += "<a href=\"javascript:;\" class=\"btn red mini\" onclick=\"HegraceMap.cancelJjy('"
																															+ xtQjjlDto.jjyid
																															+ "', '"
																															+ item.id
																															+ "')\">取消</a>";
																													content += "["
																															+ ztStyle[xtQjjlDto.jjyzt]
																															+ "]救护员："
																															+ xtQjjlDto.jjyxm
																															+ "("
																															+ xtQjjlDto.jjydh
																															+ ")</div>"
																												}
																											});
																							content += "<br/><div>";
																							if (fpq == '1') {
																								content += " <a href=\"javascript:;\" class=\"btn green mini\" onclick=\"HegraceMap.close('"
																										+ item.id
																										+ "')\">完成</a>";
																								content += " <a href=\"javascript:;\" class=\"btn red mini\" onclick=\"HegraceMap.cancel('"
																										+ item.id
																										+ "')\">取消</a>";
																								content += " <a class=\"btn green mini\" href=\"javascript:;\" data-toggle=\"dropdown\">";
																								content += " <i class=\"icon-user\"></i> 手工分配";
																								content += " <i class=\"icon-angle-down\"></i>";
																								content += " </a>";
																								content += " <ul class=\"dropdown-menu\" style='top:100%;left:112px;margin-top:-34px;height:200px;width:100%;overflow:auto;'>";
																								if (self.alljjry) {
																									jQuery
																											.each(
																													self.alljjry,
																													function(
																															key,
																															jjry) {
																														if (jjry.jlid)
																															return;
																														content += " <li>";
																														content += " <a href=\"javascript:;\" onclick=\"HegraceMap.allocation('"
																																+ jjry.id
																																+ "','"
																																+ item.id
																																+ "')\"><i class=\" icon-user\"></i> "
																																+ jjry.xm
																																+ "("
																																+ jjry.dh
																																+ ")";
																														if (jjry.sbmc) {
																															content += " <br/><i class=\" icon-plus-sign\"></i> 设备("
																																	+ jjry.sbmc
																																	+ ")";
																														}
																														content += " </a></li>";
																													});
																								}
																								content += " </ul>";
																							}

																							content += "</div>"
																							self.infoWindow
																									.setContent(content);
																							self.infoWindow
																									.open(
																											self.mapObj,
																											marker
																													.getPosition());
																						})
																	});

													if (self.alljjry
															&& fpq == '1') {

														var distance = [];
														var walking = new AMap.Walking(
																{
																	map : self.mapObj,
																	hideMarkers : true
																});
														var newObject = jQuery.extend(true, {}, self.alljjry);
														jQuery
																.each(
																		self.alljjry,
																		function(
																				key,
																				jjry) {
																			if (!jjry.jlid
																					&& !item.jjyzt) {
																				walking
																						.search(
																								marker
																										.getPosition(),
																								jjry.position,
																								function(
																										status,
																										result) {
																									alert(key)
																									delete newObject[key];
																									if (status == "complete"
																											&& result != "OVER_DIRECTION_RANGE") {
																										distance
																												.push({
																													"key" : key,
																													"ryid" : jjry.ryid,
																													"jl" : result.routes[0].distance
																												})
																										alert(jQuery.isEmptyObject(newObject))
																										if(jQuery.isEmptyObject(newObject)) {
																											distance = distance
																													.sort(function(
																															a,
																															b) {
																														return a.jl
																																- b.jl;
																													});

																											distance = distance
																													.slice(
																															0,
																															2);
																											var ryids = [];
																											jQuery
																													.each(
																															distance,
																															function(
																																	i,
																																	json) {
																																ryids
																																		.push(json.ryid);
																															})

																											if (ryids.length > 0) {
																												$
																														.ajaxSetup({
																															async : false
																														});
																												$
																														.get(
																																"automatic.htm",
																																{
																																	"ryid" : ryids
																																			.join(","),
																																	"qjid" : item.id
																																},
																																function() {
																																	jQuery
																																			.each(
																																					distance,
																																					function(
																																							i,
																																							json) {
																																						self.alljjry[json.key].jlid = '1';
																																					})
																																})
																												$
																														.ajaxSetup({
																															async : true
																														});

																											}

																										}
																									}
																								});
																			}
																		})

													}

													marker.setMap(self.mapObj);
													marker
															.setLabel({// label默认蓝框白底左上角显示，样式className为：amap-marker-label
																offset : new AMap.Pixel(
																		30, 5),// 修改label相对于maker的位置
																content : item.xm
																		+ "("
																		+ item.dh
																		+ ")"
															});
													self.allqjjl["" + item.id] = {
														"marker" : marker,
														"position" : marker
																.getPosition()
													};
													self.markerQjjls
															.push(marker);

												});

							});
		},

		getQjjlLngLatsInterval : function(fpq) {
			var self = this;
			setInterval(function() {
				self.getQJJLLngLats(fpq);
			}, "10000");
		},

		belaidOff : function(jjyid) {
			var self = this;
			if (confirm("真的要下岗吗？")) {
				$.get("belaidOff.htm", {
					"jjyid" : jjyid
				}, function() {
					var marker = self.alljjry["" + jjyid].marker;
					self.mapObj.remove(marker);
					delete self.alljjry["" + jjyid];
					self.infoWindow && self.infoWindow.close();
				});
			} else {
				return false;
			}
		},

		close : function(qjid) {
			var self = this;
			if (confirm("完成任务吗？")) {
				$.get("closeQjjl.htm", {
					"qjid" : qjid
				}, function() {
					var marker = self.allqjjl["" + qjid].marker;
					self.mapObj.remove(marker);
					delete self.allqjjl["" + qjid];
					self.infoWindow && self.infoWindow.close();
				});
			} else {
				return false;
			}
		},

		cancel : function(qjid) {
			var self = this;
			if (confirm("取消任务吗？")) {
				$.get("cancelQjjl.htm", {
					"qjid" : qjid
				}, function() {
					var marker = self.allqjjl["" + qjid].marker;
					self.mapObj.remove(marker);
					delete self.allqjjl["" + qjid];
					self.infoWindow && self.infoWindow.close();
				});
			} else {
				return false;
			}
		},

		cancelJjy : function(ryid, qjid) {
			var self = this;
			if (confirm("取消急救员任务吗？")) {
				$.get("cancelSsjl.htm", {
					"ryid" : ryid,
					"qjid" : qjid
				}, function() {
					self.infoWindow && self.infoWindow.close();
					AMap.event.trigger(self.allqjjl["" + qjid].marker, "click")
				});
			} else {
				return false;
			}
		},

		allocation : function(jjryid, qjid) {
			var self = this;
			if (confirm("确认分配吗？")) {
				$.get("allocation.htm", {
					"qjid" : qjid,
					"jjryid" : jjryid
				},
						function() {
							self.alljjry["" + jjryid].jlid = "1";
							AMap.event.trigger(self.allqjjl["" + qjid].marker,
									"click");
						});
			} else {
				return false;
			}
		}
	}
}();
