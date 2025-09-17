<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
        <h2>Result : <%= session.getAttribute("result") %> using Session Variable</h2>
        <h2>Result : ${result} using JSTL</h2>


    </body>
</html>