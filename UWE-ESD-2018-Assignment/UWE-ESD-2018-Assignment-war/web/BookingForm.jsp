<%-- 
    Document   : BookingForm
    Created on : 14-Nov-2018, 12:07:51
    Author     : Isaac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Booking Form</title>
    </head>
    <body>
        <h1>Booking Form</h1>
        <form method="POST" name="CustomerBookingForm" action="CustomerBooking.do">    <!-- create a form  send the submitted -->                                                                      
            Name:<br>  <!-- Prints username om screen and make a new line  -->            
            <input type="text" name="Name">   <!-- creates a text field for name -->  
            <br>                                                              
            Origin Postcode<br><!--prints Origin Postcode and jumps a line  -->  
            <input type="text" name="OriginPostcode"><!--creates a field(for passwords)  -->  
            <br>
            Destination Postcode<br><!--prints Destination Postcode and jumps a line  -->  
            <input type="text" name="DestinationPostcode"><!--creates a field(for passwords)  -->  
            <br>
            Journey Date<br><!--prints Journey Date and jumps a line  -->  
            <input type="date" name="Date"><!--creates a field(for passwords)  -->  
            <br>
            Journey Time<br><!--prints Journey Time and jumps a line  -->  
            <input type="time" name="Time"><!--creates a field(for passwords)  -->  
            <br>
            Username<br><!--prints Journey Time and jumps a line  -->  
            <input type="text" name="username"><!--creates a field(for passwords)  -->  
            <br>
            Password<br><!--prints Journey Time and jumps a line  -->  
            <input type="password" name="password"><!--creates a field(for passwords)  -->  
            
            <button type=submit" name="submit" value="Book">Submit Booking</button> <!--Create button for the submit booking,type submit for the above form-->
            <!-- <button type=submit" name="submit" value="Submit">Log in</button> Create button for the submit booking,type submit for the above form-->
        </form> 
    </body>
</html>
