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
    
    <decorator:title default="默认title"/>
    <link rel="stylesheet" href="${contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${contextPath}/css/dashboard.css">
    <!--[if lt IE 9]>
      <script src="${contextPath}/js/html5shiv.min.js"></script>
      <script src="${contextPath}/js/respond.min.js"></script>
    <![endif]-->
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
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="${contextPath}/logout">Logout</a></li>
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
		    <li class="active"><a href="#">Overview</a></li>
		    <li><a href="#">Reports</a></li>
		    <li><a href="#">Analytics</a></li>
		    <li><a href="#">Export</a></li>
		  </ul>
		  <ul class="nav nav-sidebar">
		    <li><a href="">Nav item</a></li>
		    <li><a href="">Nav item again</a></li>
		    <li><a href="">One more nav</a></li>
		    <li><a href="">Another nav item</a></li>
		    <li><a href="">More navigation</a></li>
		  </ul>
		  <ul class="nav nav-sidebar">
		    <li><a href="">Nav item again</a></li>
		    <li><a href="">One more nav</a></li>
		    <li><a href="">Another nav item</a></li>
		  </ul>
		</div>
        
        <decorator:body />
      </div>
    </div>
    <script src="${contextPath}/js/jquery.min.js"></script>
    <script src="${contextPath}/js/bootstrap.min.js"></script>
  </body>
</html>
