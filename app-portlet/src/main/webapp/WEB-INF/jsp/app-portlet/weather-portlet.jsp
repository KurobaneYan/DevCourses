<%--<%@ include file="init.jsp" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<p>Weather forecast for <c:out value="${cityName}"/>:</p>
<p>Temperate: <c:out value="${temp}"/>&#8451;,</p>
<p>Weather condition: <c:out value="${description}"/>,</p>
<p>Humidity: <c:out value="${humidity}"/>&#37;,</p>
<p>Pressure <c:out value="${pressure}"/> hPa.</p>
