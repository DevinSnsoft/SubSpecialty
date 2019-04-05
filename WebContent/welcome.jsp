<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
		<title>大类招生分流报名</title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<link href="css/common.css" rel="stylesheet" />
		<script src="js/mui.min.js"></script>	
		<script src="js/wel.js"></script>	
</head>
<body>
<div  style="background-image:url(images/4.jpg);">
	<!--<center><h1>Welcome!</h1></center>-->
		<p>
			${illustration}
		</p>
		<div class="xz">
		<!-- 
		<c:forEach var="gender" items="${genders }">
					<input type="radio" name="gender" value="${gender }">${gender }
				
				</c:forEach>
		-->
<!-- 
		<label for="k1"><input type="radio" name="k1" checked="true"/>我是学生 </label>
		<label for="k2"><input type="radio" name="k1"/>我是老师</label>
		 -->
		<br/>
		<input type="button" value="进入" class="Login" onclick="tiaozhuan()">
		</div>
		<br/><br/> 
		<center><button type="button" class="download" >
		<a href="${pageContext.request.contextPath }/ListFileServlet">相关附件下载</a>
		</button></center>
		 </div>
</body>
</html>