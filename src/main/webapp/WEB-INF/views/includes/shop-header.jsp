<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!-- jstl 포맷라이브러리 추가 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>

  <!-- Basic Page Needs
  ================================================== -->
  <meta charset="utf-8">
  <title>이모티콘샵</title>
  
  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="../resources/images/favicon.png" />
  
  <!-- Themefisher Icon font -->
  <link rel="stylesheet" href="../resources/plugins/themefisher-font/style.css">
  <!-- bootstrap.min css -->
  <link rel="stylesheet" href="../resources/plugins/bootstrap/css/bootstrap.min.css">
  
  <!-- Animate css -->
  <link rel="stylesheet" href="../resources/plugins/animate/animate.css">
  <!-- Slick Carousel -->
  <link rel="stylesheet" href="../resources/plugins/slick/slick.css">
  <link rel="stylesheet" href="../resources/plugins/slick/slick-theme.css">
  
  <!-- Main Stylesheet -->
  <link rel="stylesheet" href="../resources/css/style.css">
  <!-- Profile-detail Stylesheet -->
  <link rel="stylesheet" href="../resources/css/profile-details.css">
  <!-- product-details Styleshhet -->
  <link rel="stylesheet" href="../resources/css/product-details.css">
  <!-- main stylesheet -->
  <link rel="stylesheet" href="../resources/css/style_main.css">
  <!-- jquery -->
  <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#logoutBtn").on("click", function(){
			location.href="/member/logout";
		})
		$("#registerBtn").on("click", function(){
			location.href="/member/register";
		})
		
		$("#memberUpdateBtn").on("click", function(){
			location.href="/member/member-update-view";
		})
		
		$("#memberDeleteBtn").on("click", function(){
			location.href="/member/member-delete-view";
		})
		
	})

	function pointCheck() {
		var span_point = document.getElementById("m_point").innerText;
		var span_price = document.getElementById("p_price").innerText;
		var point = Number(span_point);
		var price = Number(span_price);
		
		if (point >= price) {
			var afterPoint = (point-price);
			var testPoint = afterPoint.toString();
			var x = document.getElementsByClassName("afterpoint")[0];
			x.innerText = testPoint;	
		}
	}
	
</script>
</head>
<body id="body" onload="pointCheck()">
<div id="wrap">
	<!-- Start Top Header Bar -->
<section class="top-header">
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-xs-12 col-sm-4"></div>
			<div class="col-md-4 col-xs-12 col-sm-4">
				<!-- Site Logo -->
				<div class="logo text-center">
					<a href="/shop/">
						<!-- replace logo here -->
						<svg width="210px" height="30px" viewBox="0 0 300 30" version="1.1" xmlns="http://www.w3.org/2000/svg"
							xmlns:xlink="http://www.w3.org/1999/xlink">
							<g id="Page-1" stroke="none" stroke-width="1" fill="none" fill-rule="evenodd" font-size="41"
								font-family="AustinBold, Austin" font-weight="bold">
								<g id="Group" transform="translate(-108.000000, -297.000000)" fill="#000000">
									<text id="AVIATO">
										<tspan x="108.94" y="325">Emoticon<tspan font-weight="500">Shop</tspan></tspan>
									</text>
								</g>
							</g>
						</svg>
					</a>
				</div>
			</div>
			<div class="col-md-4 col-xs-12 col-sm-4">
				<!-- Cart -->
				<ul class="top-menu text-right list-inline">
				<c:if test="${member.m_access == 1}">
					<!-- Admin -->
					<li>
						<a href="/admin/">Admin</a>
					</li><!-- / Admin -->
					</c:if>
					<!-- Search -->
					<li class="dropdown search dropdown-slide">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"  style="font-size: medium;"><i
								class="tf-ion-ios-search-strong"></i>&nbsp;Search</a>
						<ul class="dropdown-menu search-dropdown">
							<li>
								<form action="post"><input type="search" class="form-control" placeholder="이모티콘 검색"></form>
							</li>
						</ul>
					</li><!-- / Search -->
					<!-- My -->
					<!-- session null일 경우 login page로 이동-->
					<!--
						<li class="dropdown cart-nav dropdown-slide">
						<a href="login.jsp" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown"><i
							class="tf-ion-android-person"></i>&nbsp;My</a>
					-->
					 <li class="dropdown profile-nav dropdown-slide">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" style="font-size: medium;"><i
								class="tf-ion-android-person"></i>&nbsp;My</a>
						<div class="dropdown-menu profile-dropdown">
							<!-- info -->
							
							<div class="media">
								<div class="media-body">
								<c:if test="${member == null}">
							<p>로그인 해주세요</p>
							<ul class="text-center profile-buttons">
								<li><a href="/member/login">로그인</a></li>
							</c:if>
							<c:if test="${member != null }">
									<div class="profile">
										&nbsp;<h4>${member.m_id}님</h4>
									</div>&nbsp;&nbsp;
									<h5>${member.m_email}</h5>
								</div>
								<ul class="text-center profile-buttons">
								<li><button id="logoutBtn" type="button"  class="btn btn-small" style="font-size: small;">로그아웃</button></li>
								<li><a href="/member/profile-details?m_id=${member.m_id}" class="btn btn-small" style="font-size: small;">마이페이지</a></li>
								</c:if>
							</ul>
								
							</div><!-- / info -->
							<ul class="text-center profile-buttons">
								
								
							
							</ul>
						</div>
					</li><!-- / My -->
				</ul><!-- / .nav .navbar-nav .navbar-right -->
			</div>
			

		</div>
	</div>
</section><!-- End Top Header Bar -->

