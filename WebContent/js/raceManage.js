var xtSsglList = function () {
	return {
    	//main function to initiate the module
        init: function () {
			$("#xtSsglFlexigrid").flexigrid({
                url : "xtSsglFlexigrid.htm",
                params : $("#xtSsglSeach").serializeArray(),
                dataType : 'json',
                colModel : [ {
                    	display : '赛事名称',
                    	name : 'ssmc',
                    	width : 200,
                    	sortable : true,
                    	align : 'center'
                    }, {
                        display : '赛事地点',
                        name : 'ssdd',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '比赛时间',
                        name : 'sskssj',
                        width : 120,
                        align : 'center'
                    }, {
                        display : '场景时间',
                        name : 'cjkssj',
                        width : 120,
                        align : 'center'
                    }, {
                        display : '参赛人数',
                        width : 100,
                        align : 'center',
                        operation : function(tdDiv, row){
                    		var content = "<a href=\"javascript:;\" class=\"btn mini green\"><i class=\"icon-user\"></i> "+row.cszcount+"</a>";
							$(tdDiv).html(content);
						}
                    },{ 
                        display : '急救人数',
                        width : 100,
                        align : 'center',
                        operation : function(tdDiv, row){
                        	var content = "";
                        	if(row.zt = 1){
                        		content = "已发布";
                        	}else{
                        		content = "未发布";
                        	}
							$(tdDiv).html(content);
						}	
                    } ,{
                        display : '状态',
                        name : 'zt',
                        width : 60,
                        align : 'center',
                        operation : function(tdDiv, row){
                        	var content = "<a href=\"javascript:;\" class=\"btn mini red\"><i class=\"icon-plus\"></i> "+row.jjycount+"</a>";
							$(tdDiv).html(content);
						}
                    },{
                        display : '操作',
                        width : 450,
                        align : 'left',
                    	process : function(tdDiv, id) {
    						var editButton = " <a href=\"javascript:;\" onclick=\"xtSsglList.xtSsglEdit('"
    								+ id
    								+ "')\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 编辑</a>";
    						var deleteButton = " <a href=\"javascript:;\" onclick=\"xtSsglList.xtSsglDelete('"
    								+ id
    								+ "')\"  class=\"btn mini red\"><i class=\"icon-trash\"></i> 删除</a>";
    						var sszbglButton = " <a href=\"javascript:;\" onclick=\"xtSsglList.xtSsjjysbListOnClick('"
								+ id
								+ "')\" class=\"btn mini green sszbgl\"><i class=\"icon-th-large\"></i> 赛事装备管理</a>";
    						var zyzshButton = " <a href=\"javascript:;\" onclick=\"xtSsglList.xtSsjjysbListOnClick('"
								+ id
								+ "')\" class=\"btn mini red zyzsh\"><i class=\"icon-th-large\"></i> 自愿者审核</a>";
    						var sstjButton = " <a href=\"javascript:;\" onclick=\"xtSsglList.xtSsglEdit('"
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
                height : $(document).height() - 400
            });


        },
        xtSsglEditOnClick : function() {
			return function() {
				$("#page-content").load("xtSsglEdit.htm");
			}
		},
		xtSsjjysbListOnClick : function(ssid){
				$("#page-content").load("xtSsjjysbList.htm", {
					"ssid" :ssid
					});		
		},
		xtSsglEdit : function(id) {
			$("#page-content").load("xtSsglEdit.htm", {
				"id" : id
			});
		},
		xtSsglDelete : function(id) {
			var del = confirm("确定要删除吗？");
			if (del == true) {
				$.get("xtSsglDelete.htm", {
					"id" : id
				});
				$("#xtSsglFlexigrid").flexReload();
			} else {
				return false;
			}
		}

    };

}();


var XtSsglEdit = function () {
	
    return {
    	init: function () {

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

    	xtSsglListOnClick : function(){
			return function(){
				$("#page-content").load("xtSsglList.htm");
			}
		},
		
		xtSsglFormSubmit : function() {
			return function() {
				var zt=$("#zt").val();
				$("#zt").val(0);
				$("#xtSsglForm").submit();
				
			}
		},
		
		xtSsglFormSubmitAck : function() {
			return function() {
				$("#zt").val(1);
				$("#xtSsglForm").submit();
				
			}
		}
	}; 

}();

/*
var xtcszglList = function () {
	return {
    	//main function to initiate the module
        init: function () {
			$("#cszglFlexigrid").flexigrid({
                url : "xtcszglFlexigrid.htm",
                params : $("#cszglSeach").serializeArray(),
                dataType : 'json',
                colModel : [ {
                    display : '<input type="checkbox" id="selectall">',
                    name:'',
                    width : 30,
                    sortable : true,
                    align : 'center'
                    },{
                    display : '参赛者',
                    name : 'xm',
                    width : 150,
                    sortable : true,
                    align : 'center'
                    }, {
                        display : '性别',
                        name : 'xbName',
                        width : 70,
                        align : 'center'
                    }, {
                        display : '证件号码',
                        name : 'zjhm',
                        width : 70,
                        align : 'center'
                    }, {
                        display : '电话',
                        name : 'dh',
                        width : 70,
                        align : 'center'
                    }, {
                        display : '参赛者编号',
                        name : 'bh',
                        width : 60,
                        align : 'center'
                },{
                        display : '是否高风险',
                        name : 'gfxName',
                        width : 60,
                        align : 'center'
                    },{
                        display : '操作',
                        name : 'zt',
                        width : 650,
                        align : 'center',
                    	process : function(tdDiv, id) {
   						 
    						var editButton = "<a href=\"javascript:;\" onclick=\"xtcszglList.xtcszglEdit('"
    								+ id
    								+ "')\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 编辑</a>";
    						var deleteButton = "<a href=\"javascript:;\" onclick=\"xtcszglList.xtcszglDelete('"
    								+ id
    								+ "')\"  class=\"btn mini red\"><i class=\"icon-trash\"></i> 删除</a>";
    					
						
    						$(tdDiv).html(
    								"<div>" + editButton
    										+ deleteButton
    										+ "</div>");
    					}
        				} ],
                sortname : "id",
                sortorder : "desc",
                usepager : true,
                title : '赛事参赛者管理',
                useRp : false,
                rp : 15,
                width : "100%",
                height : 300
            });


        },
        xtcszglEditOnClick : function() {
			return function() {
				$("#page-content").load("xtcszglEdit.htm");
			}
		},

		xtcszglEdit : function(id) {
			$("#page-content").load("xtcszglEdit.htm", {
				"id" : id
			});
		},
		xtcszglDelete : function(id) {
			var del = confirm("确定要删除吗？");
			if (del == true) {
				$.get("xtcszglDelete.htm", {
					"id" : id
				});
				$("#cszglFlexigrid").flexReload();
			} else {
				return false;
			}
		}

    };

}();

var xtSsjjysbList = function () {
	 
	return {
    	//main function to initiate the module
		
        init: function (ssid) {
			$("#SsjjysbFlexigrid").flexigrid({	
                url : "xtSsjjysbFlexigrid.htm",
                data : {  
                	ssid : ssid  
                }, 
                params : $("#SsjjysbSeach").serializeArray(),
                dataType : 'json',
                colModel : [ {
                    display : '<input type="checkbox" id="selectall">',
                    name:'',
                    width : 30,
                    sortable : true,
                    align : 'center'
                    },{
                    display : '赛事急救员',
                    name : 'ssjjyid',
                    width : 150,
                    sortable : true,
                    align : 'center'
                    }, {
                        display : '设备',
                        name : 'sbid',
                        width : 70,
                        align : 'center'
                    }, {
                        display : '领取状态',
                        name : 'zt',
                        width : 70,
                        align : 'center'
                    },{
                        display : '操作',
                        name : 'zt',
                        width : 650,
                        align : 'center',
                    	process : function(tdDiv, ssjjyid) {
    						var editButton = "<a href=\"javascript:;\" onclick=\"xtSsjjysbList.xtSsjjysbEdit('"
    								+ ssjjyid
    								+ "')\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 编辑</a>";
    		
    						$(tdDiv).html(
    								"<div>" + editButton+
    						"</div>");
    					}
        				} ],
                sortname : "id",
                sortorder : "desc",
                usepager : true,
                title : '赛事急救员设备管理',
                useRp : false,
                rp : 15,
                width : "100%",
                height : 300
            });


        },
        xtSsjjysbEditOnClick : function(ssid) {
        	alert(ssid);
        	return function(ssid) {
        		$("#page-content").load("xtSsjjysbEdit.htm",{
					"ssid" : ssid
				});
			}	
        	
		},

		xtSsjjysbEdit : function(id) {
			alert(id);
			$("#page-content").load("xtSsjjysbEdit.htm", {
				"id" : id
			});
		},
		xtSsjjysbDelete : function(id) {
			var del = confirm("确定要删除吗？");
			if (del == true) {
				$.get("xtSsjjysbDelete.htm", {
					"id" : id
				});
				$("#SsjjysbFlexigrid").flexReload();
			} else {
				return false;
			}
		}

    };

}();


var XtcszglEdit = function () {
	
    return {

    	xtcszglListOnClick : function(){
			return function(){
				 
				$("#page-content").load("xtcszglList.htm");
			}
		},
		xtcszglFormSubmit : function() {
			return function() {
				var zt=$("#zt").val();
				$("#zt").val(0);
				alert(zt);
				$("#xtcszglForm").submit();
				
			}
		},
		xtcszglFormSubmitAck : function() {
			return function() {
				$("#zt").val(1);
				$("#xtcszglForm").submit();
				
			}
		}
	}; 

}();

var RaceEdit = function () {var xtcszglList = function () {
	return {
    	//main function to initiate the module
        init: function () {
			$("#cszglFlexigrid").flexigrid({
                url : "xtcszglFlexigrid.htm",
                params : $("#cszglSeach").serializeArray(),
                dataType : 'json',
                colModel : [ {
                    display : '<input type="checkbox" id="selectall">',
                    name:'',
                    width : 30,
                    sortable : true,
                    align : 'center'
                    },{
                    display : '参赛者',
                    name : 'xm',
                    width : 150,
                    sortable : true,
                    align : 'center'
                    }, {
                        display : '性别',
                        name : 'xbName',
                        width : 70,
                        align : 'center'
                    }, {
                        display : '证件号码',
                        name : 'zjhm',
                        width : 70,
                        align : 'center'
                    }, {
                        display : '电话',
                        name : 'dh',
                        width : 70,
                        align : 'center'
                    }, {
                        display : '参赛者编号',
                        name : 'bh',
                        width : 60,
                        align : 'center'
                },{
                        display : '是否高风险',
                        name : 'gfxName',
                        width : 60,
                        align : 'center'
                    },{
                        display : '操作',
                        name : 'zt',
                        width : 650,
                        align : 'center',
                    	process : function(tdDiv, id) {
   						 
    						var editButton = "<a href=\"javascript:;\" onclick=\"xtcszglList.xtcszglEdit('"
    								+ id
    								+ "')\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 编辑</a>";
    						var deleteButton = "<a href=\"javascript:;\" onclick=\"xtcszglList.xtcszglDelete('"
    								+ id
    								+ "')\"  class=\"btn mini red\"><i class=\"icon-trash\"></i> 删除</a>";
    					
						
    						$(tdDiv).html(
    								"<div>" + editButton
    										+ deleteButton
    										+ "</div>");
    					}
        				} ],
                sortname : "id",
                sortorder : "desc",
                usepager : true,
                title : '赛事参赛者管理',
                useRp : false,
                rp : 15,
                width : "100%",
                height : 300
            });


        },
        xtcszglEditOnClick : function() {
			return function() {
				$("#page-content").load("xtcszglEdit.htm");
			}
		},

		xtcszglEdit : function(id) {
			$("#page-content").load("xtcszglEdit.htm", {
				"id" : id
			});
		},
		xtcszglDelete : function(id) {
			var del = confirm("确定要删除吗？");
			if (del == true) {
				$.get("xtcszglDelete.htm", {
					"id" : id
				});
				$("#cszglFlexigrid").flexReload();
			} else {
				return false;
			}
		}

    };

}();

var XtcszglEdit = function () {
	
    return {

    	xtcszglListOnClick : function(){
			return function(){
				 
				$("#page-content").load("xtcszglList.htm");
			}
		},
		xtcszglFormSubmit : function() {
			return function() {
				var zt=$("#zt").val();
				$("#zt").val(0);
				alert(zt);
				$("#xtcszglForm").submit();
				
			}
		},
		xtcszglFormSubmitAck : function() {
			return function() {
				$("#zt").val(1);
				$("#xtcszglForm").submit();
				
			}
		}
	}; 

}();


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

				$("#page-content").load("list.htm");
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
				$("#page-content").load("cszedit.htm");
			}
		}

    };

}();



var CszEdit = function () {

    return {

		cszListOnClick : function(){
			return function(){
				$("#page-content").load("cszlist.htm");
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
				$("#page-content").load("jjyedit.htm");
			}
		}

    };

}();



var JjyEdit = function () {

    return {

		jjyListOnClick:function(){
			return function(){
				$("#page-content").load("jjyList.htm");
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
*/
