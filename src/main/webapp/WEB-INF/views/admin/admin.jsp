<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<%@ include file="../includes/admin-header.jsp"%>
<main id="main" class="main">
	<div class="mt-3 pagetitle">
		<h4>전체 조회</h4>
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="#">홈</a>
				<li class="breadcrumb-item active">메인화면</li>
			</ol>
		</nav>
	</div>
	<!-- end page title -->
	<section class="section dashboard">
		<div class="row">
			<!-- Left side columns -->
			<div class="col-lg-12">
				<div class="row">
					<!-- Top Selling -->
					<div class="col-12">
						<div class="card top-selling overflow-auto">
							<div class="py-2 card-body pb-0">
								<h5 class="card-title">
									판매 목록<span>| 이모티콘 샵</span>
								</h5>
								<table class="table table-boardrless">
									<thead>
										<tr>
											<th class="px-5" scope="col">No.</th>
											<th class="px-5" scope="col">Preview</th>
											<th class="px-5" scope="col">Title</th>
											<th class="px-5" scope="col">Creator</th>
											<th class="px-5" scope="col">Price</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${plist}" var="product">
											<tr>
												<td class="px-5" scope="row"><a
													href="product-get?p_no=${product.p_no}"
													class="text-primary fw-bold">&nbsp;<c:out
															value="${product.p_no}" /></a></td>
												<th class="px-5"><a
													href="product-get?p_no=${product.p_no}"><img
														src="../resource/preview/<c:out value="${product.p_image}"/>"
														alt=""></a></th>
												<td class="px-5"><a
													href="product-get?p_no=${product.p_no}"
													class="text-primary fw-bold"><c:out
															value="${product.p_name}" /></a></td>
												<td class="px-5" class="fw-bold"><c:out
														value="${product.p_creator}" /></td>
												<td class="px-5"><c:out value="${product.p_price }" /></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- end Top Selling -->
					<!-- Recent Sales -->
					<div class="col-12">
						<div class="card recent-sales overflow-auto">
							<div class="py-2 card-body">
								<h5 class="card-title">
									회원 등록<span>| 이모티콘샵</span>
								</h5>
								<table class="table table-boarderless">
									<thead>
										<tr>
											<th class="px-5" scope="col">No.</th>
											<th class="px-5" scope="col">ID</th>
											<th class="px-5" scope="col">Name</th>
											<th class="px-5" scope="col">Email</th>
											<th class="px-5" scope="col">Point</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${mlist}" var="member">
											<tr>
												<th class="px-5" scope="row"><a
													href="member-get?m_no=${member.m_no}">&nbsp;<c:out
															value="${member.m_no}" /></a></th>
												<td class="px-5"><a
													href="member-get?m_no${member.m_no}"><c:out
															value="${member.m_no}" /></a></td>
												<td class="px-5"><c:out value="${member.m_name}" /></td>
												<td class="px-5"><c:out value="${member.m_email}" /></td>
												<td class="px-5"><span class="badge bg-dark"><c:out
															value="${member.m_point}" /></span></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
					<!-- End Recent Sales -->
				</div>
			</div>
			<!-- End Left side columns -->
		</div>
	</section>
</main>
<!-- End #main -->
<%@ include file="../includes/admin-footer.jsp"%>
</body>
</html>