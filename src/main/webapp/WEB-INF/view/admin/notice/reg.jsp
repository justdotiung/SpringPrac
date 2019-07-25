<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
</section>

<section>
	<h1>공지사항 내용</h1>
	<form action="reg?${_csrf.parameterName}=${_csrf.token}" method="post" enctype="multipart/form-data">
		<table>
			<tbody>
				<tr>
					<th>카테고리</th>
					<td><select name="category">
							<option value="학습">학습</option>
							<option value="결제">결제</option>
							<option value="기타">기타</option>
					</select></td>
				</tr>
				<!-- key값의 중복 방법 (name) -->
				<tr>
					<th>제목</th>
					<td><input name="title"></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td><input type="file" name="file"></td>
				</tr>

				<tr>
					<th>내용</th>
					<td><textarea name="content"></textarea></td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="저장"> <a href="list">취소</a>
	</form>
</section>

</main>
