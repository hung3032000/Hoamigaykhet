package ute.assignment2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ass2beta
 */
@WebServlet("/hola")
public class ass2beta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ass2beta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String Monitor=request.getParameter("monitor");
        String Processor=request.getParameter("processor");
        String[] Peripherals=request.getParameterValues("peripherals");
        String url="";
        String temp="";
        String monitor="";
        String messbox="";
        if(Processor !=null)
        {
            if(Processor.equals("Celeron D"))
            {
                temp="Celeron D";
                messbox="Have you considered a move powerful procsessor";
                
            }
            if(Processor.equals("Pentium IV"))
            {
                temp="Pentium IV";
                
                
            }
            if(Processor.equals("Pentium D"))
            {
               temp="Pentium D";  
            }
            if((Monitor!=null)&&(Monitor.equals("on")))
            {
                monitor="Monitor";
                for (int i=0;i<Peripherals.length;i++)
                {
                    monitor+=Peripherals[i];
                    
                 
                }
            }
            else
            {
                if (Monitor.equals("on")) {
                    monitor="Monitor";
                    for (int i=0;i<Peripherals.length;i++)
                {
                    monitor+=Peripherals[i];
                 
                }
                }
                else{
                for (int i=0;i<Peripherals.length;i++)
                {
                    monitor+=Peripherals[i];
                }
                }
            }
            request.setAttribute("temp",temp);
            request.setAttribute("monitor",monitor);
            request.setAttribute("messbox",messbox);
            url="/Assignment2/thanks.jsp";
        }
        else
        {
            url="/Assignment2/error.jsp";
        }
        RequestDispatcher dispathcher=getServletContext().getRequestDispatcher(url);
        dispathcher.forward(request,response);
    }
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
