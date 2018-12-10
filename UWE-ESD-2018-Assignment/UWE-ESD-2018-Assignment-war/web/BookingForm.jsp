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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>Booking Form</h1>
                </div>
            </div>
        </nav>  
            <div class="container">       
                <div class="row"> 
                    <form method="POST" name="CustomerBookingForm" action="CustomerBooking.do">    <!-- create a form  send the submitted -->                                                                                                                                  
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-home"></i></span>
                            <input class="form-control" placeholder="Origin Address" type="text" name="Origin"><!--creates a field(for passwords)  -->  
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-globe"></i></span>
                            <input class="form-control" placeholder="Destination Address" type="text" name="Destination"><!--creates a field(for passwords)  -->  
                        </div>
                        <br> 
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                            <input class="form-control" type="date" name="Date"><!--creates a field(for passwords)  -->  
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
                            <input class="form-control" type="time" name="Time"><!--creates a field(for passwords)  -->  
                        </div>
                        <br>
                        <button class="btn" type=submit" name="submit" value="Book">Submit Booking</button> <!--Create button for the submit booking,type submit for the above form-->
                        <!-- <button type=submit" name="submit" value="Submit">Log in</button> Create button for the submit booking,type submit for the above form-->
                    </form> 
                    <br>
                    <form method="POST" action="ChooseCustomerBooking.jsp">
                          <button class="btn" name="button" type="submit" value="Back">Back</button>
                </form>
                </div>
            </div>
    </body>
</html>
