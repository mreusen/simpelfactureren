<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="GET" modelAttribute="klantSearchCriteria">
	<fieldset>
		<legend><spring:message code="klant.searchcriteria"/></legend>
		<table>
			<tr>
				<td><form:label path="naam"><spring:message code="klant.name" /></form:label></td>
				<td><form:input path="naam" /></td>
			</tr>
			<tr>
				<td><form:label path="plaats"><spring:message code="klant.city" /></form:label></td>
				<td><form:input path="plaats" /></td>
			</tr>
		</table>
    </fieldset>

    <button id="search"><spring:message code="button.search"/></button>
</form:form>
<script type="text/javascript">
	document.getElementById("naam").focus();
</script>
<c:if test="${not empty klantList}">
	<table>
		<tr>
			<th><spring:message code="klant.name"/></th>
			<th>&nbsp</th>
			<th><spring:message code="klant.address"/></th>
			<th>&nbsp</th>
			<th><spring:message code="klant.city"/></th>
		</tr>
		<c:forEach items="${klantList}" var="klant">
			<tr>
				<td><a href="<c:url value="/klant/detail/${klant.id}"/>">${klant.naam}</a></td>
				<td>&nbsp</td>
				<td>${klant.adres.straat} ${klant.adres.huisnr}${klant.adres.huisnrToev}</td>
				<td>&nbsp</td>
				<td>${klant.adres.plaats}</td>
			</tr>
		</c:forEach>
		<tr><td colspan="5" height="20">&nbsp</td></tr>
		<tr>
			<td colspan="5" align="center">
				<form:form method="GET">
					<input type="submit" name="action" class="button"  value=<spring:message code="button.nieuwe_klant"/> >
				</form:form>
			</td>
		</tr>
	</table>
</c:if>
