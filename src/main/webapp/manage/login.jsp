<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/common/include.jsp"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<title>用户登录</title>
	<link href="${ctx}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${ctx}/css/login.css" rel="stylesheet">
	<!--[if lt IE 9]>
      <script src="${ctx}/js/html5shiv.min.js"></script>
      <script src="${ctx}/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="container">
      <form action="${ctx}/j_spring_security_check" method="POST" class="form-signin" role="form">
        <h2 class="form-signin-heading">用户登录</h2>
        
        <h5>账号</h5>
        <input type="text" name="j_username" class="form-control" placeholder="账号" required autofocus>
        <h5>密码</h5>
        <input type="password" name="j_password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="_spring_security_remember_me" id="remember_me"> 记住我
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登 录</button>
      </form>
    </div>
</body>
</html>
