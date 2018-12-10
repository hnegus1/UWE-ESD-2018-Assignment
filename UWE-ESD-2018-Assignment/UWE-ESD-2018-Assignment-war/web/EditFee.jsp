<%-- 
    Document   : ExtraFee
    Created on : 09-Dec-2018, 23:52:00
    Author     : Tom Pugh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Fee</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>Edit Fee</h1>
                </div>
            </div>
        </nav> 
        <form action="EditFee.do">
            <select name="fee">
                <option value="1">£1</option>
                <option value="2">£2</option>
                <option value="3">£3</option>
                <option value="4">£4</option>
                <option value="5">£5</option>
            </select>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
