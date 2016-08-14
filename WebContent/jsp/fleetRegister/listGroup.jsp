<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<h4>Group Manage</h4>
			<div class="add">
				<a class="btn btn-success" onclick="add();">new</a> <a
					class="btn btn-success" onclick="edit();">edit</a> <a
					class="btn btn-success" onclick="del('deleteGroupById');">delete</a>
			</div>
			<div class="w">
				<div class="span12">
					<table class="table table-condensed table-bordered table-hover tab">
						<thead>
							<tr style="background-color: #d9edf7">
								<th width="50px"><input type="checkbox" id="controlAll" value="全选" onclick="selectAll()" /></th>
								<th>name</th>
								<th>company</th>
							</tr>
						</thead>
						<tbody id="tbody">
							<s:iterator value="pageBean.list">
								<tr>
									<td><input type="checkbox" name="selected" value='<s:property value='id' />' /></td>
									<td><s:property value='name' /></td>
									<td><s:property value='company.name' /></td>
								</tr>
							</s:iterator>
						</tbody>

					</table>
					<%-- <div class="list-page" align="right">第${b.page}/${b.totalPage}页 &nbsp;<a id="firstPage">首页
</a>&nbsp;<a id="addPage">上一页</a>&nbsp;<a id="nextPage">下一页</a>&nbsp;<a id="endPage">尾页</a></div> --%>
					<div align="right">

						<font size="3">共<font color="red"><s:property
									value="pageBean.totalPage" /></font>页
						</font>&nbsp;&nbsp; <font size="3">共<font color="red"><s:property
									value="pageBean.allRows" /></font>条记录
						</font><br>
						<br>

						<s:if test="pageBean.currentPage == 0">
            首页&nbsp;&nbsp;&nbsp;上一页
        </s:if>

						<s:else>
							<a href="listGroupByPage">首页</a>
            &nbsp;&nbsp;&nbsp;
            <a
								href="listGroupByPage?page=<s:property value="pageBean.currentPage - 1"/>">上一页</a>
						</s:else>

						<s:if test="pageBean.currentPage != pageBean.totalPage-1">
							<a
								href="listGroupByPage?page=<s:property value="pageBean.currentPage + 1"/>">下一页</a>
            &nbsp;&nbsp;&nbsp;
            <a
								href="listGroupByPage?page=<s:property value="pageBean.totalPage-1"/>">尾页</a>
						</s:if>

						<s:else>
            下一页&nbsp;&nbsp;&nbsp;尾页
        </s:else>

					</div>
					<div id="page" class="tr"></div>
				</div>
			</div>


			<div id="addModal" class="modal hide fade" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myModalLabel">new group</h3>
				</div>
				<form class="form-horizontal" action="addGroup">
					<div class="modal-body">
						<div class="control-group">
							<label class="control-label" for="name">name</label>
							<div class="controls">
								<input type="text" placeholder="name"
									name="group.name">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="company">company</label>
							<div class="controls">
								<s:select list="listCompany" listValue="name" listKey="id" name="group.company.id" headerKey="0" headerValue="请选择"></s:select>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">close</button>
						<button class="btn btn-primary" type="submit" id="add"
							onclick="save();">save</button>
					</div>
				</form>
			</div>

			<div id="editModal" class="modal hide fade" tabindex="-1"
				role="dialog" aria-labelledby="myEditModalLabel" aria-hidden="true">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">×</button>
					<h3 id="myEditModalLabel">edit group</h3>
				</div>
				<form class="form-horizontal" action="modifyGroup">
					<div class="modal-body">
						<div class="control-group hide">
							<label class="control-label" for="id">id</label>
							<div class="controls">
								<input type="text" id="id" placeholder="id"
									name="group.id">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="name">name</label>
							<div class="controls">
								<input type="text" id="name" placeholder="name"
									name="group.name">
							</div>
						</div>
						<div class="control-group">
							<label class="control-label" for="company">company</label>
							<div class="controls">
								<s:select id="company" list="listCompany" listValue="name" listKey="id" name="group.company.id" headerKey="0" headerValue="请选择"></s:select>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn" data-dismiss="modal" aria-hidden="true">close</button>
						<button class="btn btn-primary" type="submit" id="edit"
							onclick="save();">save</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script src="static/layer-v2.3/layer/layer.js"></script>
	<script src="static/laypage-v1.3/laypage/laypage.js"></script>
	<script src="static/scripts/common.js"></script>
	<script>
		function edit() {
			var checklist = document.getElementsByName ("selected");
			var Ids = [];
	    	for(var i=0;i<checklist.length;i++)
			{
	   			if(checklist[i].checked == 1){
	   				Ids.push(checklist[i].value);
	   			}
			}
	    	if(Ids.length==0){
	    		alert("请至少选择一项！");
	    		return;
	    	}
	    	if(Ids.length>1){
	    		alert("只能选择一个进行修改！");
	    		return;
	    	}
	    	$.ajax({
		        url: "getGroupById",
		        type: "get",
		        data : "id=" + Ids[0],
		        dataType: "json",
		        success: function (data) {
		            $("#id").val(data.id);
		            $("#name").val(data.name);
		            $("#company").val(data.company.id);
		        }
		    })
	    	$("#editModal").modal("show");
			
		}
	</script>
</body>
</html>
