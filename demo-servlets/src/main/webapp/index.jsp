<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>demo-servlets application - links</title>
</head>
<body>
<h1>links:</h1>
<ol>
    <li><a href="${pageContext.request.contextPath}/hello">${pageContext.request.contextPath}/hello</a></li>
    <li><a href="${pageContext.request.contextPath}/session">${pageContext.request.contextPath}/session</a></li>
    <li><a href="${pageContext.request.contextPath}/redirect">${pageContext.request.contextPath}/redirect</a></li>
    <li><a href="${pageContext.request.contextPath}/forward">${pageContext.request.contextPath}/forward</a></li>
    <li><a href="${pageContext.request.contextPath}/forwarded.jsp">${pageContext.request.contextPath}/forwarded.jsp</a></li>
    <li><a href="${pageContext.request.contextPath}/secured">${pageContext.request.contextPath}/secured</a></li>
</ol>
</body>
</html>
