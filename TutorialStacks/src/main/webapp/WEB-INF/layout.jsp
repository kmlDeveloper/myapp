<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
<title><tiles:insertAttribute name="title" /></title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1" />
<!-- Favicon -->
<link href="favicon.html" rel="shortcut icon">

<style type="text/css">
.divposter {
	background-image: url('images/library.jpg');
	height: 60%;
}
</style>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet" href="assets/css/bootstrap.css" rel="stylesheet">
<!-- Template CSS -->
<link rel="stylesheet" href="assets/css/animate.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/font-awesome.css"
	rel="stylesheet">
<link rel="stylesheet" href="assets/css/nexus.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/responsive.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/custom.css" rel="stylesheet">

<!-- Google Fonts-->
<link href="http://fonts.googleapis.com/css?family=Lato:400,300"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans:400,300"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/jquery.auto-complete.css"
	rel="stylesheet">
<link rel="stylesheet" href="assets/summernote/summernote.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/customTutorialStacks.css"
	rel="stylesheet">
</head>
<body>
	<!-- header and menu -->
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />

	<!--  scripts start -->
	<script type="text/javascript" src="assets/js/jquery.min.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="assets/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="assets/js/scripts.js"></script>
	<!-- Isotope - Portfolio Sorting -->
	<script type="text/javascript" src="assets/js/jquery.isotope.js"
		type="text/javascript"></script>
	<!-- Mobile Menu - Slicknav -->
	<script type="text/javascript" src="assets/js/jquery.slicknav.js"
		type="text/javascript"></script>
	<!-- Animate on Scroll-->
	<script type="text/javascript" src="assets/js/jquery.visible.js"
		charset="utf-8"></script>
	<!-- Slimbox2-->
	<script type="text/javascript" src="assets/js/slimbox2.js"
		charset="utf-8"></script>
	<!-- Modernizr -->
	<script type="text/javascript" src="assets/js/modernizr.custom.js"></script>

	<!-- custom  js -->
	<script type="text/javascript" src="assets/summernote/summernote.js"></script>
	<script type="text/javascript" src="js/jquery.auto-complete.js"></script>
	<script type="text/javascript" src="js/TutorialStacks.js"></script>

	<!--  scripts end -->

	<!--  body and footer -->
	<tiles:insertAttribute name="body" />
	<tiles:insertAttribute name="footer" />


</body>
</html>