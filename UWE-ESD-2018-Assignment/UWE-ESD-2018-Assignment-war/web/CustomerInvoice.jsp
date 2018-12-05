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
    </head>
    <body>
        <h1>Journey Invoice</h1>
        <p>Here are the details of the journey:</p>
        <br/>
        <p>This is where you went from: ${origin}</p>
        <br/>
        <p>This is where you went to: ${destination}</p>
        <br/>
        <p>This is how much it cost you: ${price}</p>
        <br/>
    </body>
</html>
