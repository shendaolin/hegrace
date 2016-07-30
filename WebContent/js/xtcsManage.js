var CsList = function () {

    return {

		init: function () {

			$(".flexme4").flexigrid({
				idProperty : "racelist",
                url : false,
                dataType : 'json',
                colModel : [ {
                        display : '参数类型',
                        name : 'dd',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '参数编号',
                        name : 'bssj',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '参数名称',
                        name : 'bssj',
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
