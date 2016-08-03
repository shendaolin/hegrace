var ZhList = function () {

    return {

		init: function () {

			$("#czyhFlexigrid").flexigrid({
				idProperty : "racelist",
                url : "xtCzyhFlexigrid.html",
                dataType : 'json',
                params : $("#xtczyhSeach").serializeArray(),
                colModel : [ {
                        display : '账号名',
                        name : 'dlm',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '姓名',
                        name : 'xm',
                        width : 100,
                        align : 'center'
                    },  {
                        display : '电话',
                        name : 'dh',
                        width : 100,
                        align : 'center'
                    },{
                        display : '职位',
                        name : 'zw',
                        width : 100,
                        align : 'center'
                    }, {
                        display : '创建时间',
                        name : 'ss',
                        width : 100,
                        align : 'center'
                },{
                	display : '操作',
					width : 200,
					align : 'center',
					process : function(tdDiv, id) {
						var editButton = "<a href=\"javascript:;\" onclick=\"zhList.ZhEdit('"
								+ id
								+ "')\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 编辑</a>";
						var deleteButton = "<a href=\"javascript:;\" onclick=\"zhList.xtczyhDelete('"
								+ id
								+ "')\"  class=\"btn mini red\"><i class=\"icon-trash\"></i> 删除</a>";
						$(tdDiv).html(
								"<div>" + editButton
										+ deleteButton
										+ "</div>");
					}
				} ],
                sortname : "Id",
                sortorder : "asc",
                usepager : true,
                title : '操作人员列表',
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
		},
		 

		xtczyhDelete : function(id) {
			var del = confirm("确定要删除吗？");
			if (del == true) {
				$.get("XtCzyhDelete.html", {
					"id" : id
				});
				$("#xtCzyhFlexigrid").flexReload();
			} else {
				return false;
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
		},
		xtczyhFormSubmit : function() {
			return function() {
				$('#xtczyhForm').submit();
				
			}
		}
	};
 

}();
