<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="content" class="container">
	<div class="row margin-vert-30">
		<!-- Begin Sidebar Menu -->
		<div class="col-md-3">
			<ul class="list-group sidebar-nav" id="sidebar-nav">
				<c:forEach items="${menuList}" var="data">
					<li class="list-group-item"><a href="${data[1]}"
						onclick="setMainTopicId(${data[0]});">${data[2]}</a></li>
				</c:forEach>

			</ul>
		</div>
		<!-- End Sidebar Menu -->