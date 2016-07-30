var FkList = function () {

    return {

		init: function () {

			$(".flexme4").flexigrid({
				idProperty : "racelist",
                url : false,
                dataType : 'json',
                colModel : [ {
                        display : '反馈内容',
                        name : 'dd',
                        width : 200,
                        align : 'center'
                    }, {
                        display : '反馈日期',
                        name : 'bssj',
                        width : 60,
                        align : 'center'
                    },  {
                        display : '反馈人姓名',
                        name : 'bssj',
                        width : 60,
                        align : 'center'
                    }, {
                        display : '反馈人电话',
                        name : 'bssj',
                        width : 100,
                        align : 'center'
                    },{
                        display : '状态',
                        name : 'bssj',
                        width : 50,
                        align : 'center'
                    },{
                        display : '操作',
                        name : 'zt',
                        width : 100,
                        align : 'center'
                    }],
                sortname : "iso",
                sortorder : "asc",
                usepager : true,
                title : '急救人员列表',
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