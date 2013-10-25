<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link href="/css/bootstrap.min.css" rel="stylesheet" media="screen">
	<script src="http://code.jquery.com/jquery.js"></script>
	<script src="/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="well">
					<form>
						<fieldset>
							<legend>Login</legend>
							<input type="text" class="input-block-level" placeholder="username">
							<input type="text" class="input-block-level" placeholder="password">
							<label class="checkbox">
							<input type="checkbox">Remember me
							</label>
							
							<div class="pull-right">
							<input type="submit" class="btn btn-primary" value="login">
							
             <!--<button class="btn btn-info" type="button" data-toggle="modal" data-target="#myModal">Register</button>  -->
							<a class="btn btn-info" href="#register" role="button" data-target="#register" data-toggle="modal">Register</a>
							</div>
						</fieldset>
					</form>
			
			</div>
</body>
</html>