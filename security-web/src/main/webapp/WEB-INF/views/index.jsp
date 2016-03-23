<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"		uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring"	uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="index.title"/></title>
		<meta name="description" content="description">
		<meta name="author" content="DevOOPS">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="${pageContext.request.contextPath}/plugins/bootstrap/bootstrap.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet">
		<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
		<link href='http://fonts.googleapis.com/css?family=Righteous' rel='stylesheet' type='text/css'>
		<link href="${pageContext.request.contextPath}/plugins/fancybox/jquery.fancybox.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/plugins/fullcalendar/fullcalendar.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/plugins/xcharts/xcharts.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/plugins/select2/select2.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/plugins/justified-gallery/justifiedGallery.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/style_v2.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/plugins/chartist/chartist.min.css" rel="stylesheet">
		<LINK href="${pageContext.servletContext.contextPath }/css/admin.css" type="text/css" rel="stylesheet">
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
				<script src="http://getbootstrap.com/docs-assets/js/html5shiv.js"></script>
				<script src="http://getbootstrap.com/docs-assets/js/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>
	
		<!--Start Header-->
		<div id="screensaver">
			<canvas id="canvas"></canvas>
			<i class="fa fa-lock" id="screen_unlock"></i>
		</div>
		<div id="modalbox">
			<div class="devoops-modal">
				<div class="devoops-modal-header">
					<div class="modal-header-name">
						<span>Basic table</span>
					</div>
					<div class="box-icons">
						<a class="close-link">
							<i class="fa fa-times"></i>
						</a>
					</div>
				</div>
				<div class="devoops-modal-inner">
				</div>
				<div class="devoops-modal-bottom">
				</div>
			</div>
		</div>
		<header class="navbar">
			<div class="container-fluid expanded-panel">
				<div class="row">
					<div id="logo" class="col-xs-12 col-sm-2">
						<a href="index.html"><spring:message code="index.title"/></a>
					</div>
					
					<div id="top-panel" class="col-xs-12 col-sm-10">
						<div class="row">
							<div class="col-xs-8 col-sm-4">
								<div id="search">
									<input type="text" placeholder="search"/>
									<i class="fa fa-search"></i>
								</div>
							</div>
							<div class="col-xs-4 col-sm-8 top-panel-right">
								<a href="#" class="about">about</a>
								<a href="index_v1.html" class="style1"></a>
								<ul class="nav navbar-nav pull-right panel-menu">
									<li class="hidden-xs">
										<a href="index.html" class="modal-link">
											<i class="fa fa-bell"></i>
											<span class="badge">7</span>
										</a>
									</li>
									<li class="hidden-xs">
										<a class="ajax-link" href="ajax/calendar.html">
											<i class="fa fa-calendar"></i>
											<span class="badge">7</span>
										</a>
									</li>
									<li class="hidden-xs">
										<a href="ajax/page_messages.html" class="ajax-link">
											<i class="fa fa-envelope"></i>
											<span class="badge">7</span>
										</a>
									</li>
									<li class="dropdown">
										<a href="#" class="dropdown-toggle account" data-toggle="dropdown">
											<div class="avatar">
												<img src="img/avatar.jpg" class="img-circle" alt="avatar" />
											</div>
											<i class="fa fa-angle-down pull-right"></i>
											<div class="user-mini pull-right">
												<span class="welcome">Welcome,</span>
												<span>Jane Devoops</span>
											</div>
										</a>
										<ul class="dropdown-menu">
											<li>
												<a href="#">
													<i class="fa fa-user"></i>
													<span>Profile</span>
												</a>
											</li>
											<li>
												<a href="ajax/page_messages.html" class="ajax-link">
													<i class="fa fa-envelope"></i>
													<span>Messages</span>
												</a>
											</li>
											<li>
												<a href="ajax/gallery_simple.html" class="ajax-link">
													<i class="fa fa-picture-o"></i>
													<span>Albums</span>
												</a>
											</li>
											<li>
												<a href="ajax/calendar.html" class="ajax-link">
													<i class="fa fa-tasks"></i>
													<span>Tasks</span>
												</a>
											</li>
											<li>
												<a href="#">
													<i class="fa fa-cog"></i>
													<span>Settings</span>
												</a>
											</li>
											<li>
												<a href="<c:url value="j_spring_security_logout" />">
													<i class="fa fa-power-off"></i>
													<span>Logout</span>
												</a>
											</li>
										</ul>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</header>
		<!--End Header-->
		
		<!--Start Container-->
		<div id="main" class="container-fluid">
		
