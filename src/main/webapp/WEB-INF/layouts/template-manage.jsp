<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<!DOCTYPE html>
<html lang="zh-cn">
  <head>
  	<meta charset="utf-8">
  	<meta http-equiv="X-UA-Compatible" content="IE=edge">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<meta name="description" content="">
    <meta name="author" content="">
    <title><decorator:title default="默认title"/></title>
    
    <link rel="stylesheet" href="${ctx}/css/bootstrap.css">
    <link rel="stylesheet" href="${ctx}/css/dashboard.css">
    <script src="${ctx}/js/jquery.min.js"></script>
    <script src="${ctx}/js/bootstrap.min.js"></script>
    <!--[if lt IE 9]>
    <script src="${ctx}/js/html5shiv.min.js"></script>
    <script src="${ctx}/js/respond.min.js"></script>
    <![endif]-->
    <decorator:head/>
  </head>
  
  <body>
  	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">后台管理</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <!-- <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li> -->
            <li><a href="${ctx}/logout" onclick="javascript:return confirm('确定要退出吗?');">退出</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
      	<div class="col-sm-3 col-md-2 sidebar">
		  <ul class="nav nav-sidebar">
		    <li><a href="">客户列表</a></li>
		    <li><a href="">客户编辑</a></li>
		  </ul>
		  <ul class="nav nav-sidebar">
		    <li><a href="">产品列表</a></li>
		    <li><a href="">产品编辑</a></li>
		  </ul>
		  <ul class="nav nav-sidebar">
		    <li><a href="${ctx}/manage/users">用户列表</a></li>
		    <li><a href="${ctx}/manage/user/edit">用户编辑</a></li>
		  </ul>
		</div>
        
        <decorator:body />
      </div>
    </div>
    <script type="text/javascript">
  	<!--
	$(function() {
		var url = window.location.href;
		$('.nav-sidebar li a').each(function() {
			//$(this).parent().removeClass('active');
			var href = $(this).attr("href");
			if (href != "" && url.indexOf(href) != -1) {
				$(this).parent().addClass('active');
			}
		});
	});
	//-->
	</script>
  </body>
</html>