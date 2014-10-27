<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>用户管理</title>
    <script src="${ctx}/js/bootstrap-paginator.js"></script>
    <script type="text/javascript">
  	<!--
  	$(function(){
  		$('#pagination').addClass("text-right");
		var options = {
			bootstrapMajorVersion : 3,
            currentPage : "${users.pageNo}",
            numberOfPages : 5,
            totalPages : "${users.totalPage}",
            pageUrl : function(type, page, current) {
                return "javascript:void(0);";
            },
            onPageClicked : function(event, originalEvent, type, page) {
            	$('#page').val(page);
            	$('#form').submit();
            }
        }
        $('#pagination').bootstrapPaginator(options);
		//$('#pagination').removeClass("pagination").addClass("text-right");
		//$('#pagination ul').addClass("pagination").addClass("pagination-sm").css("margin-top", "0px");
  	});
	//-->
	</script>
  </head>
  
  <body>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h3 class="page-header">用户管理</h3>

      <div class="table-responsive">
      	<form class="form-inline" role="form" id="form" method="post" action="${ctx}/manage/users" style="margin-bottom:10px;">
      	   <input type="hidden" id="page" name="page" value="1">
           <div class="form-group">
		    <label for="inputName">姓名：</label>
		    <input type="text" class="form-control" id="inputName" name="name" value="${param.name}">
		  </div>
		  <button type="submit" class="btn btn-primary">搜 索</button>
        </form>
        <table class="table table-striped table-bordered">
          <thead>
            <tr>
              <th width="50">#</th>
              <th>姓名</th>
              <th>Header</th>
              <th>Header</th>
              <th width="100">操作</th>
            </tr>
          </thead>
          <tbody>
          	<c:forEach var="user" items="${users.datas}" varStatus="status">
          	<tr>
              <td>${status.count}</td>
              <td>${user.name}</td>
              <td>ipsum</td>
              <td>dolor</td>
              <td><a href="${ctx}/manage/user/edit/${user.id}">修改</a> <a href="${ctx}/manage/user/delete/${user.id}">删除</a></td>
            </tr>
          	</c:forEach>
          </tbody>
        </table>
        <div id="pagination"></div>
        <!-- <div class="text-right">
        <ul class="pagination" style="margin-top:0px;">
		  <li><a href="#">&laquo;</a></li>
		  <li><a href="#">1</a></li>
		  <li><a href="#">2</a></li>
		  <li><a href="#">3</a></li>
		  <li><a href="#">4</a></li>
		  <li><a href="#">5</a></li>
		  <li><a href="#">&raquo;</a></li>
		</ul>
		</div> -->
      </div>
    </div>
  </body>
</html>