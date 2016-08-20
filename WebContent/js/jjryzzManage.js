var xtJjryzzList = function () {
	
    return {
    	
		init: function () {
			$("#xtJjryzzFlexigrid").flexigrid({
                url : "xtJjryzzFlexigrid.htm",
                params : $("#xtJjryzzSeach").serializeArray(),
                dataType : 'json',
                colModel : [{
	                    display : '姓名',
	                    name : 'xm',
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
                        display : '图片',
                        name : 'tpdz',
                        width : 100,
                        align : 'center'
                    },{
                        display : '操作',
                        name : 'zt',
                        width : 300,
                        process : function(tdDiv, id) {
    						var ssjlListButton = "<a href=\"javascript:;\" onclick=\"xtSsjlList.jjryListOnClick('"
								+ id
								+ "')\" class=\"btn mini yellow ssjl\"><i class=\"icon-time\"></i>赛事记录</a>";
						
    						$(tdDiv).html(
    								"<div>"
    										+ deleteButton + 
    										"</div>");
    					}
    				} ],
                sortname : "id",
                sortorder : "asc",
                usepager : true,
                title : '急救人员图片列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : $(document).height() - 400
            });

			 
		},

		xtJjryzzEditOnClick : function() {
			return function() {
				$("#page-content").load("xtJjryzzEdit.htm");
			}
		},

		xtJjryzzEdit : function(id) {
			$("#page-content").load("xtJjryzzEdit.htm", {
				"id" : id
			});
		},
		xtJjryzzDelete : function(id) {
			var del = confirm("确定要删除吗？");
			if (del == true) {
				$.get("xtJjryzzDelete.htm", {
					"id" : id
				});
				$("#xtJjryzzFlexigrid").flexReload();
			} else {
				return false;
			}
		},

		ssjlEditOnClick : function(jhyid){
			return function(){
				$("#page-content").load("xtssjlList.htm", {"jhyid" : jhyid});
			}
		}, 
		
		xtJjryzzSeach : function(){
			$("#xtJjryzzFlexigrid").flexOptions({
				params : $("#xtJjryzzSeach").serializeArray()
			}).flexReload();
		}

    };

}();


var XtJjryzzEdit = function () {
	
    return {

    	xtJjryzzListOnClick : function(){
			return function(){
				$("#page-content").load("xtJjryzzList.htm");
			}
		},
		xtJjryzzFormSubmit : function() {
			return function() {
				if ($('#xtJjryzzForm').validate().form()) {
					$('#xtJjryzzForm').submit();
                }
				//$("#xtJjryzzForm").submit();
				
			}
		}
	}; 

}();


var xtSsjlList = function () {

    return {

		init: function () {
	
			$("#xtssjlFlexigrid").flexigrid({
                url:"xtssjlFlexigrid.htm",
                params : $("#xtJjryzzSeach1").serializeArray(),
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
		jjryListOnClick : function(ryid){
	        	$("#page-content").load("xtssjlList.htm", {
					"ryid" :ryid
				});	
	        }
    };

}();
