<%-- 
    Document   : JourneySelection
    Created on : Nov 23, 2018, 1:21:03 PM
    Author     : Nikolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Journey selection</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>Select a Journey</h1>
                </div>
            </div>
        </nav>  
        <div class="container">       
            <div class="row"> 
                <form action="ShowAvailableDrivers.do">
                    ${table}
                    <button class="btn" type="submit" name="submit"value="submit">Select route</button>
                </form>
            </div>
        </div>
    </body>
</html>
