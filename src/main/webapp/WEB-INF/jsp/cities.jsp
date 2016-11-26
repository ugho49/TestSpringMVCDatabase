<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Cities</h2>

<c:if test="${not empty cities}">

    <select name="city" id="">
        <c:forEach var="city" items="${cities}">
            <option value="${city.id}">${city.name}</option>
        </c:forEach>
    </select>

</c:if>
<c:if test="${empty cities}">
    <h2>No cities</h2>
</c:if>