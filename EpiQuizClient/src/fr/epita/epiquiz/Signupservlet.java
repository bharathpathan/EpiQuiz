package fr.epita.epiquiz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import fr.epita.epiquiz.services.HttpServices;

/**
 * Servlet implementation class Signupservlet
 */

public class Signupservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signupservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		final HttpSession session = request.getSession();
		final String login = request.getParameter("usr");
		final String password = request.getParameter("pwd");
		HttpServices hs = new HttpServices();
		String checked = "";
		try {
			checked = request.getParameter("admin").toString();
		}
		catch(NullPointerException e) {
			checked="";
		}
		//System.out.println(checked);
		String type = "";
		
	
		if(checked.equals("admin"))
		{
			type="1";
		}
		else
		{
			type="0";
		}
		if(hs.addUser(login, password, type))
		{
			
				
				
				request.getRequestDispatcher("login.jsp").forward(request, response);
			
			
		}
		else
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
			
	}

}
