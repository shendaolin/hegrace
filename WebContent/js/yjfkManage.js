
var xtYjfkList = function () {
	
    return {
    	
		init: function () {

			$("#yjfkFlexigrid").flexigrid({
                url : "yjfkFlexigrid.htm",
                dataType : 'json',
                params : $("#xtyjfkSeach").serializeArray(),
                colModel : [ {
                        display : '反馈内容',
                        name : 'fknr',
                        width : 200,
                        align : 'center'
                    }, {
                        display : '反馈日期',
                        name : 'fkrq',
                        width : 60,
                        align : 'center',
						sortable : true
                    },  {
                        display : '反馈人姓名',
                        name : 'xm',
                        width : 80,
                        align : 'center',
						sortable : true
                    }, {
                        display : '反馈人电话',
                        name : 'dh',
                        width : 100,
                        align : 'center',
						sortable : true
                    },{
                        display : '状态',
                        name : 'ztName',
                        width : 50,
                        align : 'center',
						sortable : true
                    },{
                        display : '操作',
                        width : 80,
                        align : 'center',
						operation : function(tdDiv, row){
							if(row.ztName == "未处理"){
							$(tdDiv).html("").append($("<a href=\"#\" class=\"btn mini red\"><i class=\"icon-edit\"></i>处理</a>").on("click",function(){
								var handle = confirm("确认处理吗？");
								if(handle){
									$.get("handle.htm", {"id" : row.id}, function(){
										$("#yjfkFlexigrid").flexReload();
									});
								}else{
									return false;
								}
							}));
							}else{
								$(tdDiv).html("");
							}
						}	
                    }],
                sortname : "fkrq",
                sortorder : "asc",
                usepager : true,
                title : '意见反馈列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : $(document).height() - 400
            });


		},
		
		xtYjfkSearch : function(){
			$("#yjfkFlexigrid").flexOptions({
				params : $("#xtyjfkSeach").serializeArray()
			}).flexReload();
		}

    };

}();