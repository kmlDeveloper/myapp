<div class="col-md-9">
	<div id="javaBlogDiv" name="javaBlogDiv"></div>
</div>
<input type="hidden" name="topicId" id="topicId" value="${blog}">
<script type="text/javascript">
	$(document).ready(function() {
		getBlogData();
	});
	function getBlogData() {
		var topicId = document.getElementById("topicId").value;
		$.ajax({
			type : "GET",
			url : "blog-data.htm?topicId=" + topicId,
			success : function(msg) {
				$('#javaBlogDiv').html(msg);
			}
		});
	}
</script>
