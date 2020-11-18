

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thanks </title>
    </head>
        <%String temp=(String)request.getAttribute("temp");
        String monitor =(String)request.getAttribute("monitor");
        String messbox =(String)request.getAttribute("messbox");
        String[] Peripherals=request.getParameterValues("peripherals");%>

        <table border="1" >
            <tr>
                <td>Processor</td>
                <td>
                    <%=temp %><br>
                    <i><%=messbox %></i>
                </td>
                
            </tr>
            <tr>
                <td>Accessories</td>
                <td>
                    <%= monitor %><br>
                </td>
                
            </tr>
        </table>
</html>
