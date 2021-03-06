var xtBsysbList = function () {

    return {

		init: function () {

			$("#bsysbFlexigrid").flexigrid({
                url : "xtBsysbFlexigrid.htm",
                params : $("#bsysbSeach").serializeArray(),
                dataType : 'json',
                colModel : [ {
                        display : '设备类型',
                        name : 'lbmc',
                        width : 100,
                        align : 'center',
                        sortable : true
                    }, {
                        display : '设备编号',
                        name : 'sbbh',
                        width : 100,
                        align : 'center',
                        sortable : true
                    },  {
                        display : '设备状态',
                        name : 'sbzt',
                        width : 100,
                        align : 'center',
                        sortable : true,
                    	operation : function(tdDiv, row){
                    		var content = "";
                    		if(row.sbzt == "1"){
                    			content = "<span class=\"label label-success\">可用</span>";
                    		}else if(row.sbzt == "0"){
                    			content = "<span class=\"label label-warning\">不可用</span>";
                    		}
							$(tdDiv).html(content);
						}
                    },{
                        display : '操作',
                        width : 200,
                        align : 'center',
    					process : function(tdDiv, id) {
    						 
    						var editButton = "<a href=\"javascript:;\" onclick=\"xtBsysbList.bsysbEdit('"
    								+ id
    								+ "')\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 编辑</a>";
    						var deleteButton = "<a href=\"javascript:;\" onclick=\"xtBsysbList.bsysDelete('"
    								+ id
    								+ "')\"  class=\"btn mini red\"><i class=\"icon-trash\"></i> 删除</a>";
    						$(tdDiv).html(
    								"<div>" + editButton
    										+ deleteButton
    										+ "</div>");
    					}
    				} ],
                sortname : "cjsj",
                sortorder : "asc",
                usepager : true,
                title : '设备信息列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : $(document).height() - 400
            });


		},
		xtCzyhEditOnClick : function() {
			return function() {
				$("#page-content").load("xtBsysbEdit.htm");
			}
		},

		bsysbEdit : function(id) {
			
			$("#page-content").load("xtBsysbEdit.htm", {
				"id" : id
			});
			
		},
		bsysDelete : function(id) {
			var del = confirm("确定要删除吗？");
			if (del == true) {
				$.get("xtBsysbDelete.htm", {
					"id" : id
				});
				$("#bsysbFlexigrid").flexReload();
			} else {
				return false;
			}
		},
		xtBsysbSeach : function(){
			$("#bsysbFlexigrid").flexOptions({
				params : $("#bsysbSeach").serializeArray()
			}).flexReload();
		}
		  
    };

}();



var xtBsysbEdit = function () {

    return {

		xtBsysbListOnClick : function(){
			return function(){
				$("#page-content").load("xtBsysbList.htm");
			}
		},
		xtBsysbFormSubmit : function() {
			return function() {
				if ($('#xtBsysbForm').validate().form()) {
					$('#xtBsysbForm').submit();
                }
				$("#page-content").load("xtBsysbList.htm");
			}
		}
    };

}();
