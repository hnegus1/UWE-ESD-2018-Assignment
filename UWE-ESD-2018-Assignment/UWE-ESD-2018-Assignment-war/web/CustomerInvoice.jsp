<%-- 
    Document   : CustomerInvoice
    Created on : 05-Dec-2018, 17:01:04
    Author     : Isaac
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Journey Invoice</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>Journey Invoice</h1>
                </div>
            </div>
        </nav>
        <div class="container">       
            <div class="row">
                <p>Here are the details of the journey:</p>
                <br/>
                <p>This is where you went from: ${origin}</p>
                <br/>
                <p>This is where you went to: ${destination}</p>
                <br/>
                <p>This is how much it cost you: £${price}0</p>
                <br/>
                <p>This is how much it cost you (including vat): £${vat}0</p>
                <br/>
            </div>
         </div>
    </body>
</html>
