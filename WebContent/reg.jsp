<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/regServlet" method="post">
		用户名：<input type="text" name="name" value="${uf.name }"/>${uf.msg.name }${error }<br/>
		密码：<input type="password" name="password" />${uf.msg.password }<br/>
		确认密码：<input type="password" name="repassword"/>${uf.msg.repassword }<br/>
		邮箱：<input type="text" name="email" value="${uf.email}"/>${uf.msg.email}<br/>
		生日：<input type="text" name="birthday" value="${uf.birthday}"/>${uf.msg.birthday}<br/>
		<input type="submit" value="注册"/><br/>
	</form>
</body>
</html>