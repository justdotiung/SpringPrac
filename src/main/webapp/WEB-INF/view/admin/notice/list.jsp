<%@page import="com.newlecture.web.dao.oracle.NoticeView"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<% List<NoticeView> lista = (List<NoticeView>)request.getAttribute("list");
	lista.get(0).getHit();
%>

<body>
	<!-- header block------------------------------------------------------------------------------------------- -->
	<jsp:include page="../../inc/header.jsp"/>
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
		<jsp:include page="../../inc/aside.jsp"/>

			<main id="main">  
			<section>
				<h1>공지사항</h1>
				<section id="breadcrumb">
					<h1 class="d-none">경로</h1>
					<ol>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ol>
				</section>

				<section>
					<h1>공지사항 검색</h1>
					<form>
						<select>
							<option>제목</option>
							<option>작성자</option>
							<option>내용</option>
						</select> <input type="text" placeholder="검색">
						 <input type="submit" value="검색">
					</form>
				</section>

				<section id="notice">
					<h1 class="d-none">공지사항 목록</h1>
					<form action="" method="post">
					<table>
						<thead>
							<tr class="notice-header">
								<td class="num">번호</td>
								<td class="title">제목</td>
								<td class="writer">작성자</td>
								<td class="date">작성일</td>
								<td class="hit">조회수</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="n" items="${list}">
							<c:if test="${param.eid==n.id}">
								<tr>
									<td class="num">${n.id}</td>
									<td class="title">
										<input type="text" name="title" value="${n.title}">
										<span>${n.commentCount}</span>
										<span><input type="submit" value="저장"></span>
									</td>
									<td class="writer">${n.writherId}</td>
									<td class="date">${n.date}</td>
									<td class="hit">${n.hit}</td>
								</tr>
								</c:if>
								<c:if test="${param.eid != n.id}">
								<tr>
									<td class="num">${n.id}</td>
									<td class="title">
										<a href="detail?id=${n.id}">${n.title}</a>
										<span>${n.commentCount}</span>
										<span><a href="list?eid=${n.id}">수정</a><a href="">삭제</a></span>
									</td>
									<td class="writer">${n.writherId}</td>
									<td class="date">${n.date}</td>
									<td class="hit">${n.hit}</td>
								</tr>
								</c:if>
							</c:forEach>
						
						</tbody>
					</table>
					</form>
					<div>
					<!-- get방식의 형태- -->
						<a href="reg">글쓰기</a>
					</div>
				</section>
				<section class="page-index">
					<h1 class="d-none">페이지 정보</h1>
					<div>
						<span class="color-highlight font-bold">1</span>/ 1 pages
					</div>
				</section>
				
			
				<section id="pager">
					<h1 class="d-none">페이지</h1>
					<div>
						<div class="icon-prev-pager">이전</div>
						<ul>
							
							<li><a href="list?p=1">1</a></li>
							<li class="current">
							<li><a href="list?p=2">2</a></li>
							<li><a href="list?p=3">3</a></li>
							<li><a href="list?p=4">4</a></li>
							<li><a href="list?p=5">5</a></li>
						</ul>
						<div class="icon-next-pager">다음</div>
					</div>
				</section>
			</section>
			</main>
		</div>
	</div>
	<!-- footer block------------------------------------------------------------------------------------------- -->
<jsp:include page="../../inc/footer.jsp"/>  
</body>

</html>