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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>Journey Overview</h1>
                </div>
            </div>
        </nav>
         <div class="container">       
            <div class="row">
                <p>Here is a list of all the bookings you have completed!</p>
                <br/>
                <form method="POST" action="DisplayInvoice.do">
                    ${table}
                    <button class="btn" name="button" type="submit" value="View Invoice">View Invoice</button>
                </form>
            </div>
         </div>
    </body> 
</html>
