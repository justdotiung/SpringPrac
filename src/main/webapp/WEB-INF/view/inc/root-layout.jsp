<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html lang="en" style="font-size: 10px">

<head>
<meta charset="UTF-8">
<!-- 반응형 웹 디자인  -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Document</title>
<link href="/root/css/style.css" type="text/css" rel="stylesheet">
<style>
	#footer{
	width:100%;
	}
</style> 

</head>


<body>
	<!-- header block------------------------------------------------------------------------------------------- -->
<%-- 	<jsp:include page="../../inc/header.jsp"/> --%>
<tiles:insertAttribute name="header"/>
	<!-- visual block------------------------------------------------------------------------------------------- -->
	<div id="visual">
		<div class="content-box7" style="position: relative">
			<!-- <img src="https://i.pinimg.com/236x/bc/86/9c/bc869cbe73bab4b780b1dc50b2c55bda--image-c-spongebob.jpg" > -->
			<!-- <div style =" width:900px;height:400px; border: 1px solid red;
                background: url(https://item.kakaocdn.net/do/490d3fcfcef6c2b69b380d4b66328e53f43ad912ad8dd55b04db6a64cddaf76d)no-repeat;
                background-size: cover ;
                background-attachment: fixed;
                ">
            </div>
        -->
			<span style="left: 100px; top: 100px; position: absolute">웅이만세</span>
			<span style="margin-left: -100px">귀욤웅이</span>
		</div>
		<!-- <img src="https://item.kakaocdn.net/do/490d3fcfcef6c2b69b380d4b66328e53f43ad912ad8dd55b04db6a64cddaf76d" style="opacity:  0.5;" > -->
	</div>
	<!-- body block------------------------------------------------------------------------------------------- -->
	<div id="body">
		<div class="content-box1">
		<%-- <jsp:include page="../../inc/aside.jsp"/> --%>
			<!-- main 부분 -->
			<tiles:insertAttribute name="main"/>
		</div>
	</div>
	<!-- footer block------------------------------------------------------------------------------------------- -->
<%-- <jsp:include page="../../inc/footer.jsp"/>   --%>
<tiles:insertAttribute name="footer"/>
</body>

</html>