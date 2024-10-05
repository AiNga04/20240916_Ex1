<%--
  Created by IntelliJ IDEA.
  User: Nga
  Date: 10/5/2024
  Time: 11:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<c:url value="/" var="URL"></c:url>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Metronic Frontend (Header Fixed)</title>

    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <meta content="Metronic Shop UI description" name="description">
    <meta content="Metronic Shop UI keywords" name="keywords">
    <meta content="keenthemes" name="author">

    <meta property="og:site_name" content="-CUSTOMER VALUE-">
    <meta property="og:title" content="-CUSTOMER VALUE-">
    <meta property="og:description" content="-CUSTOMER VALUE-">
    <meta property="og:type" content="website">
    <meta property="og:image" content="-CUSTOMER VALUE-"><!-- link to image for socio -->
    <meta property="og:url" content="-CUSTOMER VALUE-">

    <link rel="shortcut icon" href="favicon.ico">

    <!-- Fonts START -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all"
          rel="stylesheet" type="text/css">
    <!-- Fonts END -->

    <!-- Global styles START -->
    <link href="${URL}assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <link href="${URL}assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Global styles END -->

    <!-- Page level plugin styles START -->
    <link href="${URL}assets/global/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
    <link href="${URL}assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.css" rel="stylesheet">
    <link href="${URL}assets/global/plugins/slider-revolution-slider/rs-plugin/css/settings.css" rel="stylesheet">
    <!-- Page level plugin styles END -->

    <!-- Theme styles START -->
    <link href="${URL}assets/global/css/components.css" rel="stylesheet">
    <link href="${URL}assets/frontend/layout/css/style.css" rel="stylesheet">
    <link href="${URL}assets/frontend/pages/css/style-revolution-slider.css" rel="stylesheet">
    <!-- metronic revo slider styles -->
    <link href="${URL}assets/frontend/layout/css/style-responsive.css" rel="stylesheet">
    <link href="${URL}assets/frontend/layout/css/themes/red.css" rel="stylesheet" id="style-color">
    <link href="${URL}assets/frontend/layout/css/custom.css" rel="stylesheet">
    <!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="corporate">
<!-- BEGIN STYLE CUSTOMIZER -->
<div class="color-panel hidden-sm">
    <div class="color-mode-icons icon-color"></div>
    <div class="color-mode-icons icon-color-close"></div>
    <div class="color-mode">
        <p>THEME COLOR</p>
        <ul class="inline">
            <li class="color-red current color-default" data-style="red"></li>
            <li class="color-blue" data-style="blue"></li>
            <li class="color-green" data-style="green"></li>
            <li class="color-orange" data-style="orange"></li>
            <li class="color-gray" data-style="gray"></li>
            <li class="color-turquoise" data-style="turquoise"></li>
        </ul>
    </div>
</div>
<!-- END BEGIN STYLE CUSTOMIZER -->

<%--HEADER--%>
<%@include file="../../common/user/header.jsp"%>
<%--END HEADER--%>

<!-- BEGIN SLIDER -->
    <%@include file="../../common/user/slider.jsp"%>
<!-- END SLIDER -->

<div class="main">
    <div class="container">
        <sitemesh:write property = "body"/>
    </div>
</div>

<!-- BEGIN FOOTER -->
<%@include file="../../common/user/footer.jsp"%>
<!-- END FOOTER -->


<!-- Load javascripts at bottom, this will reduce page load time -->
<!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
<!--[if lt IE 9]>
<script src="${URL}assets/global/plugins/respond.min.js"></script>
<![endif]-->
<script src="${URL}assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="${URL}assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
<script src="${URL}assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${URL}assets/frontend/layout/scripts/back-to-top.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->

<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
<script src="${URL}assets/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script>
<!-- pop up -->
<script src="${URL}assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js"
        type="text/javascript"></script><!-- slider for products -->

<!-- BEGIN RevolutionSlider -->

<script src="${URL}assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.plugins.min.js"
        type="text/javascript"></script>
<script src="${URL}assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js"
        type="text/javascript"></script>
<script src="${URL}assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js"
        type="text/javascript"></script>
<script src="${URL}assets/frontend/pages/scripts/revo-slider-init.js" type="text/javascript"></script>
<!-- END RevolutionSlider -->

<script src="${URL}assets/frontend/layout/scripts/layout.js" type="text/javascript"></script>
<script type="text/javascript">
    jQuery(document).ready(function () {
        Layout.init();
        Layout.initOWL();
        RevosliderInit.initRevoSlider();
        Layout.initTwitter();
        Layout.initFixHeaderWithPreHeader(); /* Switch On Header Fixing (only if you have pre-header) */
        Layout.initNavScrolling();
    });
</script>
<!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>