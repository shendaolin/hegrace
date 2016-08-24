/**
 * 
 */

var XtCszglList = function () {
    return {
		init: function () {
			
			$("#xtcszglFlexigrid").flexigrid({
                url : "xtCszglFlexigrid.htm",
                params : $("#xtCszglSeach").serializeArray(),
                dataType : 'json',
                colModel : [{
                        display : '姓名',
                        name : 'xm',
                        width : 100,
                        align : 'center',
                    	sortable : true
                    }, {
                        display : '性别',
                        name : 'xbName',
                        width : 50,
                        align : 'center',
                    	sortable : true
                    }, {
                        display : '证件号码',
                        width : 100,
                        name:'zjhm',
                        align : 'center',
						/*operation : function(tdDiv, row){
							$(tdDiv).html(row.xb == "1"?"男":"女");
						}*/
                    },{
                        display : '电话',
                        name : 'dh',
                        width : 80,
                        align : 'center'
                    },{
                        display : '参赛者编号',
                        name : 'bh',
                        width : 120,
                        align : 'center',
                    	sortable : true
                    }, {
                        display : '是否高风险',
                        name : 'gfxName',
                        width : 100,
                        align : 'center',
                    	sortable : true
                    }  ,{
                        display : '操作',
                        width : 200,
                        align : 'left',
                    	operation : function(tdDiv, row){
							$(tdDiv).html("");
							
							$(tdDiv).append($("<a href=\"#\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 修改</a>").on("click",function(){
								
								$("#page-content").load("xtCszglEdit.htm", {
									"ssid" :row.ssid,
									"id" : row.id,
									"ryxm" : row.xm,
								});
								
							}));
							
							$(tdDiv).append($("<a href=\"#\" class=\"btn mini red\"><i class=\"icon-trash\"></i> 删除</a>").on("click",function(){
								var del = confirm("确定要删除吗？");
								if(del){
								$.get("xtCszglDelete.htm",{"id" : row.id}, function(){
									$("#xtcszglFlexigrid").flexReload();
								});
								}else{
									return false;
								}
							}));
						}
                        	
                        	
                        	
                    }],
                sortname : "cjsj",
                sortorder : "desc",
                usepager : true,
                title : '参赛者列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : $(document).height() - 400
            });


		},

		xtCszglEditOnClick:function(ssid){
			return function(){
				$("#page-content").load("xtCszglEdit.htm", {
					"ssid" :ssid
				});
			}
		}

    };

}();



var XtCszglEdit = function () {

    return {

    	xtCszglFormSubmit : function() {
			return function() {
				$('#xtCszglForm').submit();
				$("#page-content").load("xtCszglList.htm", {
					"ssid" :$("#ssid").val()
				});
			}
		}

    };

}();
