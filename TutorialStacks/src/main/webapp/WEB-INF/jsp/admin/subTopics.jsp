<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Main Column -->
<div class="col-md-9">
	<!-- Main Content -->
	<!-- Contact Form -->
	<form method="post">
		<label>Name</label>
		<div class="row">
			<div class="col-md-4">
				<input class="form-control" type="text" id="subTopics"
					name="subTopics">
			</div>
			<div class="col-md-4">
				<select id="mainTopicCombo" class="form-control"
					name="mainTopicCombo">
					<option value="-1">--Main Topics--</option>
					<c:forEach items="${mainTopicMap}" var="data">
						<option value="${data.key}">${data.value}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-2">
				<button type="button" class="btn btn-primary"
					onclick="addSubTopics();">Add</button>
			</div>
		</div>

	</form>
</div>

<script type="text/javascript">
	function addSubTopics() {
		var subTopics = document.getElementById("subTopics").value;
		var mainTopicId = document.getElementById("mainTopicCombo").value;

		if (subTopics == null || subTopics == "") {
			alert("Please enter sub topics")
			return;
		}

		if (mainTopicId == null || mainTopicId == "" || mainTopicId == "-1") {
			alert("Please select main topics")
			return;
		}

		$.ajax({
			type : "post",
			url : "addSubTopics.htm", //this is my servlet	data : "input=" + $('#ip').val() + "&output=" + $('#op').val(),
			data : "subTopics=" + subTopics + "&mainTopicId=" + mainTopicId,
			success : function(msg) {
			}
		});
	}
</script>