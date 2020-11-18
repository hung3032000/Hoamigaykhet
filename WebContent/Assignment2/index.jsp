
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment 2</title>
    </head>
    <body>
        <form Name="purchaseform" method=get action="${pageContext.request.contextPath}/hola">
        <table>
            <tr>
                <td>
                    Processor <br>
                </td>
                <td>
                     Accessories<br>
                     
                </td><!-- comment -->
            </tr><!-- comment -->
                <tr>
                    <td>
                        <input type="radio" name="processor" Value="Celeron D"/>
                        Celeron D<br>
                        <input type="radio" name="processor" Value="Pentium IV"/>
                        Pentium IV <br>
                        <input type="radio" name="processor" Value="Pentium D"/>
                        Pentium D
                    </td>
                    <td> 
                        <input type="checkbox" name="monitor"/>Monitor<br>
                        <select Name="peripherals" size="3" multiple>
                        <option value="Camera"/>Camera
                        <option value="Printer"/>Printer
                        <option value="Scanner"/>Scanner
                       </select><!-- comment -->
                    </td>  
                </tr>
               
        </table>
        <p align="left">
            <input type="submit" Value="PURCHASE">
        </p>
        </form>
    </body>
</html>
