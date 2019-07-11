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
<!-- /member/notice/list -->
<script src="../../JS/notice/list.js"></script>
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
						<style>
							.even{
								background: beige;
							}
						</style>
	<!--
	 복제방법2 (로우를 만들기위한 하나의 틀 생성) 레코드가 없는경우도 있기때문에 템플릿을 만든다.
		스크립트에서 필요한 템플릿을 만든다 tr을 직접 복제하는방법
		ex1은 뉴렉사이트와 맞지않기에 이방법을 사용한다 tr이 없을수도 있고 첫번째 자식이 tr아닐수도 있기때문이다
		-->
						<template class="notice-template">
							<tr>
								<td class="num"></td>
								<td class="title">
									<a href="detail?id="></a>
									<span></span>
									<span><a href="list?eid=">수정</a><a href="">삭제</a></span>
								</td>
								<td class="writer"></td>
								<td class="date"></td>
								<td class="hit"></td>
							</tr>
						</template>
						<tbody>
						
							<c:forEach var="n" items="${list}" varStatus="s">
							<c:if test="${s.index%2!=0}">
								<tr>
							</c:if>
							<c:if test="${s.index%2==0}">
								<tr class="even">
 							</c:if>
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
								<!-- 마지막결과물 서버코드가 사라진 상태로 동작하게 만들어야 한다  -->
							</c:forEach>
							<tr>
								<td colspan="5">-----------------------------------------------------------</td>
							</tr>
							<!-- <c:forEach var="n" items="${list}" begin="4" end="7" varStatus="s">
								<tr>
									<td class="num">${n.id}</td>
									<td class="title">
										<a href="detail?id=${n.id}">${s.index}/${s.current.id} : ${n.title}</a>
										<span>${n.commentCount}</span>
										<span><a href="list?eid=${n.id}">수정</a><a href="">삭제</a></span>
									</td>
									<td class="writer">${n.writherId}</td>
									<td class="date">${n.date}</td>
									<td class="hit">${n.hit}</td>
								</tr>
								
							</c:forEach> -->
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
				
				<div id="test-pager">
					<input type="text" value="1">
					<input type="button" value="요청">
				</div>
				<div id="test-remove">
					<label>삭제할 게시글 id</label><input type="text" value="1">
					<input type="button" value="삭제">
				</div>
				
				<!-- 1,6,11,16,21,....-> page + total 레코드 수 -> 마지막 번호 
               
               page : 1     start ==> 1
               page : 13     start ==> 11
               page : 44     start ==> 41
               page : 39     start ==> 36 
               
               page : 1~5    :=> 1
               page : 6~10    :=> 6
               
               start =page - (page%5-1)
               ${page - ((page%5 == 0)? page%5+4:page%5-1)}
              
               
               -->
				<c:set var="page" value="${(empty param.p) ? 1 : param.p}"/>
				<c:set var="start" value="${page - (page-1)%5}"/>
				
				<section id="pager">
					<h1 class="d-none">페이지</h1>
					<div>
					<div><a href="list1?p=${(page<6)?page:page-5}">이전</a></div>
						<div ><a href ="list?p=${(start==1)?1:start-1}">이전</a></div>
						<ul>
						<c:forEach var="n" begin="${start}" end="${start+4}" varStatus="s">
							<li><a href="list?p=${n}">${n}</a></li>
						</c:forEach>
							
						</ul>
						<div ><a href ="list?p=${start+5}">다음</a></div>
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