<%-- 
    Document   : average
    Created on : Jun 4, 2023, 9:08:34 AM
    Author     : aalmasri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="average" method="get">
            <input type="number" name="num" /> <br>
            <input type="submit" value="Save your number"/>
        </form>
        
        <form action="average" method="get">
            <input type="submit" value="Reset your array"/>
            <input type="hidden" name="action" value="reset"/>
        </form>
        
        <h3>Average is: ${avg}</h3>
    </body>
</html>
