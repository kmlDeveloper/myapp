<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9">
	<div class="row">
		<div class="col-md-9"></div>
		<div class="col-md-3">
			<a href="javascript:openTopicModal();" class="btn btn-default">ADD
			</a>
		</div>
	</div>
	&nbsp;
	<div class="row">
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Main Topic</th>
					<th>Title</th>
					<th>Url</th>
					<th>Order No</th>
					<th>Status</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${topicList}" var="data">
					<tr>
						<th scope="row">${data[0]}</th>
						<th>${data[2]}</th>
						<th>${data[1]}</th>
						<th>${data[3]}</th>
						<td>${data[4]}</td>
						<td><c:choose>
								<c:when test="${data[5]==1}">
									<i class="fa fa-check-circle" aria-hidden="true"></i>
								</c:when>
								<c:otherwise>
									<i class="fa fa-times-circle" aria-hidden="true"></i>
								</c:otherwise>
							</c:choose></td>
						<td><span><i class="fa fa-edit"
								onclick="editTopic(${data[0]})" aria-hidden="true"></i></span></td>
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
					<input type="hidden" name="topicId" id="topicId" />
					<div class="row">
						<div class="col-md-6">
							<label>Main</label> <select id="mainTopicCombo"
								name="mainTopicCombo" class="form-control">
								<option value="-1">--Main Topics--</option>
								<c:forEach items="${mainTopicMap}" var="data">
									<option value="${data.key}">${data.value}</option>
								</c:forEach>
							</select>
						</div>
						<div class="col-md-6">
							<label>Title</label> <input class="form-control" type="text"
								id="title" name="title">
						</div>
					</div>

					<div class="row">
						<label>Url</label> <input class="form-control" type="text"
							id="topicUrl" name="topicUrl">
					</div>
					<div class="row">
						<label>Order No</label> <input class="form-control" type="text"
							id="orderNo" name="orderNo">
					</div>
					<div class="row">
						<label>Description</label>
						<div id="description"></div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" onclick="addTopics();">Add</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		$('#description').summernote({
			height : 300,
		});
	});
	
	function openTopicModal() {
		document.getElementById("topicId").value="";
		$('#myModal').modal('show');
	}
	
	function editTopic(id) {
		$.ajax({
			type : "GET",
			url : "get-topic-data-by-id.htm", //this is my servlet	data : "input=" + $('#ip').val() + "&output=" + $('#op').val(),
			data : "id=" + id,
			dataType : 'json',
			success : function(data) {
				document.getElementById("mainTopicCombo").value=data['mainTopicId'];
				document.getElementById("title").value=data['title'];
				document.getElementById("topicUrl").value=data['url'];
				document.getElementById("orderNo").value=data['orderNo'];
				$("#description").summernote("code", data['description']);
				document.getElementById("topicId").value=id;
				$('#myModal').modal('show');
			}
		});
	}
	
	function addTopics() {
		var id=document.getElementById("topicId").value;
		var title = document.getElementById("title").value;
		var mainTopicId = document.getElementById("mainTopicCombo").value;
		var description = $('#description').summernote('code');
		var topicUrl = document.getElementById("topicUrl").value;
		var orderNo = document.getElementById("orderNo").value;

		if (title == null || title == "") {
			alert("Please enter title")
			return;
		}

		if (mainTopicId == null || mainTopicId == "" || mainTopicId == "-1") {
			alert("Please select main topics")
			return;
		}

		if (topicUrl == null || topicUrl == "") {
			alert("Please enter topicUrl")
			return;
		}
		if (orderNo == null || orderNo == "") {
			alert("Please enter orderNo")
			return;
		}

		if (description == null || description == "") {
			alert("Please enter description")
			return;
		}
		if (!topicUrl.includes(".htm")) {
			alert("Please enter valid url with .htm")
			return;
		}

		$.ajax({
			type : "post",
			url : "addTopics.htm", //this is my servlet	data : "input=" + $('#ip').val() + "&output=" + $('#op').val(),
			data : {
				'title' : title,
				'mainTopicId' : mainTopicId,
				'description' : jQuery.trim(description),
				'topicUrl' : topicUrl,
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