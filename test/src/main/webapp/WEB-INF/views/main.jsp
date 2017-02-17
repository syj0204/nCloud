<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<form action="${pageContext.request.contextPath}/test" method="get" accept-charset="UTF-8">
	이름 : <input type="text" name="name"/> <br/>
	<input type="submit" value="submit"/>
	<input type="reset" value="reset"/>
</form>

</body>
</html>
