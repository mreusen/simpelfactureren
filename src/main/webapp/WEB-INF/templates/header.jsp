<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div class="header">
    <c:url value="/index.htm" var="homeUrl"/>
    <div class="logo"><a href="http://www.ReusenIT.nl" target="new"><img src="<c:url value="/resources/images/logo.gif"/>" alt="" title="" border="0"/></a></div>
    <div class="nav">
        <ul style="float: left;">
            <li><a href="${homeUrl}"><spring:message code="nav.home"/></a></li>
            <c:if test="${sessionScope.account ne null}">
            	<li><spring:url value="/createFactuur" var="var_createFactuur" />
            		<a href="${var_createFactuur}"><spring:message code="nav.facturen"/></a>
            	</li>
            </c:if>
            <li><a href="<c:url value="/factuur/search"/>"><spring:message code="nav.factuur"/></a></li>
			<li><a href="<c:url value="/klant/search"/>"><spring:message code="nav.klant"/></a></li>
            <li><a href="<c:url value="/bedrijf/detail"/>"><spring:message code="nav.bedrijf"/></a></li>
            <li><a id="account" href="<c:url value="/account/account"/>"><spring:message code="nav.account"/></a></li>
            <c:if test="${sessionScope.account eq null}">
                <li><a href="<c:url value="/account/register"/>"><spring:message code="nav.register"/></a></li>
                <li><a id="login" href="<c:url value="/login"/>"><spring:message code="nav.login"/></a></li>
            </c:if>            
            <c:if test="${sessionScope.account ne null}">
                <li><a href="<c:url value="/logout"/>"><spring:message code="nav.logout"/> [${sessionScope.account.username}]</a></li>
            </c:if>
        </ul>
        <ul style="float: right;">
            <li><a href="?lang=en"><img src="<c:url value="/resources/images/gb.gif"/>" alt="" title="" border="0" /></a></li>
            <li><a href="?lang=nl" class="selected"><img src="<c:url value="/resources/images/nl.gif"/>" alt="" title="" border="0" /></a></li>
            <li>&nbsp</li>
            <li>&nbsp</li>
            <li>&nbsp</li>
            <li>&nbsp</li>
        </ul>
    </div>     

</div>