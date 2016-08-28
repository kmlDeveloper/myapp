<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row  divposter">
	<div class="row" style="margin-top: 180px;">
		<div class="col-md-2"></div>
		<div class="col-md-8">
			<form class="search">
				<input class="searchTerm" autofocus
					placeholder="Enter your search term ..." id="searchTerm"
					name="searchTerm" /><input class="searchButton" type="submit" />
			</form>
		</div>
		<div class="col-md-2"></div>
	</div>
</div>
<div id="content" class="container">
	<div class="row margin-vert-30">
		<div class="col-md-9">
			<c:forEach items="${articleList}" var="data">
				<div class="row">
					<h2>${data[1]}</h2>
					<p>${data[2]}</p>
					<a class="btn btn-default" href="read-more.htm?id=${data[0]}">
						Read More <i class="fa-chevron-right"></i>
					</a>
				</div>
			</c:forEach>
		</div>
		<!-- End Main Text -->
		<!-- Side Column -->
		<div class="col-md-3">
			<h3 class="margin-bottom-10">Sample Menu</h3>
			<ul class="menu">
				<c:forEach items="${articleList}" var="data">
					<li><a class="fa-angle-right" href="#">${data[1]}</a></li>
				</c:forEach>
			</ul>
		</div>
		<!-- End Side Column -->
	</div>
</div>



<script type="text/javascript">
	$(document).ready(function() {
		$('#searchTerm').autoComplete({
			minChars : 1,
			source : function(term, suggest) {
				term = term.toLowerCase();

				$.ajax({
					type : "GET",
					url : "get-searched-list.htm", //this is my servlet	data : "input=" + $('#ip').val() + "&output=" + $('#op').val(),
					data : "term=" + term,
					dataType : 'json',
					success : function(msg) {
						var choices = msg;
						var suggestions = [];
						for (i = 0; i < choices.length; i++) {
							if (~choices[i].toLowerCase().indexOf(term)) {
								suggestions.push(choices[i]);
								suggest(suggestions);
							}
						}
					}
				});

			}
		});
	});
</script>