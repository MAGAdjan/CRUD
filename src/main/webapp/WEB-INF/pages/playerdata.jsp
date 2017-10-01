<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>

<html>
<head>
    <title>Player details</title>

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
<h1>Player details</h1>
<br/>
<table class="tg">
    <tr>
       <th width="70">ID</th>
       <th width="120">NAME</th>
       <th width="120">TEAM</th>
       <th width="80">AGE</th>
    </tr>
    <tr>
        <td>${player.id}</td>
        <td>${player.name}</td>
        <td>${player.team}</td>
        <td>${player.age}</td>
    </tr>
</table>
</body>
</html>
