<%-- 
    Document   : BookingConfirm
    Created on : 14-Nov-2018, 15:06:02
    Author     : Isaac, Harry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Booking</title>
    </head>
    <body>
        <h1>Confirm</h1>
        <p>The journey from ${origin} to ${destination} will be ${distance} miles and will cost £${price}.</p>
        <form method="POST" action="BookJourney.do">
            Check if paying by card:
            <input type="checkbox" name="paid"><br>
            <input type="hidden" name="origin" value="${origin}">
            <input type="hidden" name="destination" value="${destination}">
            <input type="hidden" name="distance" value="${distance}">
            <input type="hidden" name="price" value="${price}">
            <input type="hidden" name="date" value="${date}">
            <input type="hidden" name="time" value="${time}">
            <input type="hidden" name="customerID" value="${customerID}">
            <input type="submit" value="Confirm"/>
        </form>
        <br>
        <form method="POST"
              action="Customer.jsp">
                  <input name="button" type="submit" value="Go Back"/>
        </form>
    </body>
</html>
