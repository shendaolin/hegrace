/**
 * 
 */



var xtSsjjysbList = function () {
	 
	return {
    	//main function to initiate the module
		
        init: function (ssid) {
			$("#SsjjysbFlexigrid").flexigrid({	
                url : "xtSsjjysbFlexigrid.htm",
                params : $("#SsjjysbSeach").serializeArray(),
                dataType : 'json',
                colModel : [{
                    	display : '急救员姓名',
                    	name : 'xm',
                    	width : 100,
                    	sortable : true,
                    	align : 'center'
                    }, {
                        display : '电话',
                        name : 'dh',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '设备名称',
                        name : 'sblx',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '设备编号',
                        name : 'sbbh',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '领取状态',
                        width : 70,
                        align : 'center',
						operation : function(tdDiv, row){
							var zt = "";
							if(row.zt == "0") zt = "未领取";
							if(row.zt == "1") zt = "已领取";
							if(row.zt == "2") zt = "已归还";
							$(tdDiv).html(zt);
						}
                    },{
                        display : '操作',
                        name : 'zt',
                        width : 200,
                        align : 'center',
                        
                        operation : function(tdDiv, row){
                        	
    						var editButton = "";
    						if(row.zt == "0"){
    						editButton += "<a href=\"javascript:;\" onclick=\"xtSsjjysbList.getSsjjysb('"
    								+ row.id
    								+ "')\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 领取设备</a>";
    						editButton += " <a href=\"javascript:;\" onclick=\"xtSsjjysbList.deleteSsjjysb('"
								+ row.id
								+ "')\" class=\"btn mini purple\"><i class=\"icon-trash\"></i> 删除设备</a>";
    						}else if(row.zt == "1"){
    							editButton += "<a href=\"javascript:;\" onclick=\"xtSsjjysbList.backSsjjysb('"
    								+ row.id
    								+ "')\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 归还设备</a>";
    						}
    						
    						
    						$(tdDiv).html(
    								"<div>" + editButton +
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
                height : $(document).height() - 400
            });


        },
        getSsjjysb : function(id) {
        	var edit = confirm("确定要领取吗？");
        	if(edit){
	        	$.get("xtSsjjysbEdit.htm", {"id" : id, "zt" : "1"}, function(){
	        		$("#SsjjysbFlexigrid").flexReload();
	        	});
        	}
		},

		backSsjjysb : function(id) {
			var edit = confirm("确定要归还吗？");
			if(edit){
				$.get("xtSsjjysbEdit.htm", {"id" : id, "zt" : "2"}, function(){
	        		$("#SsjjysbFlexigrid").flexReload();
	        	});
			}
		},
		
		deleteSsjjysb : function(id) {
			var del = confirm("确定要删除吗？");
			if(del){
				$.get("xtSsjjysbDelete.htm", {"id" : id}, function(){
	        		$("#SsjjysbFlexigrid").flexReload();
	        	})
			}
		}

    };

}();