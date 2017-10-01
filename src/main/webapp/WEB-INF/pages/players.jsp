<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<head>
    <title>Players</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
        }
        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            border-style: solid;
            border-width: 1px;
            background-color: cornflowerblue;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 12px;
            border-style: solid;
            border-width: 1px;
            padding: 10px;
        }
    </style>
</head>
<body>
<a href="../../index.jsp">Back to main menu</a>
<br/>
<br/>

<h1>Players list</h1>

<c:if test="${!empty listOfPlayers}">
    <table class="tg">
        <tr>
            <th width="70">ID</th>
            <th width="110">NAME</th>
            <th width="110">TEAM</th>
            <th width="80">AGE</th>
            <th width="75">EDIT</th>
            <th width="75">REMOVE</th>
        </tr>
        <c:forEach items="${listOfPlayers}" var="player">
            <tr>
                <td>${player.id}</td>
                <td><a href="/playerdata/${player.id}" target="_blank">${player.name}</a></td>
                <td>${player.team}</td>
                <td>${player.age}</td>
                <td><a href= <c:url value="/update/${player.id}"/>>Edit</a></td>
                <td><a href= <c:url value="/remove/${player.id}"/>>Remove</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br/>
<br/>

<h2>Add/Update player</h2>

<c:url var="addAction" value="/players/add"/>
<form:form action="${addAction}" commandName="player">
    <table>
    <c:if test="${!empty player.name}">
        <tr>
            <td>
                <form:label path="id">
                    ID
                </form:label>
            </td>
            <td>
                <form:input path="id"/>
            </td>
        </tr>
    </c:if>
        <tr>
            <td>
                <form:label path="name">
                    Name
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="team">
                    Team
                </form:label>
            </td>
            <td>
                <form:input path="team"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="age">
                    Age
                </form:label>
            </td>
            <td>
                <form:input path="age"/>
            </td>
        </tr>
        <tr>
            <td>
                <c:if test="${!empty player.name}">
                    <input type="submit" value="Edit player"/>
                </c:if>
                <c:if test="${empty player.name}">
                    <input type="submit" value="Add player"
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
