
var FkList = function () {
	
    return {

		init: function () {

			$("#yjfkFlexigrid").flexigrid({
                url : "yjfkFlexigrid.html",
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
                        align : 'center'
                    },  {
                        display : '反馈人姓名',
                        name : 'xm',
                        width : 60,
                        align : 'center'
                    }, {
                        display : '反馈人电话',
                        name : 'dh',
                        width : 100,
                        align : 'center'
                    },{
                        display : '状态',
                        name : 'zt',
                        width : 50,
                        align : 'center'
                    },{
                        display : '操作',
                        name : 'zt',
                        width : 100,
                        align : 'center'
                    }],
                sortname : "fkrq",
                sortorder : "asc",
                usepager : true,
                title : '意见反馈列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : 300
            });


		},

		sbEditOnClick : function(){
			return function(){
				$("#page-content").load("sbedit.html");
			}
		}

    };

}();