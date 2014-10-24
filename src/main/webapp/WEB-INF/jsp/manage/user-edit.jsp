<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>用户新增</title>
    <script src="${contextPath}/js/jquery.validate.min.js"></script>
  	<script type="text/javascript">
  	<!--
	$(function() {
		$("#form").validate({
			rules : {
				name : {
					required : true
				}
			},
			messages : {
				name : {
					required : "用户名不能为空"
				}
			},
			submitHandler : function(form) {
				alert("submitted");
				$(form).ajaxSubmit();
			}
		});
	});
	//-->
	</script>
  </head>
  
  <body>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h3 class="page-header">用户新增</h3>
      
      <form class="form-horizontal" role="form" id="form" method="post" action="#">
      <div class="form-group">
        <label for="inputName" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-5">
          <input type="text" class="form-control" id="inputName" name="name" autofocus>
        </div>
      </div>
      <div class="form-group">
        <label for="inputAccount" class="col-sm-2 control-label">账号</label>
        <div class="col-sm-5">
          <input type="text" class="form-control" id="inputAccount" name="account">
        </div>
      </div>
      <div class="form-group">
        <label for="inputPassword" class="col-sm-2 control-label">密码</label>
        <div class="col-sm-5">
          <input type="password" class="form-control" id="inputPassword" name="password">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <div class="checkbox">
            <label>
              <input type="checkbox"> 启用
            </label>
          </div>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-primary">保 存</button>
        </div>
      </div>
      </form>
    </div>
  </body>
</html>