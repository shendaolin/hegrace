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
                        align : 'center'
                    }, {
                        display : '性别',
                        width : 50,
                        align : 'center',
						operation : function(tdDiv, row){
							$(tdDiv).html(row.xb == "1"?"男":"女");
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
                        align : 'center'
                    },{
                        display : '来源',
                        name : 'ly',
                        width : 100,
                        align : 'center',
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
                        align : 'center'
                    } ,{
                        display : '携带装备',
                        name : 'sbmc',
                        width : 200,
                        align : 'center'
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
                sortname : "ry.xm",
                sortorder : "asc",
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
		}

    };

}();



var XtSsjjyEdit = function () {

    return {

    	xtSsjjyFormSubmit : function() {
			return function() {
				$('#xtSsjjyForm').submit();
			}
		}

    };

}();
