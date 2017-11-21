<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Игра Быки-Коровы</title>
    <link href="resources/design.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class="info" >
    <h1 align="center" >Игра Быки-Коровы</h1>
    <h4 align="center">
        <p>
            Ошибка при регистрации!<br/>
            <c:out value="Такой пользователь уже существует!"/>
            Поторите попытку чуть позже.
        </p>
    </h4>
    <form class="to-main" action="hello.jsp" method="post" >
        <div class="form-row">
            <input name="submit" value="On the main" type="submit" />
        </div>
    </form
</div>


</body>>
</html>