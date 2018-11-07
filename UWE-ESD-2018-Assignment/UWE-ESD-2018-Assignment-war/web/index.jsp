<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Alpha Taxi</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <!-- Redirects to the start up servlet on start up -->
        <%
            String redirectURL = "http://localhost:8080/UWE-ESD-2018-Assignment-war/MainMenu";
            response.sendRedirect(redirectURL);
        %>
    </body>
</html>



