<%-- 
    Document   : ChooseCustomerBooking
    Created on : 14-Nov-2018, 12:16:00
    Author     : Isaac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose type of Booking</title>
    </head>
    <body>
        <h1>Please choose the type of booking you wish to access:</h1>
        <form method="POST"
            action="ExistingBookings.do">
                  <input name="button" type="submit" value="Existing Bookings"/>
        </form>
        <br/>
        <form method="POST"
              action="BookingForm.jsp">
                  <input name="button" type="submit" value="Book new journey"/>
        </form>
        <br/>
        <form method="POST"
              action="CompletedBookings.do">
                  <input name="button" type="submit" value="Completed Journeys"/>
        </form>
</html>
