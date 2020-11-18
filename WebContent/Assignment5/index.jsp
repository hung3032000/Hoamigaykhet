<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WidgetSite</title>
</head>
<body>
	<%
		String quantity = request.getParameter("quantity");
	if (quantity == null) {
		quantity = "1";
	}
	String quantityError = (String) request.getAttribute("quantityError");
	if (quantityError == null) {
		quantityError = "";
	}

	String cusName = request.getParameter("customerName");
	if (cusName == null) {
		cusName = "";
	}
	String cusNameError = (String) request.getAttribute("customerNameError");
	if (cusNameError == null) {
		cusNameError = "";
	}

	String cusPhone = request.getParameter("customerPhone");
	if (cusPhone == null) {
		cusPhone = "";
	}
	String cusPhoneError = (String) request.getAttribute("customerPhoneError");
	if (cusPhoneError == null) {
		cusPhoneError = "";
	}

	String cusEmail = request.getParameter("customerEmail");
	if (cusEmail == null) {
		cusEmail = "";
	}
	String cusEmailError = (String)request.getAttribute("customerEmailError");
	if(cusEmailError == null)
	{
		cusEmailError="";
	}
	
	String cusCredit = request.getParameter("customerCredit");
	if (cusCredit == null) {
		cusCredit = "";
	}
	String cusCreditError = (String) request.getAttribute("customerCreditError");
	if (cusCreditError == null) {
		cusCreditError = "";
	}

	String monthSelected = request.getParameter("expirationMonth");
	if (monthSelected == null) {
		monthSelected = "1";
	}
	String yearSelected = request.getParameter("expirationYear");
	if (yearSelected == null) {
		yearSelected = "2008";
	}
	String cardDateError = (String)request.getAttribute("cardDateError");
	if (cardDateError == null) {
		cardDateError = "";
	}
	
	
	String processor=request.getParameter("processor");
	if(processor==null)
	{
		processor="Celeron D";
	}
	String processorError=(String)request.getAttribute("processorError");
	if(processorError ==null)
	{
		processorError="";
	}
	
	String[] peripherals = request.getParameterValues("listname");
	String peripheralsError = (String)request.getAttribute("peripheralsError");
	if(peripheralsError == null)
	{
		peripheralsError = "";
	}
	String monitor = request.getParameter("monitor");
	%>
	
	
	<%!
	public boolean find(String[] list, String target)
	{
		if(list==null)
		{
			return false;
		}
		for(int i=0;i<list.length;i++)
		{
			if(target.equals(list[i]))
			{
				return true;
			}
		}
		return false;
	}
	
	%>
	






	<form action="${pageContext.request.contextPath}/baitap5" method="GET">
		<h1>Enter Your Information</h1>
		<table>
			<tr>
				<td>Number of purchase: 
				<br>(at least 1)
				</td>
				<td><input type="text" name="quantity" value="<%=quantity%>">* <%=quantityError%>
				</td>
			</tr>
			<tr>
				<td>Your name:</td>
				<td><input type="text" name="customerName" value="<%=cusName%>">* <%=cusNameError%>
				</td>
			</tr>
			<tr>
				<td>Your phone: <br>(in format xxx-xxx-xxxx)

				</td>

				<td><input type="text" name="customerPhone" value="<%=cusPhone%>">* <%=cusPhoneError%>
				</td>
			</tr>


			<tr>
				<td>Your email:</td>

				<td><input type="text" name="customerEmail" value="<%=cusEmail%>">(optional) <%=cusEmailError %>
				</td>
			</tr>
			<tr>
				<td>Number Credit Information:</td>
				<td><input type="text" name="customerCredit" value="<%=cusCredit%>"> <%=cusCreditError%>
				</td>
			</tr>
		</table>
		<p>
			Expiration Date: <select name="expirationMonth">
				<%
					for (int month = 1; month <= 12; month++) {
				%>
				<option value="<%=month%>" <% if(monthSelected.equals(month+"")) {%> selected <%} %>> <%=month%></option>
				<%
					}
				%>
			</select> 
			<select name="expirationYear">
				<%
					for (int year = 2008; year <= 2021; year++) {
				%>
				<option value="<%=year%>" <% if(yearSelected.equals(year+"")) {%> selected <%} %>> <%=year%></option>
				<%
					}
				%>
			</select>
			<%=cardDateError%>
		</p>
		<table>
			<tr>
				<th>Processor</th>
				<th>Accessories</th>
			</tr>
			<tr>
				<td><input type="radio" name="processor" value="Celeron D" <%if(processor.equals("Celeron D")) {%>checked<%} %>> Celeron D<br> 
				<input type="radio" name="Processor" value="Pentium TV" <%if(processor.equals("Pentium TV")) {%>checked<%} %>> Pentium TV <br> 
				<input type="radio" name="Processor" value="Pentium D" <%if(processor.equals("Pentium D")) {%>checked<%} %>> Pentium D <br></td>
				<td><input type="checkbox" name="monitor" <%if(monitor!=null) {%> checked <%} %> > Monitor <br>
					<select name="listname" size="3" multiple>
						<option value="Camera" <%if(find(peripherals,"Camera")) {%>selected<%} %>>Camera</option>
						<option value="Printer" <%if(find(peripherals,"Printer")) {%>selected<%} %>>Printer</option>
						<option value="Scanner" <%if(find(peripherals,"Scanner")) {%>selected<%} %>>Scanner</option>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="Configure">
	</form>
</body>
</html>