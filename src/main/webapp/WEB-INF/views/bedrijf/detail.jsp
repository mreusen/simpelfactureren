<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form method="POST" modelAttribute="bedrijf">
	<input type="hidden" name="_method" value="PUT" />
	<form:input type="hidden" path="id" />
	<fieldset>
		<legend><spring:message code="bedrijf.info"/></legend>
		<table>
			<tr>
				<td><form:label path="naam" cssErrorClass="error"><spring:message code="bedrijf.name" /></form:label></td>
				<td><form:input path="naam" /></td>
				<td><form:errors path="naam"/></td>
			</tr>
			<tr>
				<td><form:label path="adres.straat" cssErrorClass="error"><spring:message code="address.street" /></form:label></td>
				<td><form:input path="adres.straat" /></td>
				<td><form:errors path="adres.straat"/></td>
			</tr>
			<tr>
				<td><form:label path="adres.huisnr" cssErrorClass="error"><spring:message code="address.houseNumber" /></form:label></td>
				<td><form:input path="adres.huisnr" size="10" /></td>
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
				<td><form:select path="adres.land" items="${countries}"/></td><td><form:errors path="adres.land"/></td></tr>
			<tr>
				<td><form:label path="emailAdres" cssErrorClass="error"><spring:message code="bedrijf.email" /></form:label></td>
				<td><form:input path="emailAdres" /></td>
				<td><form:errors path="emailAdres"/></td>
			</tr>
			<tr>
				<td><form:label path="telefoonnr" cssErrorClass="error"><spring:message code="bedrijf.telefoonnr" /></form:label></td>
				<td><form:input path="telefoonnr" /></td>
				<td><form:errors path="telefoonnr"/></td>
			</tr>
			<tr>
				<td><form:label path="bankrelatie" cssErrorClass="error"><spring:message code="bedrijf.bankrel" /></form:label></td>
				<td><form:input path="bankrelatie" /></td>
				<td><form:errors path="bankrelatie"/></td>
			</tr>
			<tr>
				<td><form:label path="bankRekeningnr" cssErrorClass="error"><spring:message code="bedrijf.banknum" /></form:label></td>
				<td><form:input path="bankRekeningnr" /></td>
				<td><form:errors path="bankRekeningnr"/></td>
			</tr>
			<tr>
				<td><form:label path="ibannr" cssErrorClass="error"><spring:message code="bedrijf.iban" /></form:label></td>
				<td><form:input path="ibannr" /></td>
				<td><form:errors path="ibannr"/></td>
			</tr>
			<tr>
				<td><form:label path="kvknr" cssErrorClass="error"><spring:message code="bedrijf.kvknum" /></form:label></td>
				<td><form:input path="kvknr" size="10" /></td>
				<td><form:errors path="kvknr"/></td>
			</tr>
			<tr>
				<td><form:label path="btwnr" cssErrorClass="error"><spring:message code="bedrijf.btwnum" /></form:label></td>
				<td><form:input path="btwnr" /></td>
				<td><form:errors path="btwnr"/></td>
			</tr>
		</table>
	</fieldset>
	<button id="save"><spring:message code="button.save"/></button>
</form:form>
