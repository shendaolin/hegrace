var ZhList = function () {

    return {

		init: function () {

			$(".flexme4").flexigrid({
				idProperty : "racelist",
                url : false,
                dataType : 'json',
                colModel : [ {
                        display : '账号名',
                        name : 'dd',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '姓名',
                        name : 'bssj',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '电话',
                        name : 'bssj',
                        width : 100,
                        align : 'center'
                    },{
                        display : '职位',
                        name : 'cjsj',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '创建时间',
                        name : 'csrs',
                        width : 100,
                        align : 'center'
                },{
                        display : '操作',
                        name : 'zt',
                        width : 200,
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

		zhEditOnClick : function(){
			return function(){
				$("#page-content").load("zhedit.html");
			}
		}

    };

}();



var ZhEdit = function () {

    return {

		zhListOnClick : function(){
			return function(){
				$("#page-content").load("zhList.html");
			}
		}

    };

}();
