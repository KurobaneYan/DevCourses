<%@ include file="init.jsp" %>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<portlet:resourceURL id="getCarPagination" var="getCarPagination"/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
    function ajaxCall() {
        var pageSize = $("#pageSize").val();
        var pageNumber = $("#pageNumber").val();
        $.ajax({
            url: "<%= getCarPagination %>",
            type: "GET",
            dataType: "json",
            data: {
                <portlet:namespace/>pageSize: pageSize,
                <portlet:namespace/>pageNumber: pageNumber
            },
            success: function (data) {
                $("#cars-thead").empty().append($("<tr>").append(
                    $("<th>").text("manufacturer"),
                    $("<th>").text("model"),
                    $("<th>").text("year"),
                    $("<th>").text("price"),
                    $("<th>").text("style"),
                    $("<th>").text("left")
                ));
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
    };
</script>

<p><c:out value="${cars}"/></p>

<form>
    <input id="pageNumber" type="text" name="pageNumber" value="1"/>
    <input id="pageSize" type="text" name="pageSize" value="3"/>
    <input type="button" value="getPagination" onclick="ajaxCall()"/>
</form>

<table id="cars-table" class="table">
    <thead id="cars-thead">
    </thead>
    <tbody id="cars-tbody">
    </tbody>
</table>
