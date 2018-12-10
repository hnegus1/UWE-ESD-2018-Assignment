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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>Customer Homepage</h1>
                </div>
            </div>
        </nav>
        <div class="container">       
            <div class="row"> 
                <form method="POST"
                    action="ExistingBookings.do">
                    <button class="btn" name="button" type="submit" value="Existing Bookings">View Existing Bookings</button>
                </form>
                <br/>
                <form method="POST"
                    action="BookingForm.jsp">
                    <button class="btn" name="button" type="submit" value="Book new journey">Book New Journey</button>
                </form>
                <br/>
                <form method="POST"
                    action="CompletedBookings.do">
                    <button class="btn" name="button" type="submit" value="Completed Journeys">Completed Journeys</button>
                </form>
                <br>
                <form method="POST" action="MainMenu.jsp">
                          <button class="btn" name="button" type="submit" value="Logout">Logout</button>
                </form>
            </div>
        </div>
</html>
