var xtSsglList = function () {
	return {
    	//main function to initiate the module
        init: function () {
			$("#ssglFlexigrid").flexigrid({
                url : "xtSsglFlexigrid.html",
                params : $("#ssglSeach").serializeArray(),
                dataType : 'json',
                colModel : [ {
                    display : '<input type="checkbox" id="selectall">',
                    name:'',
                    width : 30,
                    sortable : true,
                    align : 'center'
                    },{
                    display : '赛事名称',
                    name : 'ssmc',
                    width : 150,
                    sortable : true,
                    align : 'center'
                    }, {
                        display : '赛事地点',
                        name : 'ssdd',
                        width : 70,
                        align : 'center'
                    }, {
                        display : '比赛时间',
                        name : 'sskssj',
                        width : 70,
                        align : 'center'
                    }, {
                        display : '场景时间',
                        name : 'cjkssj',
                        width : 70,
                        align : 'center'
                    }, {
                        display : '参赛人数',
                        name : 'cszglSum',
                        width : 60,
                        align : 'center'
                },{
                        display : '急救人数',
                        name : 'ssjjySum',
                        width : 60,
                        align : 'center'
                    } ,{
                        display : '状态',
                        name : 'ztName',
                        width : 60,
                        align : 'center'
                    },{
                        display : '操作',
                        name : 'zt',
                        width : 650,
                        align : 'center',
                    	process : function(tdDiv, id) {
   						 
    						var editButton = "<a href=\"javascript:;\" onclick=\"xtSsglList.xtSsglEdit('"
    								+ id
    								+ "')\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 编辑</a>";
    						var deleteButton = "<a href=\"javascript:;\" onclick=\"xtSsglList.xtSsglDelete('"
    								+ id
    								+ "')\"  class=\"btn mini red\"><i class=\"icon-trash\"></i> 删除</a>";
    						var sszbglButton = "<a href=\"javascript:;\" onclick=\"xtSsglList.xtSsglEdit('"
								+ id
								+ "')\" class=\"btn mini green sszbgl\"><i class=\"icon-th-large\"></i> 赛事装备管理</a>";
    						var zyzshButton = "<a href=\"javascript:;\" onclick=\"xtSsglList.xtSsglEdit('"
								+ id
								+ "')\" class=\"btn mini red zyzsh\"><i class=\"icon-th-large\"></i> 自愿者审核</a>";
    						var sstjButton = "<a href=\"javascript:;\" onclick=\"xtSsglList.xtSsglEdit('"
								+ id
								+ "')\" class=\"btn mini blue sstj\"><i class=\"icon-th-large\"></i> 赛事统计</a>";
						
    						$(tdDiv).html(
    								"<div>" + editButton
    										+ deleteButton
    										+ sszbglButton
    										+ zyzshButton
    										+ sstjButton
    										+ "</div>");
    					}
        				} ],
                sortname : "id",
                sortorder : "desc",
                usepager : true,
                title : '赛事管理',
                useRp : false,
                rp : 15,
                width : "100%",
                height : 300
            });


        },
        xtSsglEditOnClick : function() {
			return function() {
				$("#page-content").load("xtSsglEdit.html");
			}
		},

		xtSsglEdit : function(id) {
			$("#page-content").load("xtSsglEdit.html", {
				"id" : id
			});
		},
		xtSsglDelete : function(id) {
			var del = confirm("确定要删除吗？");
			if (del == true) {
				$.get("xtSsglDelete.html", {
					"id" : id
				});
				$("#ssglFlexigrid").flexReload();
			} else {
				return false;
			}
		},
		
		cszListOnClick : function(ssid){
			return function(){
				$("#page-content").load("cszlist.html", {"ssid" :ssid});
			}
			
		},

		jjyListOnClick : function(ssid){
			return function(){
				$("#page-content").load("jjylist.html", {"ssid" :ssid});
			}
		},

		sstjOnClick : function(ssid){
			return function(){
				$("#page-content").load("sstj.html", {"ssid" :ssid});
			}
		},

		zyzshOnClick : function(ssid){
			return function(){
				$("#page-content").load("shList.html", {"ssid" :ssid});
			}
		},

		sszbglOnClick : function(ssid){
			return function(){
				$("#page-content").load("zbglList.html", {"ssid" :ssid});
			}
		}





    };

}();

var XtSsglEdit = function () {
	
    return {

    	xtSsglListOnClick : function(){
			return function(){
				 
				$("#page-content").load("xtSsglList.html");
			}
		},
		xtSsglFormSubmit : function() {
			return function() {
				var zt=$("#zt").val();
				$("#zt").val(0)
				alert(zt);
				$("#xtSsglForm").submit();
				
			}
		},
		xtSsglFormSubmitAck : function() {
			return function() {
				$("#zt").val(1) 
				$("#xtSsglForm").submit();
				
			}
		}
	}; 

}();

var RaceEdit = function () {

    return {

		init: function () {

			$('#fileupload').fileupload({
                // Uncomment the following to send cross-domain cookies:
                //xhrFields: {withCredentials: true},
                //url: 'assets/plugins/jquery-file-upload/server/php/'
            });


			$(".sssjstart").datetimepicker({
			  format: "yyyy-mm-dd hh:ii",
			  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
			});
			  $(".sssjend").datetimepicker({
			  format: "yyyy-mm-dd hh:ii",
			  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
			});
			$(".cjsjstart").datetimepicker({
			  format: "yyyy-mm-dd hh:ii",
			  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
			});
			 $(".cjsjend").datetimepicker({
			  format: "yyyy-mm-dd hh:ii",
			  pickerPosition: (App.isRTL() ? "bottom-right" : "bottom-left")
			});



 
		},

		raceListOnClick : function(){
			return function(){

				$("#page-content").load("list.html");
			}
		}

    };

}();




