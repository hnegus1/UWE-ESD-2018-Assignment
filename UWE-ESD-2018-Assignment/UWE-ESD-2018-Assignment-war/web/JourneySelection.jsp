<%-- 
    Document   : JourneySelection
    Created on : Nov 23, 2018, 1:21:03 PM
    Author     : Nikolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Journey selection</title>
    </head>
    <body>
        <form action="ShowAvailableDrivers.do">
            ${table}
            <button type="submit"name="submit"value="submit">Select route</button>
        </form>
    </body>
</html>
