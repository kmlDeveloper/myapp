<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="content" class="container">
	<div class="row margin-vert-30">
		<!-- Main Column -->
		<div class="col-md-9">
			<!-- Blog Post -->
			<c:forEach items="${articleList}" var="data">
				<div class="blog-post padding-bottom-20">
					<!-- Blog Item Header -->

					<div class="blog-item-header">
						<!-- Date -->
						<div class="blog-post-date pull-left">
							<span class="day">14</span> <span class="month">Dec</span>
						</div>
						<!-- End Date -->
						<!-- Title -->
						<h2>
							<a href="#">${data[1]}</a>
						</h2>
						<div class="clearfix"></div>
						<!-- End Title -->
					</div>
					<!-- End Blog Item Header -->
					<!-- Blog Item Details -->
					<div class="blog-post-details">
						<!-- Author Name -->
						<div
							class="blog-post-details-item blog-post-details-item-left user-icon">
							<i class="fa fa-user"></i> <a href="#">Admin</a>
						</div>
						<!-- End Author Name -->
						<!-- Tags -->
						<div
							class="blog-post-details-item blog-post-details-item-left blog-post-details-tags tags-icon">
							<i class="fa fa-tag"></i> <a href="#">jQuery</a> , <a href="#">CSS</a>
							, <a href="#">Grunt</a>
						</div>
						<!-- End Tags -->
						<!-- # of Comments -->
						<div
							class="blog-post-details-item blog-post-details-item-left blog-post-details-item-last comments-icon">
							<a href="#"> <i class="fa fa-comments"></i> 3 Comments
							</a>
						</div>
						<!-- End # of Comments -->
					</div>
					<!-- End Blog Item Details -->
					<!-- Blog Item Body -->
					<div class="blog">
						<div class="clearfix"></div>
						<div class="blog-post-body row margin-top-15">
							<div class="col-md-5">
								<img class="pull-left" src="assets/img/blog/image1.jpg"
									alt="thumb1">
							</div>
							<div class="col-md-7">
								<p>${data[2]}</p>
								<!-- Read More -->
								<a href="#" class="btn btn-primary"> Read More <i
									class="icon-chevron-right readmore-icon"></i>
								</a>
								<!-- End Read More -->
							</div>
						</div>
					</div>
					<!-- End Blog Item Body -->
				</div>
			</c:forEach>
			<!-- End Blog Item -->
			<ul class="pagination">
				<li><a href="#">&laquo;</a></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">&raquo;</a></li>
			</ul>
			<!-- End Pagination -->
		</div>
		<!-- End Main Column -->
		<!-- Side Column -->
		<div class="col-md-3">
			<!-- Blog Tags -->
			<div class="blog-tags">
				<h3>Tags</h3>
				<ul class="blog-tags">
					<li><a href="html-home.htm" class="blog-tag">HTML</a></li>
					<li><a href="javascript-home.htm" class="blog-tag">JavaScript</a></li>
					<li><a href="java-home.htm" class="blog-tag">Java</a></li>
					<li><a href="article-home.htm" class="blog-tag">Article</a></li>

				</ul>
			</div>
			<!-- End Blog Tags -->
			<!-- Recent Posts -->
			<div class="recent-posts">
				<h3>Recent Posts</h3>
				<ul class="posts-list margin-top-10">
					<c:forEach items="${articleList}" var="data">
						<li>
							<div class="recent-post">
								<a href="#"> <img class="pull-left"
									src="assets/img/blog/thumbs/thumb1.jpg" alt="thumb1">
								</a> <a href="#" class="posts-list-title">${data[1]} </a>
								<br> <span class="recent-post-date"> July 30, 2013 </span>
							</div>
							<div class="clearfix"></div>
						</li>
					</c:forEach>
				</ul>
			</div>
			<!-- End Recent Posts -->
		</div>
		<!-- End Side Column -->
	</div>
</div>