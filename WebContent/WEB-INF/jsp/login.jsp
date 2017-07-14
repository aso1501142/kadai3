<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body>
<h1>ログイン</h1>
	<div class="center">

	<div id="targe" style="color: red;">
		<c:forEach var="error" items ="${errorMessageList}" varStatus="status">
			<p>
				<c:out value="${error}" />
			</p>
		</c:forEach>
		<c:out value="${errorMessage}" />
	</div>
	<form method="post" action="Login">
	<div class="stuballoon">


	<table>

		<label>ID</label></br>
		<input type="text" name="stu_id"/>
		<br/><br/>

		<label>Password</label><br/>
		<input type="password" name="stu_password"/>
		<br/><br/>

	</table>

	</div>

	<input type="submit" name="submit" value="Login"/>
	<br/>

	</form>
	</div>
</body>
</html>