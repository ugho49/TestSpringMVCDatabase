<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<t:template>
	<jsp:attribute name="content">
        <h1>Add city</h1>

        <form:form action="/addCity" modelAttribute="cityForm" method="post">

            <div class="input-field col s12">
                <form:input path="name" type="text" placeholder="Nom"/>
                <form:errors path="name" cssClass="red-text"/>
            </div>

            <div class="input-field col s12">
                <form:select path="countryCode">
                    <option value="" disabled="disabled" selected="selected">Choisir un pays</option>
                    <c:forEach var="countriesOrder" items="${countries}">
                        <optgroup label="${countriesOrder.key}">
                            <c:forEach var="country" items="${countriesOrder.value}">
                                <c:choose>
                                    <c:when test="${country.code eq cityForm.countryCode}">
                                        <option value="${country.code}" selected="selected">${country.name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${country.code}">${country.name}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </optgroup>
                    </c:forEach>
                </form:select>

                <form:errors path="countryCode" cssClass="red-text"/>
            </div>

            <div class="input-field col s12">
                <form:input path="district" type="text" placeholder="Région"/>
                <form:errors path="district" cssClass="red-text"/>
            </div>

            <div class="input-field col s12">
                <form:input path="population" type="number" placeholder="Population" min="0"/>
                <form:errors path="population" cssClass="red-text"/>
            </div>

            <br>

            <button class="btn waves-effect waves-light" type="submit" name="action">Add
                <i class="material-icons right">add</i>
            </button>
        </form:form>

	</jsp:attribute>
</t:template>