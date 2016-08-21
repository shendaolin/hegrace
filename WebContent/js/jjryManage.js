var xtJjryList = function () {
	
    return {
    	
		init: function () {
			$("#xtJjryFlexigrid").flexigrid({
                url : "xtJjryFlexigrid.htm",
                params : $("#jjrySeach").serializeArray(),
                dataType : 'json',
                colModel : [{
	                    display : '姓名',
	                    name : 'xm',
	                    width : 100,
	                    align : 'center'
	                },{
                        display : '手机号',
                        name : 'dh',
                        width : 100,
                        align : 'center'
                    },{
                        display : '性别',
                        width : 30,
                        align : 'center',
                    	operation : function(tdDiv, row){
                    		var content = "";
                    		if(row.xb == "1"){
                    			content = "男";
                    		}else{
                    			content = "女";
                    		}
							$(tdDiv).html(content);
						}	
                    },{
                        display : '证件类型',
                        name : 'zjmc',
                        width : 100,
                        align : 'center'
                    },{
                        display : '证件号码',
                        name : 'zjhm',
                        width : 150,
                        align : 'center'
                    }, {
                        display : '身份类型',
                        name : 'sfmc',
                        width : 100,
                        align : 'center'
                    },{
                        display : '类别',
                        name : 'lb',
                        width : 100,
                        align : 'center'
                    },{
                        display : '审核状态',
                        width : 60,
                        align : 'center',
                    	operation : function(tdDiv, row){
                    		var content = "";
                    		if(row.zt == "0"){
                    			content = "<span class=\"label label-warning\">未通过</span>";
                    		}else if(row.zt == "1"){
                    			content = "<span class=\"label label-success\">通过</span>";
                    		}else if(row.zt == "2"){
                    			content = "<span class=\"label label-danger\">黑名单</span>";
                    		}
							$(tdDiv).html(content);
						}
                        	
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
    						var jjryzzlButton = " <a href=\"javascript:;\" onclick=\"xtJjryList.xtJjryzzsbListOnClick('"
								+ id
								+ "')\" class=\"btn mini green sszbgl\"><i class=\"icon-th-large\">急救人员资质管理</i> </a>";
						
    						var ssjlListButton = "<a href=\"javascript:;\" onclick=\"xtJjryList.jjryListOnClick('"
								+ id
								+ "')\" class=\"btn mini yellow ssjl\"><i class=\"icon-time\"></i>赛事记录</a>";
						
    						$(tdDiv).html(
    								"<div>" + editButton
    										+ deleteButton
    										+jjryzzlButton
    										+ ssjlListButton+"</div>");
    					}
    				} ],
                sortname : "cjsj",
                sortorder : "desc",
                usepager : true,
                title : '急救人员列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : $(document).height() - 400
            });

			 
		},

		xtJjryEditOnClick : function() {
			return function() {
				$("#page-content").load("xtJjryEdit.htm");
			}
		},
		xtJjryzzsbListOnClick : function(ryId){
			$("#page-content").load("xtJjryzzList.htm", {
				"ryid" :ryId
			});		
		},
		xtJjryEdit : function(id) {
			$("#page-content").load("xtJjryEdit.htm", {
				"id" : id
			});
		},
		jjryListOnClick : function(id){
	        	$("#page-content").load("xtssjlList.htm", {
					"ryid" :id
				});	
	        },
	        
		xtJjryDelete : function(id) {
			var del = confirm("确定要删除吗？");
			if (del == true) {
				$.get("xtJjryDelete.htm", {
					"id" : id
				});
				$("#xtJjryFlexigrid").flexReload();
			} else {
				return false;
			}
		},

		ssjlEditOnClick : function(jhyid){
			return function(){
				$("#page-content").load("xtssjlList.htm", {"jhyid" : jhyid});
			}
		}, 
		
		xtJjrySeach : function(){
			$("#xtJjryFlexigrid").flexOptions({
				params : $("#xtJjrySeach").serializeArray()
			}).flexReload();
		}

    };

}();


var XtJjryEdit = function () {
	
    return {

    	xtJjryListOnClick : function(){
			return function(){
				$("#page-content").load("xtJjryList.htm");
			}
		},
		xtJjryFormSubmit : function() {
			return function() {
				if ($('#xtJjryForm').validate().form()) {
					$('#xtJjryForm').submit();
                }
			}
		}
	}; 

}();


var xtSsjlList1 = function () {
    return {

		init: function () {
			$("#xtssjlFlexigrid").flexigrid({
                url:"xtssjlFlexigrid.htm",
                params : $("#xtSsjlSeach").serializeArray(),
                dataType : 'json',
                colModel : [ {
                        display : '赛事名称',
                        name : 'ssmc',
                        width : 200,
                        align : 'center'
                    }, {
                        display : '事件时间',
                        name : 'sskssj',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '参赛者姓名',
                        name : 'xm',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '参赛者编号',
                        name : 'bh',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '事件描述',
                        name : 'ms',
                        width : 350,
                        align : 'center'
                    },{
                        display : '处理描述',
                        name : 'clms',
                        width : 350,
                        align : 'center'
                    },{
                        display : '驳回描述',
                        name : 'bhms',
                        width : 350,
                        align : 'center'
                    },{
                        display : '处理状态',
                        width : 100,
                        align : 'center',
                        operation : function(tdDiv, row){
							var zt2 = "";
							if(row.zt2 == "0") zt2 = "未接收";
							if(row.zt2 == "1") zt2 = "已接收";
							if(row.zt2 == "2") zt2 = "驳回";
							if(row.zt2 == "3") zt2 = "已处理";
							$(tdDiv).html(zt2);
						}
                    }],
                sortname : "c.id",
                sortorder : "asc",
                usepager : true,
                title : '急救人员事件列表',
                useRp : false,
                rp : 15,
                width : "100%",
            });


		},
		
    };

}();
