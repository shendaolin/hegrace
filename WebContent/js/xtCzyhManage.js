var XtCzyhList = function () {

    return {

		init: function () {

			$("#xtCzyhFlexigrid").flexigrid({
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
                        name : 'zwName',
                        width : 100,
                        align : 'center'
                    },{
                	display : '操作',
					width : 200,
					align : 'center',
					process : function(tdDiv, id) {
						var editButton = "<a href=\"javascript:;\" onclick=\"XtCzyhList.xtCzyhEdit('"
								+ id
								+ "')\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 编辑</a>";
						var deleteButton = "<a href=\"javascript:;\" onclick=\"XtCzyhList.xtCzyhDelete('"
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
                height : $(document).height() - 400
            });


		},
		xtCzyhEditOnClick : function() {
			return function() {
				$("#page-content").load("xtCzyhEdit.html");
			}
		},

		xtCzyhEdit : function(id) {
			$("#page-content").load("xtCzyhEdit.html", {
				"id" : id
			});
		},
		xtCzyhDelete : function(id) {
			var del = confirm("确定要删除吗？");
			if (del == true) {
				$.get("xtCzyhDelete.html", {
					"id" : id
				});
				$("#xtCzyhFlexigrid").flexReload();
			} else {
				return false;
			}
		}
	};

  

}();


var XtCzyhEdit = function () {
	 
    return {

    	xtCzyhListOnClick : function(){
			return function(){
				$("#page-content").load("xtCzyhList.html");
			}
		},
		xtCzyhFormSubmit : function() {
			return function() {
				$("#xtCzyhForm").submit();
				
			}
		}
	};
 

}();
