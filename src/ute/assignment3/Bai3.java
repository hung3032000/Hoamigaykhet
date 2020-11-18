package ute.assignment3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Bai3
 */
@WebServlet("/ass3")
public class Bai3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Bai3() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String quantity = request.getParameter("quantity").trim();
		String cusName = request.getParameter("customerName").trim();
		String cusEmail = request.getParameter("customerEmail").trim();
		String url = "";

		if (quantity.equals("") || cusName.equals("") || cusEmail.equals("")) {
			url = "/Assignment3/error.jsp";
		} else {
			double pricePerUnit = 9.95;
//			request.setAttribute("quantity", quantity);
//			request.setAttribute("customerName", cusName);
//			request.setAttribute("customerEmail", cusEmail);
			request.setAttribute("defaultCost", " " + pricePerUnit);
			int quantityInt = Integer.parseInt(quantity);
			double totalCost = quantityInt * pricePerUnit;
			request.setAttribute("totalCost", " " + totalCost);
			url = "/Assignment3/thanks.jsp";
		}
		RequestDispatcher dp = getServletContext().getRequestDispatcher(url);
		dp.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
