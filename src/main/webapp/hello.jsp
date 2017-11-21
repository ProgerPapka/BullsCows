<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Игра Быки-Коровы</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="shortcut icon" href="resources/ico.png" type="image/png">
    <link href="resources/design.css" rel="stylesheet" type="text/css">
    <script src="resources/procedure.js" type="text/javascript"></script>
</head>
<body>

<%
    Boolean check = (Boolean) session.getAttribute("checkAuthorize");
    if (check != null && !check) {
%>
    <script>
        alert("Такого пользователя не существует.\nПроверьте правильность ввода login/password.");
    </script>
<%
    }
%>
<div class="info">
    <h1 align="center">Игра Быки-Коровы</h1>
    <h4>
        <p>
            Эта простая на первый взгляд игрушка, однако заставит Вас
            напрячь то серое вещество, которое by default должно находиться
            внутри черепной коробки каждого человека.
        </p>
        <p>
            Она несомненно является шедевром времяубивания на лекциях,
            уроках, а теперь вот и в Интеренете.
        </p>
        <p>
            Правила игры очень просты:<br/>
            1. Компьютер загадывает четырёхзн;ачное число. Цифры в числе не
            повторяются.<br/>
            2. Вы пытаетесь это число угадать, называя наугад (и не очень)
            свои варианты загаданного числа. <br/>
            3. На каждую вашу попытку, компьютер Вам сообщает кое-что про
            соответствие между цифрами загаданного числа и вашего варианта,
            а именно - количество "быков" и "коров".<br/>
        </p>
    </h4>
</div>

<div class="registration">

    <fieldset>
        <h3 align="center">Login</h3>
        <form class="log-form" method="post" action="autorize/">
            <div class="form-row">
                <label>Login: </label>
                <input name="login" type="text" placeholder="LogIn"
                       autofocus required/>
            </div>
            <div class="form-row">
                <label>Password: </label>
                <input name="password" type="password"
                       placeholder="Password" required/>
            </div>
            <div class="form-row">
                <input name="submit" value="Log in" type="submit"/>
            </div>
        </form>
    </fieldset>

    <fieldset>
        <h3 align="center">Registration</h3>
        <form class="reg-form" action="reg/" method="post">
            <div class="form-row">
                <label>Login(Name): </label>
                <input id="log" name="login1" type="text"
                       placeholder="LogIn" required/>
            </div>
            <div class="form-row">
                <label>Password: </label>
                <input id="pas1" name="password1" type="password"
                       placeholder="Password" required/>
            </div>
            <div class="form-row">
                <label>Confirm the password: </label>
                <input id="pas2" name="password2" type="password"
                       placeholder="Password" required/>
            </div>
            <div class="form-row">
                <input type="submit" value="Sign up" onclick="reg()"/>
            </div>
        </form>
    </fieldset>

</div>


</body>
</html>