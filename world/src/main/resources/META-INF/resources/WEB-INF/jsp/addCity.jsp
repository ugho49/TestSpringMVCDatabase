<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/districts" var="districts_by_countryCode"/>

<t:template>
	<jsp:attribute name="content">
        <h1>Add city</h1>

        <form:form action="/addCity" modelAttribute="cityForm" method="post">

            <div class="input-field col s12">
                <form:input path="name" type="text" placeholder="Nom"/>
                <form:errors path="name" cssClass="red-text"/>
            </div>

            <div class="input-field col s12">
                <form:select path="countryCode" id="countries">
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

                <input type="radio" name="region" id="districtRadio" checked="checked">
                <label for="districtRadio">Choisir une région existante</label>

                <input type="radio" name="region" id="otherDistrictRadio">
                <label for="otherDistrictRadio">Nouvelle région</label>

            </div>

            <div class="input-field col s12">

                <form:input path="otherDistrict" id="otherDistrict" type="text" placeholder="Nouvelle Région" cssStyle="display: none"/>

                <div id="district">
                    <form:select path="district" id="districtSelect">
                        <option value="" disabled="disabled" selected="selected">Selectionner un pays pour voir ses régions</option>
                    </form:select>
                </div>

                <form:errors path="otherDistrict" cssClass="red-text"/>
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

    <jsp:attribute name="script">
        <script>
            $(document).ready(function() {

                var otherDistrictRadio = $('#otherDistrictRadio');
                var districtRadio = $('#districtRadio');

                var inputOtherDistrict = $('#otherDistrict');
                var divDistrict = $('#district');
                var inputDistrict = $('#districtSelect');
                var inputCountries = $('#countries');

                otherDistrictRadio.change(function () {
                    if($(this).is(':checked')) {
                        inputOtherDistrict.show();
                        divDistrict.hide();
                    }
                });

                districtRadio.change(function () {
                    if($(this).is(':checked')) {
                        inputOtherDistrict.hide();
                        divDistrict.show();
                    }
                });

                inputCountries.change(function () {
                    loadDistrictsByCountryCode(inputCountries.val());
                });

                function loadDistrictsByCountryCode(countryCode) {
                    var url = "${districts_by_countryCode}/" + countryCode;

                    $.get( url, function( data ) {
                        inputDistrict.find('option').remove();

                        $.each(data, function(index, district) {
                            inputDistrict.append('<option value="'+ district +'">'+ district +'</option>');
                        });

                        inputDistrict.material_select();
                    });
                }
            });
        </script>
    </jsp:attribute>
</t:template>