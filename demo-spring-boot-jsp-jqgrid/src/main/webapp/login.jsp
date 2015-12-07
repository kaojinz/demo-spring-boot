<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>login.jsp</h1>
<form action="/login" method="post">
    <div>
        <label> User Name : <input type="text" name="username" value="user" /></label>
    </div>
    <div>
        <label> Password: <input type="password" name="password" value="user" /></label>
    </div>
    <div>
        <input type="submit" value="Sign In" />
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <p>* id: user, pw: user</p>
</form>
</body>
</html>