var SbList = function () {

    return {

		init: function () {

			$("#bsysbFlexigrid").flexigrid({
				idProperty : "racelist",
                url : "xtBsysbFlexigrid.html",
                params : $("#bsysbSeach").serializeArray(),
                dataType : 'json',
                colModel : [ {
                        display : '设备类型',
                        name : 'dmmc',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '设备编号',
                        name : 'sbbh',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '设备状态',
                        name : 'sbzt',
                        width : 100,
                        align : 'center'
                    },{
                        display : '操作',
                        name : 'zt',
                        width : 200,
                        align : 'center'
                    }],
                sortname : "id",
                sortorder : "asc",
                usepager : true,
                title : '设备信息列表',
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
