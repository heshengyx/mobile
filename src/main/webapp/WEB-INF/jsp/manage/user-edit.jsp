<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>用户新增</title>
    <script src="${ctx}/js/jquery.form.js"></script>
    <script src="${ctx}/js/jquery.validate.min.js"></script>
  	<script type="text/javascript">
  	<!--
	$(function() {
		$('#alert').hide();
		$('#form').validate({
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
				var options = {
					url : "${ctx}/manage/user/save",//默认是form action
					type : "post",
					dataType : "json",
					success : function(data) {
						$('#alert').show();
						if (data.code == '200') {
							$('#alert').addClass('alert-success');
						} else {
							$('#alert').addClass('alert-danger');
						}
						$('#message').html(data.message);
					}
				}
				$(form).ajaxSubmit(options);
				return false; //不刷新页面 
			}
		});
	});
	//-->
	</script>
  </head>
  
  <body>
    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
      <h3 class="page-header">用户新增</h3>
      
      <div class="alert alert-dismissible" role="alert" id="alert">
	  	<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	  	<strong></strong> <span id="message"></span>
	  </div>
	  
      <form class="form-horizontal" role="form" id="form" method="post">
      <div class="form-group">
        <label for="inputName" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-5">
          <input type="text" class="form-control" id="inputName" name="name" autofocus>
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