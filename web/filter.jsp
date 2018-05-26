<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String Before= (String) request.getAttribute("Before");
    String After=(String) request.getAttribute("After");
%>
<html>
<head>
    <title>display</title>
</head>
<body>
过滤后的图像：
<br>
<img src="<%=After%>" alt="1"/>
<br>
原图像：
<br>
<img src="<%=Before%>" alt="1" />

</body>
</html>