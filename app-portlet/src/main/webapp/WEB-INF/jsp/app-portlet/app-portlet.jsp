<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL id="getCarPagination" var="getCarPagination" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
    function getCars(pageNumber) {
        var pageSize = 10;
        $.ajax({
            url: "<%= getCarPagination %>",
            type: "GET",
            dataType: "json",
            data: {
                pageSize: pageSize,
                pageNumber: pageNumber
            },
            success: function (data) {
                $("#cars-tbody").empty();
                $.each(data, function (i, car) {
                    $("<tr>").append(
                        $("<td>").text(car.manufacturer),
                        $("<td>").text(car.model),
                        $("<td>").text(car.productionYear),
                        $("<td>").text(car.price),
                        $("<td>").text(car.bodyStyle),
                        $("<td>").text(car.amountLeft)
                    ).appendTo("#cars-tbody");
                });
            }
        });
    }

    Liferay.on("eventName", function (event) {
        alert("Got'em");
        alert(event);
    });
</script>

<table id="cars-table" class="table">
    <thead id="cars-thead">
        <tr>
            <th>Manufacturer</th>
            <th>Model</th>
            <th>Year</th>
            <th>Price</th>
            <th>Style</th>
            <th>Amount left</th>
        </tr>
    </thead>
    <tbody id="cars-tbody">
        <c:forEach var="car" items="${cars}">
                <tr>
                    <td><c:out value="${car.manufacturer}" /></td>
                    <td><c:out value="${car.model}" /></td>
                    <td><c:out value="${car.productionYear}" /></td>
                    <td><c:out value="${car.price}" /></td>
                    <td><c:out value="${car.bodyStyle}" /></td>
                    <td><c:out value="${car.amountLeft}" /></td>
                </tr>
        </c:forEach>
    </tbody>
</table>

<form>
    <c:forEach var="i" begin="1" end="${count}">
        <div class="btn btn-default" value="${i}" onclick="getCars(${i})">${i}</div>
    </c:forEach>
</form>
