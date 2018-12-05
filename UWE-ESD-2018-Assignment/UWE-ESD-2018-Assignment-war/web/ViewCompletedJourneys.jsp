<%-- 
    Document   : ViewCompletedJourneys
    Created on : 05-Dec-2018, 14:28:21
    Author     : Isaac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Completed Bookings</title>
    </head>
    <body>
        <h1>Journey Overview</h1>
        <p>Here is a list of all the bookings you have completed!</p>
        <br/>
        <form method="POST" action="DisplayInvoice.do">
            ${table}
            <input name="button" type="submit" value="View Invoice"/>
        </form>
    </body> 
</html>
