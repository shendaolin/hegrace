var xtJjryList = function () {
	
    return {
    	
		init: function () {
			$("#xtJjryFlexigrid").flexigrid({
                url : "xtJjryFlexigrid.html",
                params : $("#jjrySeach").serializeArray(),
                dataType : 'json',
                colModel : [ /*{
                    display : '<input type="checkbox" id="selectall">全选',
                    name:'id',
                    width : 30,
                    align : 'center'
                    },*/{
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
                        name : 'lb',
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
                        process : function(tdDiv, id) {
    						var editButton = "<a href=\"javascript:;\" onclick=\"xtJjryList.xtJjryEdit('"
    								+ id
    								+ "')\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 编辑</a>";
    						var deleteButton = "<a href=\"javascript:;\" onclick=\"xtJjryList.xtJjryDelete('"
    								+ id
    								+ "')\"  class=\"btn mini red\"><i class=\"icon-trash\"></i> 删除</a>";
    						var ssjlListButton = "<a href=\"javascript:;\" onclick=\"xtSsjlList.jjryListOnClick('"
								+ id
								+ "')\" class=\"btn mini yellow ssjl\"><i class=\"icon-time\"></i>赛事记录</a>";
						
    						$(tdDiv).html(
    								"<div>" + editButton
    										+ deleteButton
    										+ ssjlListButton+"</div>");
    					}
    				} ],
                sortname : "id",
                sortorder : "asc",
                usepager : true,
                title : '急救人员列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : 300
            });

			 
		},

		xtJjryEditOnClick : function() {
			return function() {
				$("#page-content").load("xtJjryEdit.html");
			}
		},

		xtJjryEdit : function(id) {
			$("#page-content").load("xtJjryEdit.html", {
				"id" : id
			});
		},
		xtJjryDelete : function(id) {
			var del = confirm("确定要删除吗？");
			if (del == true) {
				$.get("xtJjryDelete.html", {
					"id" : id
				});
				$("#xtJjryFlexigrid").flexReload();
			} else {
				return false;
			}
		},

		ssjlEditOnClick : function(jhyid){
			return function(){
				$("#page-content").load("xtssjlList.html", {"jhyid" : jhyid});
			}
		}

    };

}();


var XtJjryEdit = function () {
	
    return {

    	xtJjryListOnClick : function(){
			return function(){
				$("#page-content").load("xtJjryList.html");
			}
		},
		xtJjryFormSubmit : function() {
			return function() {
				$("#xtJjryForm").submit();
				
			}
		}
	}; 

}();


var xtSsjlList = function () {

    return {

		init: function () {

			$(".flexme4").flexigrid({
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
