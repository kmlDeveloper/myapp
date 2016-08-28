<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="col-md-9">
	<div id="blogDiv" name="blogDiv"></div>
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
				$('#blogDiv').html(msg);
			}
		});
	}
</script>
