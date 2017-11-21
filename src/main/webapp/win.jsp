<%@ page import="game.beans.UserIdea" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Игра Быки-Коровы</title>
    <link href="resources/design.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="info">
    <h1 align="center">Игра Быки-Коровы</h1>
</div>

<div class="center">
    <h3 id="user">
        Имя пользователя:
    </h3>
    <form class="log-out" action="exit/" method="post">
        <div class="form-row">
            <input name="submit" type="submit" value="Log out"/>
        </div>
    </form>
</div>

<div class="game">
    <fieldset>
        <form method="post" action="profile.jsp">
            <table>
                <tr>
                    <h3 id="win">
                        <p align="center">Ура вы победили!</p>
                        Количество
                        попыток: <%=session.getAttribute("count")%>
                        <br/>
                        Количество попыток в
                        среднем: <%=session.getAttribute("statistic")%>
                        <br/>
                    </h3>
                </tr>
                <tr>
                    <div class="form-row">
                        <input name="submit" type="submit"
                               value="Начать новую игру!"/>
                    </div>
                </tr>

            </table>
        </form>
    </fieldset>
</div>


</body>
</html>