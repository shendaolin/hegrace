var CsList = function () {

    return {

		init: function () {

			$("#xtGydm").flexigrid({
                url : "xtGydmFlexigrid.html",
                dataType : 'json',
                params:$("#xtGydmSeach").serializeArray(),
                colModel : [ {
                        display : '参数类型',
                        name : 'lbmc',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '参数编号',
                        name : 'id',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '参数名称',
                        name : 'dmmc',
                        width : 100,
                        align : 'center'
                    },{
                        display : '操作',
                        width : 200,
                        align : 'center',
                        process:function(tdDiv, pid){
                        	$(tdDiv).html('<div><a href="#" class="btn mini purple"><i class="icon-edit"></i> 编辑</a><a href="#" class="btn mini red"><i class="icon-trash"></i> 删除</a></div>')
                        }
                    }],
                checkbox : true,
                rowId : 'id',
                sortname : "id",
                sortorder : "asc",
                usepager : true,
                title : '系统参数列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : 300
            });


		},

		csEditOnClick : function(){
			return function(){
				$("#page-content").load("csedit.html");
			}
		}

    };

}();



var CsEdit = function () {

    return {

		csListOnClick : function(){
			return function(){
				$("#page-content").load("csList.html");
			}
		}

    };

}();