<%-- 		${resources} --%>
		
			<div class="row">
				<div id="sidebar-left" class="col-xs-2 col-sm-2">
					<ul class="nav main-menu">
						<li>
							<a href="ajax/dashboard.html" class="active ajax-link">
								<i class="fa fa-dashboard"></i>
								<span class="hidden-xs"><spring:message code="container.tag.dashboard"/></span>
							</a>
						</li>
						
						<li>
<!-- 							<a href="ajax/left.html" class="active ajax-link"> -->
<!-- 								<i class="fa fa-dashboard"></i> -->
<!-- 								<span class="hidden-xs">用户管理</span> -->
<!-- 							</a> -->
							<c:forEach items="${resources}" var="key" varStatus="stut">
								<c:if test="${key.type eq 0}">
								<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
									<TR height=22>
										<TD class="fa fa-dashboard" style="PADDING-LEFT: 30px"
											background="${pageContext.servletContext.contextPath }/images/main_43.gif">
											<A class=menuParent onclick='expand("${stut.index}")'
												href="javascript:void(0);"><font color="white">${key.name}</font>
											</A>
										</TD>
									</TR>
								</TABLE>
								<TABLE id='child${stut.index}' style="DISPLAY: none" cellSpacing=0
								cellPadding=0 width="100%" border=0>
								<c:forEach items="${resources}" var="k">
								<c:if test="${k.parentId eq key.id}">
								<TR height=20>
									<TD align=middle width=30>
										<IMG height=9 src="${pageContext.servletContext.contextPath }/images/menu_icon.gif" width=9>
									</TD>
									<TD>
										<A class="active ajax-link" href="${pageContext.servletContext.contextPath }${k.resource}" >${k.name}</A>
									</TD>
								</TR>
									</c:if>
							</c:forEach>
							</TABLE>
								</c:if>
							</c:forEach>
						</li>
						
					</ul>
					
					<%--  <table id="123" width="171" height="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td valign="top">
					<table width="100%" height="100%" border="0" cellpadding="0"
						cellspacing="0" style="table-layout: fixed;">
						<tr>
							<td style="width: 3px; background: #0a5c8e;">
								&nbsp;
							</td>
							<td>
								<table width="100%" height="100%" border="0" cellpadding="0"
									cellspacing="0" style="table-layout: fixed;">
									<tr>
										<td height="5" style="line-height: 5px; background: #0a5c8e;">
											&nbsp;
										</td>
									</tr>
									<tr>
										<td height="23" background="${pageContext.servletContext.contextPath }/images/main_29.gif">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td width="40%">
														&nbsp;
													</td>
													<td width="42%">
														<font
															style="height: 1; font-size: 9pt; color: #bfdbeb; filter: glow(color =   #1070a3, strength =   1);font-weight: 600;">后台管理</font>
													</td>
													<td width="18%">
														&nbsp;
													</td>
												</tr>
											</table>
										</td>
									</tr>
									<tr>
										<td bgcolor="#e5f4fd">
											<table width="100%" height="100%" border="0" cellpadding="0"
												cellspacing="0">
												<tr>
													<td valign="top">
														<div align="center">
															<TABLE height="100%" cellSpacing=0 cellPadding=0
																width=170 background="${pageContext.servletContext.contextPath }/images/menu_bg.jpg" border=0>
																<TR>
																	<TD vAlign=top align=middle>

																		
																		<c:forEach items="${resources}" var="key" varStatus="stut">
																			<c:if test="${key.type eq 0}">
																			<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
																				<TR height=22>
																					<TD style="PADDING-LEFT: 30px"
																						background="${pageContext.servletContext.contextPath }/images/main_43.gif">
																						<A class=menuParent onclick='expand("${stut.index}")'
																							href="javascript:void(0);"><font color="white">${key.name}</font>
																						</A>
																					</TD>
																				</TR>
																			</TABLE>
																			<TABLE id='child${stut.index}' style="DISPLAY: none" cellSpacing=0
																			cellPadding=0 width="100%" border=0>
																			<c:forEach items="${resources}" var="k">
																			<c:if test="${k.parentId eq key.id}">
																			<TR height=20>
																				<TD align=middle width=30>
																					<IMG height=9 src="${pageContext.servletContext.contextPath }/images/menu_icon.gif" width=9>
																				</TD>
																				<TD>
																					<A class=menuChild href="${pageContext.servletContext.contextPath }${k.resUrl}" target="main">${k.name}</A>
																				</TD>
																			</TR>
																				</c:if>
																		</c:forEach>
																		</TABLE>
																			</c:if>
																		</c:forEach>
																		
																		

																	</TD>
																	<TD width=1 bgColor=#d1e6f7></TD>
																</TR>
															</TABLE>
														</div>
													</td>

												</tr>
												<tr>
													<td height="23" background="${pageContext.servletContext.contextPath }/images/main_45.gif">
														<table width="100%" border="0" cellspacing="0"
															cellpadding="0">
															<tr>
																<td width="18%">
																	&nbsp;
																</td>
																<td width="64%">
																	<div align="center">
																		<font
																			style="height: 1; font-size: 9pt; color: #bfdbeb; filter: glow(color =   #1070a3, strength =   1)"></font>
																	</div>
																</td>
																<td width="18%">
																	&nbsp;
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td height="9"
														style="line-height: 9px; background: #0a5c8e;">
														&nbsp;
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>  --%>
				</div>
				<!--Start Content-->
				<div id="content" class="col-xs-12 col-sm-10">
					<div id="about">
						<div class="about-inner">
							<h4 class="page-header">Open-source admin theme for you</h4>
							<p>DevOOPS team</p>
							<p>Homepage - <a href="http://devoops.me" target="_blank">http://devoops.me</a></p>
							<p>Email - <a href="mailto:devoopsme@gmail.com">devoopsme@gmail.com</a></p>
							<p>Twitter - <a href="http://twitter.com/devoopsme" target="_blank">http://twitter.com/devoopsme</a></p>
							<p>Donate - BTC 123Ci1ZFK5V7gyLsyVU36yPNWSB5TDqKn3</p>
						</div>
					</div>
					<div class="preloader">
						<img src="img/devoops_getdata.gif" class="devoops-getdata" alt="preloader"/>
					</div>
					<div id="ajax-content"></div>
				</div>
				<!--End Content-->
			</div>
		</div>
		<!--End Container-->
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<!--<script src="http://code.jquery.com/jquery.js"></script>-->
		<script src="${pageContext.request.contextPath}/plugins/jquery/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/jquery-ui/jquery-ui.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="${pageContext.request.contextPath}/plugins/bootstrap/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/justified-gallery/jquery.justifiedGallery.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/tinymce/tinymce.min.js"></script>
		<script src="${pageContext.request.contextPath}/plugins/tinymce/jquery.tinymce.min.js"></script>
		<!-- All functions for this theme + document.ready processing -->
		<script src="${pageContext.request.contextPath}/js/devoops.js"></script>
		
		<SCRIPT language=javascript>
	function expand(el)
	{
		childObj = document.getElementById("child" + el);

		if (childObj.style.display == 'none')
		{
			childObj.style.display = 'block';
		}
		else
		{
			childObj.style.display = 'none';
		}
		return;
	}
</SCRIPT>
	</body>
</html>
