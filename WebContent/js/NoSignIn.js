/**
 * 
 */


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
					HegraceMap.infoWindow && HegraceMap.infoWindow.close();
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
			jQuery.get("noSignInCount.htm", function(date) {
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
				url : "noSignIn.htm",
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
