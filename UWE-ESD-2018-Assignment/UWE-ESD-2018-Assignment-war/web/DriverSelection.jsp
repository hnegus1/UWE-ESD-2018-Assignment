<%-- 
    Document   : DriverSelection
    Created on : Nov 23, 2018, 2:56:07 PM
    Author     : Nikolas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Driver Selection</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>Select a Driver</h1>
                </div>
            </div>
        </nav>  
        <div class="container">       
           <div class="row"> 
                <form action="AssignDriver.do">
                    ${table}
                    <input type="hidden" name="JourneyID" value="${journeyID}">
                    <button class="btn" type="submit"name="submit"value="submit">Select Driver</button>
                </form>
           </div>
        </div>
    </body>
</html>
