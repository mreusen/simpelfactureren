<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" modelAttribute="account">
    <input type="hidden" name="_method" value="PUT" />        
    <fieldset>
        <legend><spring:message code="account.personal"/></legend>
        <table>
            <tr>
            	<td><form:label path="roepnaam" cssErrorClass="error"><spring:message code="account.firstname" /></form:label></td>
            	<td><form:input path="roepnaam" /></td>
            	<td><form:errors path="roepnaam"/></td>
            </tr>
            <tr>
            	<td><form:label path="naam" cssErrorClass="error"><spring:message code="account.lastname" /></form:label></td>
            	<td><form:input path="naam" /></td>
            	<td><form:errors path="naam"/></td>
            </tr>
            <tr><td><spring:message code="account.dob" /></td>
            	<td><form:input path="geboorteDatum" />
	                <script type="text/javascript">
	            		Spring.addDecoration(new Spring.ElementDecoration({
	            			elementId : "geboorteDatum",
	            			widgetType : "dijit.form.DateTextBox",
	            			widgetAttrs : { datePattern : "dd-MM-yyyy",
	            			required : true}}));
    	        	</script>
    	        </td>
    	        <td><form:errors path="geboorteDatum"/></td>
    	    </tr>
            <tr>
            	<td><form:label path="adres.straat" cssErrorClass="error"><spring:message code="address.street" /></form:label></td>
            	<td><form:input path="adres.straat" /></td>
            	<td><form:errors path="adres.straat"/></td>
            </tr>
            <tr>
            	<td><form:label path="adres.huisnr" cssErrorClass="error"><spring:message code="address.houseNumber" /></form:label></td>
            	<td><form:input path="adres.huisnr" size="10"/></td>
            	<td><form:errors path="adres.huisnr"/></td>
            </tr>
            <tr>
            	<td><form:label path="adres.huisnrToev" cssErrorClass="error"><spring:message code="address.houseNumberSub" /></form:label></td>
            	<td><form:input path="adres.huisnrToev" size="10" /></td>
            	<td><form:errors path="adres.huisnrToev"/></td>
            </tr>
            <tr>
            	<td><form:label path="adres.postcode" cssErrorClass="error"><spring:message code="address.postalCode" /></form:label></td>
            	<td><form:input path="adres.postcode" size="10" /></td>
            	<td><form:errors path="adres.postcode"/></td>
            </tr>
            <tr>
            	<td><form:label path="adres.plaats" cssErrorClass="error"><spring:message code="address.city" /></form:label></td>
            	<td><form:input path="adres.plaats" /></td>
            	<td><form:errors path="adres.plaats"/></td>
            </tr>
            <tr>
            	<td><form:label path="adres.land" cssErrorClass="error"><spring:message code="address.country" /></form:label></td>
            	<td><form:select path="adres.land" items="${countries}"/></td>
            	<td><form:errors path="adres.land"/></td>
            </tr>
        </table>
    </fieldset>
    <fieldset>
        <legend><spring:message code="account.userinfo"/></legend>
        <table>
            <tr>
            	<td><form:label path="username" cssErrorClass="error"><spring:message code="account.username" /></form:label></td>
            	<td><form:input path="username" /></td>
            	<td><form:errors path="username"/></td>
            </tr>
            <tr>
            	<td><form:label path="emailAdres" cssErrorClass="error"><spring:message code="account.email" /></form:label></td>
            	<td><form:input path="emailAdres" /></td>
            	<td><form:errors path="emailAdres"/></td>
            </tr>
        </table>
    </fieldset>
    <button id="save"><spring:message code="button.save"/></button>
</form:form>
