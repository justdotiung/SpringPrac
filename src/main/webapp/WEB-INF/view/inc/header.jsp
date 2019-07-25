<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<c:set var="ctxName" value="${pageContext.request.contextPath}"/>
<%--
방법 url을 얻어내는 태그 별로 좋지않다.
 <c:url var="lo" value="/logout"/>
<div>
	${lo}
</div>

 --%>

 
<header id="header">
		<!-- <div style="background: blue; width: 100px;">asdwe</div> -->
		<div class="content-box">
			<h1 id="logo">뉴렉처 온라인</h1>

			<section id="header-list">
				<h1 class="d-none">머릿말</h1>
				<nav id="main-menu">
					<h1 class="d-none">메인 메뉴</h1>
					<ul class="menu-list">
						<li><a href="">학습가이드</a></li>
						<li><a href="">강좌선택</a></li>
						<li><a href="">AnswerIs</a></li>
					</ul>
				</nav>
				<section id="lecture-search-form">
					<h1 class="d-none">강좌검색 폼</h1>
					<form action="" class="menu-list">
						<label for="">과정검색</label> <input type="text"> <input
							type="submit" value="검색">
					</form>
				</section>
				<nav id="member-menu">
					<h1 class="d-none">회원메뉴</h1>
					<ul class="menu-list">
						<li><a href="">HOME</a></li>
						<!--인클루드는 상대경로를 쓸수없다. 왜냐하면 인클루드 파일이기 때문에 어디에 붙을지 모른다  -->
						<li>
						<security:authorize access="hasRole('ADMIN')">
							관리자만 볼수있는 내용
						</security:authorize>
						<security:authorize access="isAuthenticated()">
							알다
							<%-- <a href="${ctxName}/logout">로그아웃</a> --%>
							<form action="${ctxName}/member/logout" method="post">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<input type="submit" value="로그아웃">
							</form>
						</security:authorize>
						<security:authorize access="!isAuthenticated()">
							멍청이
							<a href="${ctxName}/member/login">로그인</a>
						</security:authorize>
						</li>
						<li><a href="${ctxName}/member/join">회원가입</a></li>
					</ul>
				</nav>
				<nav id="direct-menu">
					<h1 class="d-none">자주사용하는 메뉴</h1>
					<ul>
						<li>마이페이지</li>
						<li>고객센터</li>
					</ul>
				</nav>
			</section>
	</div>
	</header>