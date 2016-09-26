/**
 * 
 */

var XtSsjjyList = function () {

    return {
		init: function () {
			
			$("#xtSsjjyFlexigrid").flexigrid({
                url : "xtSsjjyFlexigrid.htm",
                params : $("#xtSsjjySeach").serializeArray(),
                dataType : 'json',
                colModel : [{
                        display : '手机号',
                        name : 'dh',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '姓名',
                        name : 'xm',
                        width : 100,
                        align : 'center',
                    	sortable : true
                    }, {
                        display : '性别',
                        name : 'xb',
                    	sortable : true,
                        width : 50,
                        align : 'center',
						operation : function(tdDiv, row){
							var content = "";
                    		if(row.xb == "1"){
                    			content = "男";
                    		}else if(row.xb == "2"){
                    			content = "女";
                    		}
							$(tdDiv).html(content);
						}
                    },{
                        display : '证件类型',
                        name : 'zjlx',
                        width : 80,
                        align : 'center'
                    },{
                        display : '身份证号',
                        name : 'zjhm',
                        width : 120,
                        align : 'center'
                    }, {
                        display : '身份类型',
                        name : 'sflx',
                        width : 100,
                        align : 'center',
                    	sortable : true
                    },{
                        display : '来源',
                        name : 'ly',
                        width : 100,
                        align : 'center',
                    	sortable : true,
						operation : function(tdDiv, row){
							$(tdDiv).html(row.ly == "1"?"平台添加":"App申请");
						}
                    },{
                        display : '服装尺寸',
                        name : 'fzcc',
                        width : 60,
                        align : 'center'
                    } ,{
                        display : '岗位名称',
                        name : 'gwmc',
                        width : 100,
                        align : 'center',
                    	sortable : true
                    } ,{
                        display : '携带装备',
                        name : 'sbmc',
                        width : 200,
                        align : 'center',
                    	sortable : true
                    },{
                        display : ' 赛事急救员状态',
                        name : 'zt',
                        width : 100,
                        align : 'center',
                        sortable : true,
                    	operation : function(tdDiv, row){
                    		var content = "";
                    		if(row.zt == "0"){
                    			content = "<span class=\"label label-warning\">未通过</span>";
                    		}else if(row.zt == "1"){
                    			content = "<span class=\"label label-success\">通过</span>";
                    		}
							$(tdDiv).html(content);
						}	
                        	
                },{
                    display : '急救员状态',
                    name : 'ryzt',
                    width : 80,
                    align : 'center',
                    sortable : true,
                	operation : function(tdDiv, row){
                		var content = "";
                		if(row.ryzt == "0"){
                			content = "<span class=\"label label-warning\">未通过</span>";
                		}else if(row.ryzt == "1"){
                			content = "<span class=\"label label-success\">通过</span>";
                		}else if(row.ryzt == "2"){
                			content = "<span class=\"label label-danger\">黑名单</span>";
                		}
						$(tdDiv).html(content);
					}
                    	
            }  ,{
                        display : '操作',
                        width : 200,
                        align : 'left',
                    	operation : function(tdDiv, row){
							$(tdDiv).html("");
							
							$(tdDiv).append($("<a href=\"#\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 修改</a>").on("click",function(){
								
								$("#page-content").load("xtSsjjyEdit.htm", {
									"ssid" :row.ssid,
									"id" : row.id,
									"ryxm" : row.xm,
								});
								
							}));
							
							$(tdDiv).append($("<a href=\"#\" class=\"btn mini red\"><i class=\"icon-trash\"></i> 删除</a>").on("click",function(){
								var del = confirm("确定要删除吗？");
								if(del){
								$.get("xtSsjjyDelete.htm",{"id" : row.id}, function(){
									$("#xtSsjjyFlexigrid").flexReload();
								});
								}else{
									return false;
								}
							}));
						}
                        	
                        	
                        	
                    }],
                sortname : "jjy.cjsj",
                sortorder : "desc",
                usepager : true,
                title : '赛事急救员列表',
                useRp : false,
                rp : 15,
                width : "100%",
                height : $(document).height() - 400
            });


		},

		XtSsjjyEditOnClick:function(ssid){
			return function(){
				$("#page-content").load("xtSsjjyEdit.htm", {
					"ssid" :ssid
				});
			}
		},

		xtSsjjySearch : function(){
			$("#xtSsjjyFlexigrid").flexOptions({
				params : $("#xtSsjjySeach").serializeArray()
			}).flexReload();
		}

    };

}();



var XtSsjjyEdit = function () {

    return {

    	xtSsjjyFormSubmit : function(ssid) {
			return function() {
				if ($('#xtSsjjyForm').validate().form()) {
					$('#xtSsjjyForm').submit();
                }
			}
		}

    };

}();
