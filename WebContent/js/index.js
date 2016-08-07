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
								colModel : [
										{
											display : '参赛者姓名',
											name : 'xm',
											width : 60,
											align : 'center'
										},
										{
											display : '参赛者电话',
											name : 'dh',
											width : 100,
											align : 'center'
										},
										{
											display : '参赛者编号',
											name : 'bh',
											width : 60,
											align : 'center'
										},
										{
											display : '事件',
											name : 'sjid',
											width : 100,
											align : 'center'
										},
										{
											display : '发生时间',
											name : 'xgsj',
											width : 80,
											align : 'center'
										},
										{
											display : '处理描述',
											width : 200,
											name : 'clms',
											align : 'left'
										} ],
								usepager : true,
								useRp : false,
								rp : 10,
								width : 600,
								height : 200,
								onSuccess : function() {
									$("#processedFlexigrid").each(
										function() {
											$("#processed").find(".badge")
													.text(this.p.total);
									})
								},
								preProcess : function(date){
									var rows = date.rows;
									var arr = new Array();
									$(rows).each(function(i, row){
										var buttons = "";
										var jjyxms = row.jjyxm.split("|");
										var jjydhs = row.jjydh.split("|");
										var clmss = row.clms.split("|");
										$(jjyxms).each(function(i) {
											buttons += "<a href=\"javascript:;\" class=\"btn green mini\" title=\"电话："+jjydhs[i]+"&#10;描述："+clmss[i]+"\">"+jjyxms[i]+"</a> "
										});
										row["clms"] = buttons;
										arr.push(row);
									});
									date.rows = arr;
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
				rp : 10,
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
					align : 'center',
					process : function(tdDiv, xb) {
						var xbstr = xb == "1" ? "男" : "女";
						$(tdDiv).html("<div>" + xbstr + "</div>");
					}
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
				rp : 10,
				width : 500,
				height : 200,
				onSuccess : function() {
					$("#noSignInFlexigrid").each(function() {
						$("#noSignIn").find(".badge").text(this.p.total);
					})
				}
			});

		}

	};

}();
