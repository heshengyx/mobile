<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <title>用户新增</title>
    <link href="${ctx}/css/uploadify.css" rel="stylesheet" type="text/css" />
    <script src="${ctx}/js/jquery.form.js"></script>
    <script src="${ctx}/js/jquery.validate.min.js"></script>
    <script src="${ctx}/js/jquery.uploadify.min.js"></script>
  	<script type="text/javascript">
  	<!--
	$(function() {
		$('#uploadify').uploadify({
            //指定swf文件
            'swf': '${ctx}/css/uploadify.swf',
            //后台处理的页面
            'uploader': 'UploadHandler.ashx',
            //按钮显示的文字
            'buttonText': '上传图片',
            //显示的高度和宽度，默认 height 30；width 120
            //'height': 15,
            'width': 80,
            //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
            //在浏览窗口底部的文件类型下拉菜单中显示的文本
            'fileTypeDesc': 'Image Files',
            //允许上传的文件后缀
            'fileTypeExts': '*.gif; *.jpg; *.png',
            //发送给后台的其他参数通过formData指定
            //'formData': { 'someKey': 'someValue', 'someOtherKey': 1 },
            //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
            //'queueID': 'fileQueue',
            //选择文件后自动上传
            'auto': true,
            //设置为true将允许多文件上传
            'multi': true
        });
		var url = "${ctx}/manage/user/save";
		var id = $('#id').val();
		if (id != "") {
			url = "${ctx}/manage/user/update";
		}
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
					url : url,//默认是form action
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
      <h3 class="page-header">用户编辑</h3>
      
      <div class="alert alert-dismissible" role="alert" id="alert">
	  	<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
	  	<strong></strong> <span id="message"></span>
	  </div>
	  
      <form class="form-horizontal" role="form" id="form" method="post">
      <input type="hidden" id="id" name="id" value="${user.id}">
      <div class="form-group">
        <label for="inputName" class="col-sm-2 control-label">用户名</label>
        <div class="col-sm-5">
          <input type="text" class="form-control" id="inputName" name="name" value="${user.name}" autofocus>
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
          <input type="file" name="uploadify" id="uploadify" />
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