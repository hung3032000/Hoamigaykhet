package ute.assignment5;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet5
 */
@WebServlet("/baitap5")
public class servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "";
        String quantity = request.getParameter("quantity").trim();
        int quatityNumber = 0;
        if (quantity.equals("")) {
            url = "/Assignment5/index.jsp";
            request.setAttribute("quantityError", "Bạn phải nhập số lượng");
        } else {
            try {
                quatityNumber = Integer.parseInt(quantity);
                if (quatityNumber <= 0) {
                    request.setAttribute("quantityError", "Bạn phải nhập ít nhất 1");
                    url = "/Assignment5/index.jsp";
                }
            } catch (NumberFormatException e) {
                request.setAttribute("quantityError", "Vui lòng nhập 1 chữ số");
                url = "/Assignment5/index.jsp";
            }
        }

        String cusName = request.getParameter("customerName").trim();
        if (cusName.equals("")) {
            url = "/Assignment5/index.jsp";
            request.setAttribute("customerNameError", "Bạn phải nhập tên ");
        }
        String cusPhone = request.getParameter("customerPhone").trim();
        Pattern phonePattern = Pattern.compile("(\\d\\D*){10}");
        Matcher phoneMatcher = phonePattern.matcher(cusPhone);
        if (!phoneMatcher.matches()) {
            url = "/Assignment5/index.jsp";
            request.setAttribute("customerPhoneError", "Số điện thoại phải có 10 số");
        }

        String cusEmail = request.getParameter("customerEmail").trim();
        Pattern mailPattern = Pattern.compile("\\w+@\\w+(.\\w+)*");
        Matcher cusMatcher = mailPattern.matcher(cusEmail);
        if (!cusMatcher.matches()) {
            url = "/Assignment5/index.jsp";
            request.setAttribute("customerEmailError", "Bạn phải điền email theo mẫu abc@xyz");
        }

        String cusCredit = request.getParameter("customerCredit").trim();
        Pattern creditPattern = Pattern.compile("\\d{16}");
        Matcher credMatcher = creditPattern.matcher(cusCredit);
        if (!credMatcher.matches()) {
            url = "/Assignment5/index.jsp";
            request.setAttribute("customerCreditError", "Thẻ tín dụng phải tối thiểu 16 số");
        }

        GregorianCalendar calendar = new GregorianCalendar();
        int yearNow = calendar.get(Calendar.YEAR);
        int monthNow = calendar.get(Calendar.MONTH);
        String creditCardYear = request.getParameter("expirationMonth");
        String creditCardMonth = request.getParameter("expirationYear");
        if (Integer.parseInt(creditCardYear) <= yearNow && Integer.parseInt(creditCardMonth) < monthNow) {
            request.setAttribute("cardDateError", "Thẻ bạn đã hết hạn");
            url = "/Assignment5/index.jsp";
        }
        String[] peripherals = request.getParameterValues("listname");
        if (peripherals == null) {
            url = "/Assignment5/index.jsp";
            request.setAttribute("peripheralsError", "Bạn phải chọn ít nhất là 1 trong 3 món");
        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
