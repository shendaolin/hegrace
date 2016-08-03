var XtGydmList = function() {

	return {

		init : function() {

			$("#xtGydmFlexigrid")
					.flexigrid(
							{
								url : "xtGydmFlexigrid.html",
								dataType : 'json',
								params : $("#xtGydmSeach").serializeArray(),
								colModel : [
										{
											display : '参数类型',
											name : 'lbmc',
											width : 100,
											align : 'center'
										},
										{
											display : '参数编号',
											name : 'id',
											width : 250,
											align : 'center'
										},
										{
											display : '参数名称',
											name : 'dmmc',
											width : 100,
											align : 'center'
										},
										{
											display : '操作',
											width : 200,
											align : 'center',
											process : function(tdDiv, id) {
												var editButton = "<a href=\"javascript:;\" onclick=\"XtGydmList.xtGydmEdit('"
														+ id
														+ "')\" class=\"btn mini purple\"><i class=\"icon-edit\"></i> 编辑</a>";
												var deleteButton = "<a href=\"javascript:;\" onclick=\"XtGydmList.xtGydmDelete('"
														+ id
														+ "')\"  class=\"btn mini red\"><i class=\"icon-trash\"></i> 删除</a>";
												$(tdDiv).html(
														"<div>" + editButton
																+ deleteButton
																+ "</div>");
											}
										} ],
								checkbox : true,
								rowId : 'id',
								sortname : "id",
								sortorder : "asc",
								usepager : true,
								title : '系统参数列表',
								useRp : false,
								rp : 15,
								page : 1,
								width : "100%",
								height : $(document).height() - 400
							});

		},

		xtGydmEditOnClick : function() {
			return function() {
				$("#page-content").load("xtGydmEdit.html");
			}
		},

		xtGydmEdit : function(id) {
			$("#page-content").load("xtGydmEdit.html", {
				"id" : id
			});
		},

		xtGydmDelete : function(id) {
			var del = confirm("确定要删除吗？");
			if (del == true) {
				$.get("xtGydmDelete.html", {
					"id" : id
				});
				$("#xtGydmFlexigrid").flexReload();
			} else {
				return false;
			}
		}
	};

}();

var xtGydmEdit = function() {

	return {

		xtGydmListOnClick : function() {
			return function() {
				$("#page-content").load("xtGydmList.html");
			}
		},

		xtGydmFormSubmit : function() {
			return function() {
				$('#xtGydmForm').submit();
			}
		}
	};

}();