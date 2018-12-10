<%-- 
    Document   : ShowReport
    Created on : 09-Dec-2018, 23:22:33
    Author     : Harry
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <nav class="navbar navbar-static-top">
            <div class="container">
                <div class="row" style="text-align: center">
                    <h1>Report from ${startDate} to ${endDate}</h1>
                </div>
            </div>
        </nav> 
        <div class="container">       
            <div class="row">
                <p>From ${startDate} to ${endDate}, the company made £${turnover} and served ${numberOfJourneys} customers. The details of which are as follows...</p>
                ${table}
                <form method="POST" action="Admin.jsp">
                          <button class="btn" name="button" type="submit" value="Back">Back</button>
                </form>
            </div>        
        </div>
    </body>
</html>
