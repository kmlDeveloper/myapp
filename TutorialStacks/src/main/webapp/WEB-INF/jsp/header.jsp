<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="pre_header" class="visible-lg"></div>
<div id="header" class="container">
	<div class="row">
		<!-- Logo -->
		<div class="logo">
			<a href="home.htm" title=""> <img src="images/logo.jpg"
				alt="Logo" height="100px" width="300px" />
			</a>
		</div>
		<!-- End Logo -->
		<!-- Top Menu -->
		<div class="col-md-12 margin-top-30">
			<div id="hornav" class="pull-right visible-lg">
				<ul class="nav navbar-nav">
					<li><a href="home.htm">HOME</a></li>
					<li><a href="html-home.htm">HTML</a></li>
					<li><a href="javascript-home.htm">JAVA SCRIPT</a></li>
					<li><a href="java-home.htm">JAVA  kml</a></li>
					<li><a href="article-home.htm">ARTICLE</a></li>
					<c:if test="${sessionScope.userId!=null}">
						<li><a href="main.topics.htm">ADMIN</a></li>
						<li><a href="admin.logout.htm">LOG OUT</a></li>
					</c:if>
				</ul>
			</div>
		</div>
		<div class="clear"></div>
		<!-- End Top Menu -->
	</div>
</div>