<%-- 
    Document   : ViewJourneys
    Created on : 25-Nov-2018, 19:10:31
    Author     : Isaac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Bookings</title>
    </head>
    <body>
        <h1>Journey Overview</h1>
        <p>Here is a list of all the bookings you have made!</p>
        <br/>
        <form method="POST" action="DeleteJourney.do">
            ${table}
            <input name="button" type="submit" value="Delete Booking"/>
        </form>
    </body>   
</html>
