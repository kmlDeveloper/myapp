<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9">
	<div class="row">
		<div class="col-md-9"></div>
		<div class="col-md-3">
			<a href="javascript:openArticleModal();" class="btn btn-default">ADD
			</a>
		</div>
	</div>
	&nbsp;
	<div class="row">
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Order No</th>
					<th>Status</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${articleList}" var="data">
					<tr>
						<th scope="row">${data[0]}</th>
						<th>${data[1]}</th>
						<th>${data[2]}</th>
						<td><c:choose>
								<c:when test="${data[3]==1}">
									<i class="fa fa-check-circle" aria-hidden="true"></i>
								</c:when>
								<c:otherwise>
									<i class="fa fa-times-circle" aria-hidden="true"></i>
								</c:otherwise>
							</c:choose></td>
						<td><span><i class="fa fa-edit"
								onclick="editArticle(${data[0]})" aria-hidden="true"></i></span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>


<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Modal Header</h4>
			</div>
			<div class="modal-body">
				<form method="post">
					<input type="hidden" name="articleId" id="articleId" />
					<div class="row">
						<div class="col-md-6">
							<label>Title</label> <input class="form-control" type="text"
								id="title" name="title">
						</div>
						<div class="col-md-6">
							<label>Order No</label> <input class="form-control" type="text"
								id="orderNo" name="orderNo">
						</div>
					</div>
					<div class="row">
						<label>Description</label>
						<div id="article"></div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="addArticle();">Add</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#article').summernote({
			height : 300,
		});
	});
	
	function openArticleModal() {
		document.getElementById("articleId").value="";
		$('#myModal').modal('show');
	}
	
	function editArticle(id) {
		$.ajax({
			type : "GET",
			url : "get-article-by-id.htm", //this is my servlet	data : "input=" + $('#ip').val() + "&output=" + $('#op').val(),
			data : "id=" + id,
			dataType : 'json',
			success : function(data) {
				document.getElementById("title").value=data['title'];
				document.getElementById("orderNo").value=data['orderNo'];
				$("#article").summernote("code", data['article']);
				document.getElementById("articleId").value=id;
				$('#myModal').modal('show');
			}
		});
	}
	
	function addArticle() {
		var id=document.getElementById("articleId").value;
		var title = document.getElementById("title").value;
		var article = $('#article').summernote('code');
		var orderNo = document.getElementById("orderNo").value;

		if (title == null || title == "") {
			alert("Please enter title")
			return;
		}
		if (orderNo == null || orderNo == "") {
			alert("Please enter orderNo")
			return;
		}

		if (article == null || article == "") {
			alert("Please enter article")
			return;
		}
		
		$.ajax({
			type : "post",
			url : "addArticle.htm", //this is my servlet	data : "input=" + $('#ip').val() + "&output=" + $('#op').val(),
			data : {
				'title' : title,
				'article' : jQuery.trim(article),
				'orderNo' : orderNo,
				'id' : id
			},
			success : function(msg) {
				$('#myModal').modal('hide');
				location.reload()
			}
		});
	}
</script>