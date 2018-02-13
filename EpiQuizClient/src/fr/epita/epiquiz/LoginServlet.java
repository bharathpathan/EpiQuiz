package fr.epita.epiquiz;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import fr.epita.epiquiz.services.HttpServices;



/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		final Logger LOGGER = LogManager.getLogger(LoginServlet.class);
		final HttpSession session = request.getSession();
		final String login = request.getParameter("usr");
		final String password = request.getParameter("pwd");
		HttpServices hs = new HttpServices();
		JSONObject explrObject = hs.getLogin(login,password);
		LOGGER.info("Logging in details",hs.getLogin(login,password));
		
		
			//System.out.println(explrObject.getInt("type"));
			if(Integer.valueOf(explrObject.getInt("type"))==1)
		{
			session.setAttribute("authenticated", true);
			request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		}
			if(Integer.valueOf(explrObject.getInt("type"))==0)
		{
			session.setAttribute("id", explrObject.getLong("id"));
			session.setAttribute("name", explrObject.getString("name"));
			LOGGER.info(session.getAttribute("name")+" has been logged in.");
			session.setAttribute("authenticated", true);
			request.getRequestDispatcher("studenthome.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
	}
		
		
		
		  
	}

}
