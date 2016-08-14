
function add() {
    $("input").val("");
    $("#addModal").modal("show");
}

function del(action) {
    //询问框
    layer.confirm('您确定要删除？', {
        btn: ['确定', '取消'] //按钮
    }, function () {
    	var checklist = document.getElementsByName ("selected");
    	var delIds = [];
    	for(var i=0;i<checklist.length;i++)
		{
   			if(checklist[i].checked == 1){
   				delIds.push(checklist[i].value);
   			}
		}
    	if(delIds.length==0){
    		alert("请至少选择一项！");
    		location.reload();
    		return;
    	}
    		
    	var url = action+"?Ids="+delIds;
    	window.location.href=url;
    }, function () {
        //  layer.close();
    });

}

function selectAll(){
	var checklist = document.getElementsByName ("selected");
	if(document.getElementById("controlAll").checked)
	{
		for(var i=0;i<checklist.length;i++)
		{
   			checklist[i].checked = 1;
		} 
	}else{
		for(var j=0;j<checklist.length;j++)
		{
  			checklist[j].checked = 0;
		}
	}
}