/**
 * 
 */

var xtssgwList = function () {
    return {
		init: function () {
			
			$("#xtssgwFlexigrid").flexigrid({
                url : "xtSsgwFlexigrid.htm",
                params : $("#xtSsgwSeach").serializeArray(),
                dataType : 'json',
                colModel : [{
                        display : '岗位名称',
                        name : 'gwmc',
                        width : 200,
                        align : 'center'
                    }, {
                        display : '岗位数量',
                        name : 'gwsl',
                        width : 50,
                        align : 'center'
                    },{
                        display : '操作',
                        width : 200,
                        align : 'left',
                    	operation : function(tdDiv, row){
							$(tdDiv).html("");
							
							$(tdDiv).append($("<a href=\"#\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 修改</a>").on("click",function(){
								
								$("#page-content").load("xtSsgwEdit.htm", {
									"ssid" :row.ssid,
									"id" : row.id,
								});
								
							}));
							
							$(tdDiv).append($("<a href=\"#\" class=\"btn mini red\"><i class=\"icon-trash\"></i> 删除</a>").on("click",function(){
								var del = confirm("确定要删除吗？");
								if(del){
								$.get("xtSsgwDelete.htm",{"id" : row.id}, function(){
									$("#xtssgwFlexigrid").flexReload();
								});
								}else{
									return false;
								}
							}));
						}
                        	
                        	
                        	
                    }],
                sortname : "id",
                sortorder : "asc",
                usepager : true,
                title : '赛事岗位列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : $(document).height() - 400
            });


		},

		xtSsgwEditOnClick:function(ssid){
			return function(){
				$("#page-content").load("xtSsgwList.htm", {
					"ssid" :ssid
				});
			}
		}

    };

}();



var XtSsgwEdit = function () {

    return {

    	xtSsgwFormSubmit : function() {
			return function() {
				$('#xtSsgwForm').submit();
				$("#page-content").load("xtSsgwList.htm", {
					"ssid" :$("#ssid").val()
				});
			}
			
		}

    };

}();