var CszList = function () {

    return {

		init: function () {

			$(".flexme4").flexigrid({
				idProperty : "racelist",
                url : false,
                dataType : 'json',
                colModel : [ {
                    display : '<input type="checkbox" id="selectall">',
                    width : 30,
                    align : 'center'
                    },{
                        display : '手机号',
                        name : 'dd',
                        width : 150,
                        align : 'center'
                    }, {
                        display : '姓名',
                        name : 'bssj',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '身份证号',
                        name : 'cjsj',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '参赛编号',
                        name : 'csrs',
                        width : 80,
                        align : 'center'
                },{
                        display : '是否高风险人员',
                        name : 'jjrs',
                        width : 80,
                        align : 'center'
                    } ,{
                        display : '操作',
                        name : 'zt',
                        width : 150,
                        align : 'center'
                    }],
                sortname : "iso",
                sortorder : "asc",
                usepager : true,
                title : '参赛者列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : 300
            });


		},

		cszEditOnClick:function(){
			return function(){
				$("#page-content").load("cszedit.html");
			}
		}

    };

}();



var CszEdit = function () {

    return {

		cszListOnClick : function(){
			return function(){
				$("#page-content").load("cszlist.html");
			}
		}

	}
	
}();





var JjyList = function () {

    return {

		init: function () {

			$(".flexme4").flexigrid({
				idProperty : "racelist",
                url : false,
                dataType : 'json',
                colModel : [ {
                    display : '<input type="checkbox" id="selectall">',
                    width : 30,
                    align : 'center'
                    },{
                        display : '手机号',
                        name : 'dd',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '姓名',
                        name : 'bssj',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '性别',
                        name : 'bssj',
                        width : 30,
                        align : 'center'
                    },{
                        display : '身份证号',
                        name : 'cjsj',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '身份类型',
                        name : 'csrs',
                        width : 60,
                        align : 'center'
                },{
                        display : '来源',
                        name : 'jjrs',
                        width : 60,
                        align : 'center'
                    },{
                        display : '服装尺寸',
                        name : 'jjrs',
                        width : 50,
                        align : 'center'
                    } ,{
                        display : '岗位名称',
                        name : 'jjrs',
                        width : 50,
                        align : 'center'
                    } ,{
                        display : '携带装备',
                        name : 'jjrs',
                        width : 80,
                        align : 'center'
                    }  ,{
                        display : '操作',
                        name : 'zt',
                        width : 200,
                        align : 'center'
                    }],
                sortname : "iso",
                sortorder : "asc",
                usepager : true,
                title : '参赛者列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : 300
            });


		},

		jjyEditOnClick:function(){
			return function(){
				$("#page-content").load("jjyedit.html");
			}
		}

    };

}();



var JjyEdit = function () {

    return {

		jjyListOnClick:function(){
			return function(){
				$("#page-content").load("jjyList.html");
			}
		}

    };

}();


var ShList = function () {

    return {

		init: function () {

			$(".flexme4").flexigrid({
				idProperty : "racelist",
                url : false,
                dataType : 'json',
                colModel : [ {
                    display : '<input type="checkbox" id="selectall">',
                    width : 30,
                    align : 'center'
                    },{
                        display : '手机号',
                        name : 'dd',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '姓名',
                        name : 'bssj',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '性别',
                        name : 'bssj',
                        width : 30,
                        align : 'center'
                    },{
                        display : '身份证号',
                        name : 'cjsj',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '身份类型',
                        name : 'csrs',
                        width : 60,
                        align : 'center'
                },{
                        display : '服装尺寸',
                        name : 'jjrs',
                        width : 50,
                        align : 'center'
                    } ,{
                        display : '是否在黑名单',
                        name : 'jjrs',
                        width : 50,
                        align : 'center'
                    }  ,{
                        display : '操作',
                        name : 'zt',
                        width : 300,
                        align : 'center'
                    }],
                sortname : "iso",
                sortorder : "asc",
                usepager : true,
                title : '参赛者列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : 300
            });


		}

    };

}();






var ZbglList = function () {

    return {

		init: function () {

			$(".flexme4").flexigrid({
				idProperty : "racelist",
                url : false,
                dataType : 'json',
                colModel : [ {
                    display : '<input type="checkbox" id="selectall">',
                    width : 30,
                    align : 'center'
                    },{
                        display : '手机号',
                        name : 'dd',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '姓名',
                        name : 'bssj',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '性别',
                        name : 'bssj',
                        width : 30,
                        align : 'center'
                    },{
                        display : '身份证号',
                        name : 'cjsj',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '装备类型',
                        name : 'csrs',
                        width : 60,
                        align : 'center'
                },{
                        display : '装备编号',
                        name : 'jjrs',
                        width : 50,
                        align : 'center'
                    } ,{
                        display : '领取状态',
                        name : 'jjrs',
                        width : 50,
                        align : 'center'
                    }  ,{
                        display : '操作',
                        name : 'zt',
                        width : 100,
                        align : 'center'
                    }],
                sortname : "iso",
                sortorder : "asc",
                usepager : true,
                title : '参赛者列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : 300
            });


		}

    };

}();
