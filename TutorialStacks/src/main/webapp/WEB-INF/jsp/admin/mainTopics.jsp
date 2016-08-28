<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9">
	<div class="row">
		<div class="col-md-9"></div>
		<div class="col-md-3">
			<a href="javascript:addMainTopicModal();" class="btn btn-default">ADD
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
					<th>Status</th>
					<th>Edit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${mainTopicList}" var="data">
					<tr>
						<th scope="row">${data[0]}</th>
						<td>${data[1]}</td>
						<td><c:choose>
								<c:when test="${data[2]==1}">
									<i class="fa fa-check-circle" aria-hidden="true"></i>
								</c:when>
								<c:otherwise>
									<i class="fa fa-times-circle" aria-hidden="true"></i>
								</c:otherwise>
							</c:choose></td>
						<td><span><i class="fa fa-edit"
								onclick="editMainTopic(${data[0]})" aria-hidden="true"></i></span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Modal Header</h4>
			</div>
			<div class="modal-body">
				<form>
					<input type="hidden" name="mainTopicsId" id="mainTopicsId" />
					<div class="row margin-bottom-20">
						<div class="col-md-10">
							<input class="form-control" type="text" id="mainTopics"
								name="mainTopics">
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="submit" onclick="addMainTopics();"
					class="btn btn-primary">Add</button>
			</div>
		</div>
	</div>
</div>


<script type="text/javascript">
	function addMainTopicModal() {
		document.getElementById("mainTopicsId").value="";
		$('#myModal').modal('show');
	}

	function editMainTopic(id) {
		$.ajax({
			type : "GET",
			url : "getMainTopicById.htm", //this is my servlet	data : "input=" + $('#ip').val() + "&output=" + $('#op').val(),
			data : "id=" + id,
			dataType : 'json',
			success : function(data) {
				document.getElementById("mainTopics").value=data['mainTopic'];
				document.getElementById("mainTopicsId").value=id;
				$('#myModal').modal('show');
			}
		});

	}

	function addMainTopics() {
		var mainTopics = document.getElementById("mainTopics").value;
        var id = document.getElementById("mainTopicsId").value;
		if (mainTopics == null || mainTopics == "") {
			alert("Please enter Main Topics")
			return;
		}

		$.ajax({
			type : "post",
			url : "addMainTopics.htm", //this is my servlet	data : "input=" + $('#ip').val() + "&output=" + $('#op').val(),
			data : "mainTopics=" + jQuery.trim(mainTopics)+"&id="+id,
			success : function(msg) {
				$('#myModal').modal('hide');
				location.reload()
			}
		});
	}
</script>