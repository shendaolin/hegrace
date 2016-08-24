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
                    	align : 'left'
                    }, {
                        display : '赛事地点',
                        name : 'ssdd',
                        width : 100,
                        align : 'center',
                    	sortable : true
                    }, {
                        display : '比赛时间',
                        name : 'sskssj',
                        width : 120,
                        align : 'center',
                    	sortable : true
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
                    		var content = "<a href=\"javascript:;\" class=\"btn mini green\" onclick=\"xtSsglList.xtCszglList('"+row.id+"')\"><i class=\"icon-user\"></i> "+row.cszcount+"</a>";
							$(tdDiv).html(content);
						}
                    },{
                        display : '急救人数',
                        width : 60,
                        align : 'center',
                        operation : function(tdDiv, row){
                        	var content = "<a href=\"javascript:;\" class=\"btn mini red\" onclick=\"xtSsglList.xtSsjjyList('"+row.id+"')\"><i class=\"icon-plus\"></i> "+row.jjycount+"</a>";
							$(tdDiv).html(content);
						}
                    },{ 
                        display : '状态',
                        name : 'zt',
                        width : 100,
                        align : 'center',
                    	sortable : true,
                        operation : function(tdDiv, row){
                        	var content = "";
                        	if(row.zt == 1){
                        		content = "已发布";
                        	}else{
                        		content = "未发布";
                        	}
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
								+ "')\" class=\"btn mini green sszbgl\"><i class=\"icon-th-large\">赛事装备管理</i> </a>";
    						var ssgwButton = " <a href=\"javascript:;\" onclick=\"xtSsglList.xtSsgwList('"
								+ id
								+ "')\" class=\"btn mini green sszbgl\"><i class=\"icon-th-large\"></i> 赛事岗位管理</a>";
    						
    						var sstjButton = " <a href=\"javascript:;\" onclick=\"xtSsglList.xtSstjList('"
								+ id
								+ "')\" class=\"btn mini blue sstj\"><i class=\"icon-th-large\"></i> 赛事统计</a>";
						
    						$(tdDiv).html(
    								"<div>" + editButton
    										+ deleteButton
    										+ sszbglButton
    										+ ssgwButton
    										+ sstjButton
    										+ "</div>");
    					}
        				} ],
                sortname : "sskssj",
                sortorder : "desc",
                usepager : true,
                title : '赛事管理',
                useRp : false,
                rp : 15,
                width : "100%",
                height : $(document).height() - 400
            });


        },
        xtSsjjyList : function(ssid){
        	$("#page-content").load("xtSsjjyList.htm", {
				"ssid" :ssid
			});	
        },
        xtCszglList : function(ssid){
        	$("#page-content").load("xtCszglList.htm", {
				"ssid" :ssid
			});	
        },
        xtSsgwList : function(ssid){
        	$("#page-content").load("xtSsgwList.htm", {
				"ssid" :ssid
			});	
        },
        xtSstjList : function(ssid){
        	$("#page-content").load("xtSstjList.htm", {
				"ssid" :ssid
			});	
        },
		xtSsjjysbListOnClick : function(ssid){
			$("#page-content").load("xtSsjjysbList.htm", {
				"ssid" :ssid
			});		
		},
		xtSsglEditOnClick : function(id) {
			return function(){
				$("#page-content").load("xtSsglEdit.htm");
			}
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
		},
		
		xtSsglSeach : function(){
			$("#xtSsglFlexigrid").flexOptions({
				params : $("#xtSsglSeach").serializeArray()
			}).flexReload();
		},
		
		xtSsjjysbList : function(){
			return function(){
				$("#page-content").load("xtSsjjysbList.htm");
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
				if ($('#xtSsglForm').validate().form()) {
					$('#xtSsglForm').submit();
                }
				$("#page-content").load("xtSsglList.htm");
			}
		},
		
		xtSsglFormSubmitAck : function() {
			return function() {
				$("#zt").val(1);
				if ($('#xtSsglForm').validate().form()) {
					$('#xtSsglForm').submit();
                }
				$("#page-content").load("xtSsglList.htm");
			}
		}
	}; 

}();

