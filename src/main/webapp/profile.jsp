<%@ page import="game.beans.BullsCows" %>
<%@ page import="game.beans.UserIdea" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Collections" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Игра Быки-Коровы</title>
    <link href="resources/design.css" rel="stylesheet" type="text/css"/>
    <script src="resources/procedure.js" type="text/javascript"></script>
</head>
<body>
<div class="info">
    <h1 align="center">Игра Быки-Коровы</h1>
</div>

<div class="center">
    <h3 id="user">
        Имя пользователя:
    </h3>
    <form class="log-out" action="rules.jsp" method="post">
        <div class="form-row">
            <input name="submit" type="submit"
                   value="The rules of the game"/>
        </div>
    </form>
    <form class="log-out" action="exit/" method="post">
        <div class="form-row">
            <input name="submit" type="submit" value="Log out"/>
        </div>
    </form>
</div>
<div class="center">
    <h3>
        Количество попыток всех пользователей в среднем:
    </h3>
</div>


<script>

</script>
<%
    BullsCows bc = (BullsCows) session.getAttribute("bullsCows");
    UserIdea idea = (UserIdea) session.getAttribute("userIdea");
    List<String> userIdea;
    session.removeAttribute("bullsCows");
    if (bc == null) {
        bc = new BullsCows(0, 0);
    }
    if (idea == null) {
        userIdea = Collections.emptyList();
    } else {
        userIdea = idea.getUserValues();
    }
    pageContext.setAttribute("bc", bc);
    pageContext.setAttribute("ideas", userIdea);
%>
<div class="game">
    <fieldset>
        <form action="user/" method="post">
            <h3 id="number">Введите число</h3>
            <input id="number" name="valueNumb" readonly
                   class="textbox" type="text"
                   onkeyup="valid()"
                   value=""/>
            <table>
                <tr>
                    <td>
                        <div form-row>
                            <input id="on" type="button" value="1"
                                   onclick="one()"/>
                        </div>
                    </td>
                    <td>
                        <div form-row>
                            <input id="tw" type="button"
                                   onclick="two()"
                                   value="2"/>
                        </div>
                    </td>
                    <td>
                        <div form-row>
                            <input id="th" type="button"
                                   onclick="three()"
                                   value="3"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div>
                            <input id="fo" type="button"
                                   onclick="four()"
                                   value="4"/>
                        </div>
                    </td>
                    <td>
                        <div>
                            <input id="fi" type="button"
                                   onclick="five()"
                                   value="5"/>
                        </div>
                    </td>
                    <td>
                        <div>
                            <input id="si" type="button"
                                   onclick="six()"
                                   value="6"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div>
                            <input id="se" type="button"
                                   onclick="seven()"
                                   value="7"/>
                        </div>
                    </td>
                    <td>
                        <div>
                            <input id="ei" type="button"
                                   onclick="eight()"
                                   value="8"/>
                        </div>
                    </td>
                    <td>
                        <div>
                            <input id="ni" type="button"
                                   onclick="nine()"
                                   value="9"/>
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <div>
                            <input id="ze" type="button" value="0"
                                   onclick="zero()"/>
                        </div>
                    </td>
                    <td>
                        <div>
                            <input type="button" onclick="clearr()"
                                   value="Clear"/>
                        </div>
                    </td>
                    <td>
                        <form action="user/" method="post">
                            <div>
                                <input id="send" type="submit"
                                       value="Send"/>
                            </div>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td id="response">
                        Ваше число:
                    </td>
                    <td>
                        <input id="response" type="text" disabled/>
                    </td>
                </tr>
                <tr>
                    <td id="response">
                        Количество быков:
                    </td>
                    <td>
                        <input id="response" type="text"
                               value="<%=bc.getBulls()%>" disabled/>
                    </td>
                </tr>
                <tr>
                    <td id="response">
                        Количество коров:
                    </td>
                    <td>
                        <input id="response" type="text"
                               value="<%=bc.getCows()%>"
                               disabled/>
                    </td>
                </tr>
                <tr>
                    <div id="resp">
                        Выши предыдущие попытки:<br/>
                        <% int i = 0;%>
                        <c:forEach items="<%=userIdea%>">
                            <c:out value="<%=userIdea.get(i)%>"/><br/>
                            <% i++;%>
                        </c:forEach>
                    </div>
                </tr>
            </table>
        </form>
    </fieldset>
</div>


</body>
</html>