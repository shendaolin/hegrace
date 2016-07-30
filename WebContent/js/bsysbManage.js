var SbList = function () {

    return {

		init: function () {

			$(".flexme4").flexigrid({
				idProperty : "racelist",
                url : false,
                dataType : 'json',
                colModel : [ {
                        display : '设备类型',
                        name : 'dd',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '设备编号',
                        name : 'bssj',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '设备状态',
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

		sbEditOnClick : function(){
			return function(){
				$("#page-content").load("sbedit.html");
			}
		},

		sbTjOnClick : function(){
			return function(){
				$("#page-content").load("sbtj.html");
			}
		}

    };

}();



var SbEdit = function () {

    return {

		sbListOnClick : function(){
			return function(){
				$("#page-content").load("sbList.html");
			}
		}

    };

}();
