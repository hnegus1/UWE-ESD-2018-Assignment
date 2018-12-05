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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>Confirm</h1>
                </div>
            </div>
        </nav> 
        <div class="container">       
            <div class="row"> 
                <p>The journey from ${origin} to ${destination} will be ${distance} miles and will cost £${price}.</p>
                <form method="POST" action="BookJourney.do">
                    <div class="form-check form-check-inline">
                        <label class="form-check-label"><p>Check if paying by card:</p></label>
                        <input class="form-check-input" type="checkbox" name="paid"><br>
                    </div>
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
                      action="ChooseCustomerBooking.jsp">
                          <input name="button" type="submit" value="Go Back"/>
            </div>
        </div>
        </form>
    </body>
</html>
