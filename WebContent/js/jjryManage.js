var xtJjryList = function () {
	
    return {
    	
		init: function () {
			$("#xtJjryFlexigrid").flexigrid({
                url : "xtJjryFlexigrid.html",
                params : $("#jjrySeach").serializeArray(),
                dataType : 'json',
                colModel : [ {
                    display : '<input type="checkbox" id="selectall">',
                    width : 30,
                    align : 'center'
                    },{
                        display : '手机号',
                        name : 'dh',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '姓名',
                        name : 'xm',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '性别',
                        name : 'xbName',
                        width : 30,
                        align : 'center'
                    },{
                        display : '证件类型',
                        name : 'zjlxName',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '身份类型',
                        name : 'sflxName',
                        width : 60,
                        align : 'center'
                },{
                        display : '类别',
                        name : 'lyName',
                        width : 100,
                        align : 'center'
                },{
                        display : '审核状态',
                        name : 'ztName',
                        width : 60,
                        align : 'center'
                },{
                        display : '操作',
                        name : 'zt',
                        width : 300,
                        align : 'center'
                    }],
                sortname : "id",
                sortorder : "asc",
                usepager : true,
                title : '急救人员列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : 300
            });

			alert('sadfsafd');
		},

		jjryEditOnClick : function(){
			return function(){
				$("#page-content").load("jjryedit.html");
			}
		},

		ssjlEditOnClick : function(jhyid){
			return function(){
				$("#page-content").load("xtssjlList.html", {"jhyid" : jhyid});
			}
		}

    };

}();


var JjryEdit = function () {

    return {

		jjryListOnClick : function(){
			return function(){
				$("#page-content").load("jjryList.html");
			}
		}
    };

}();


var SsjlList = function () {

    return {

		init: function () {

			$(".flexme4").flexigrid({
				idProperty : "racelist",
                url : false,
                dataType : 'json',
                colModel : [ {
                        display : '赛事名称',
                        name : 'dd',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '事件时间',
                        name : 'bssj',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '事件描述',
                        name : 'bssj',
                        width : 150,
                        align : 'center'
                    },{
                        display : '处理描述',
                        name : 'cjsj',
                        width : 350,
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
		jjryListOnClick : function(){
			return function(){
				$("#page-content").load("jjryList.html");
			}
		}
    };

}();
