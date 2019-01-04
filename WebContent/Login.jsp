<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 如果新建jsp开头报错的话，就打开工程build path，添加Library--添加Runntime Server -->
	<c:if test="${empty u}">
		<!-- 如果出现test does not support runtime的错误，就把上面导入的标签地址改为/jsp/jstl/core即可 -->
		<a href="reallogin.jsp">登录</a>
		<a href="reg.jsp">注册</a>
	</c:if>
	<c:if test="${not empty u}">
		欢迎你：${u.name }<a href="${pageContext.request.contextPath }/LoginOutServlet">注销</a>
	</c:if>
</body>
</html>