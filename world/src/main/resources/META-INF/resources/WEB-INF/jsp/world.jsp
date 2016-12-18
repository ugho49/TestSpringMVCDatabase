<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template>
	<jsp:attribute name="content">
        <c:if test="${not empty countries}">
            <div class="input-field col s12">
                <select>
                    <option value="" disabled selected>Countries</option>

                    <c:forEach var="countriesOrder" items="${countries}">
                        <optgroup label="${countriesOrder.key}">
                            <c:forEach var="country" items="${countriesOrder.value}">
                                <option value="${country.code}">${country.name}</option>
                            </c:forEach>
                        </optgroup>
                    </c:forEach>
                </select>
            </div>
        </c:if>

		<c:if test="${not empty cities}">
            <div class="input-field col s12">
                <select>
                    <option value="" disabled selected>Cities</option>

                    <c:forEach var="cityOrder" items="${cities}">
                        <optgroup label="${cityOrder.key}">
                            <c:forEach var="city" items="${cityOrder.value}">
                                <option value="${city.id}">${city.name}</option>
                            </c:forEach>
                        </optgroup>
                    </c:forEach>
                </select>
            </div>
        </c:if>

        <c:if test="${not empty languages}">
            <div class="input-field col s12">
                <select>
                    <option value="" disabled selected>Languages</option>

                    <c:forEach var="langOrder" items="${languages}">
                        <optgroup label="${langOrder.key}">
                            <c:forEach var="lang" items="${langOrder.value}">
                                <option value="${lang.countryCode}_${lang.language}">${lang.language}</option>
                            </c:forEach>
                        </optgroup>
                    </c:forEach>
                </select>
            </div>
        </c:if>

	</jsp:attribute>
</t:template>