<%--suppress ALL --%>
<%@taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<portlet:resourceURL id="getCarPagination" var="getCarPagination" />

<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.js"></script>
<script type="text/javascript">
    function fireEvent() {
        console.log("fire eventName");
        Liferay.fire("eventName", {
            param1: "Hello",
            param2: "world"
        });
    }
</script>


<div class="btn btn-default" onclick="fireEvent()">Press This!</div>
