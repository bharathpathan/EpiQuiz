package fr.epita.epiquiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epita.epiquiz.model.Question;
import fr.epita.epiquiz.services.HttpServices;

/**
 * Servlet implementation class MakeQuizServlet
 */

public class MakeQuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MakeQuizServlet() {
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
		HttpServices hs = new HttpServices();
		final Logger LOGGER = LogManager.getLogger(MakeQuizServlet.class);
		//System.out.println(request.getParameter("edit"));
		
		
		
		if (request.getParameter("edit") != null) {  
			//System.out.println("clicked edit!!!!");
			Question q = hs.getQuesById(request.getParameter("edit"));
			request.getSession().setAttribute("question", q);
			
			response.sendRedirect("updateque.jsp");
		}
		
		if (request.getParameter("delete") != null) {  
			/*if(hs.deleteQuestion(request.getParameter("delete")))
			System.out.println("clicked delete");*/
			List<Question> quesList = new ArrayList<Question>();
			HashMap<Long,Question>  quesMap = (HashMap<Long,Question>) hs.getQues();
			for (HashMap.Entry<Long, Question> ques : quesMap.entrySet())
			{
				quesList.add(ques.getValue());
			}
			request.getSession().setAttribute("quesList", quesList);
			request.getSession().setAttribute("quesMap", quesMap);
			response.sendRedirect("makeQuiz.jsp");
		}
		
		
		
		
		
		if (request.getParameter("make") != null) {  
		String qName =  request.getParameter("quizName");
		Long qId = Long.valueOf(request.getParameter("quizID"));
		
		
		Long qMarks =  Long.valueOf( request.getParameter("quizMarks"));
		System.out.println(qId+"<--->"+qMarks);
		
		//HashMap<Long,Question> quesList = (HashMap<Long,Question>) request.getSession().getAttribute("quesMap");
		
		List<Question> selectedQues = new ArrayList<Question>();
		String[] checked = request.getParameterValues("quesSelection");
		/*if(request.getParameterValues("checked").equals(null))
		{
			PrintWriter out = response.getWriter();
		    out.println("<html><body>");
		    out.println("<script type=\"text/javascript\">");
		    out.println("var popwin = window.open(\"pageA.jsp\")");
		    out.println("setTimeout(function(){ popwin.close(); window.location.href='optionerror.jsp';},5000)");
		    out.println("</script>");
		    out.println("</body></html>");
		}
		else {*/
		System.out.println(checked.length);
		System.out.println(qId+"---"+qName+"---"+qMarks);
		String quesIds="";
		
		for (int i = 0; i < checked.length; i++) {
			
			
		    quesIds = quesIds+","+checked[i];
		    
		}
		
		hs.addQuiz(qName, quesIds, qId, qMarks);
		request.getRequestDispatcher("adminhome.jsp").forward(request, response);
		//}
	}
	}
	
	

}
