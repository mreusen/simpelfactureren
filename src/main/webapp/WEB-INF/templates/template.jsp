<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<html>
<head>
    <meta charset="utf-8">
    <c:set var="titleKey">        
        <tiles:getAsString name="title" />
    </c:set>
    <title>Simpel Factureren | <spring:message code="${titleKey}"/></title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" >
    
    <spring:url value="/resources/dijit/themes/tundra/tundra.css"	var="tundraCss" />
    <link type="text/css" rel="stylesheet" href="${tundraCss}" />
    
    <script src="<c:url value="/resources/jquery/jquery-1.7.1.min.js"/>"></script>
    
    <spring:url value="/resources/dojo/dojo.js"	var="dojo" />
    <script type="text/javascript" src="${dojo}"><!----></script>
    <spring:url value="/resources/spring/Spring.js"	var="springJs" />
    <script type="text/javascript" src="${springJs}"> <!----></script>
    <spring:url value="/resources/spring/Spring-Dojo.js" var="springDojo" />
    <script type="text/javascript" src="${springDojo}"><!----></script>

</head>
<body class="tundra">
	<div id="wrap">
		<tiles:insertAttribute name="header"/>

		<div class="center_content">
			<div class="left_content">
				<h1><spring:message code="${titleKey}" text="${titleKey}" /></h1>
				<tiles:insertAttribute name="content" />
			</div><!--end of left content-->

			<div class="right_content">

				<div class="right_box">
<!-- 
					<div class="title">
						<span class="title_icon"><img src="<c:url value="/resources/images/bullet4.gif"/>" alt="" title="" /></span>
						<spring:message code="main.title.randombooks"/>
					</div>
 -->
					<div>
						<br><br>
						<script src="http://widgets.twimg.com/j/2/widget.js"></script>
			
							<script>
			
											new TWTR.Widget({
			
											  version: 2,
			
											  type: 'profile',
			
											  rpp: 5,
			
											  interval: 6000,
			
											  width: 200,
			
											  height: 240,
			
											  theme: {
			
											    shell: {
			
											      background: '#555555',
			
											      color: '#ffffff'
			
											    },
			
											    tweets: {
			
											      background: '#6688ff',
			
											      color: '#ffffff',
			
											      links: '#000000'
			
											    }
			
											  },
			
											  features: {
			
											    scrollbar: false,
			
											    loop: false,
			
											    live: true,
			
											    hashtags: true,
			
											    timestamp: true,
			
											    avatars: false,
			
											    behavior: 'all'
			
											  }
			
											}).render().setUser('reusenit').start();
			
									</script>
					
					</div>

				</div>

			</div><!--end of right content-->

			<div class="clear"></div>

		</div><!--end of center content-->

		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>