package fr.epita.epiquiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String qName =  request.getParameter("quizName");
		Long qId = Long.valueOf(request.getParameter("quizID"));
		
		
		Long qMarks =  Long.valueOf( request.getParameter("quizMarks"));
		System.out.println(qId+"<--->"+qMarks);
		
		//HashMap<Long,Question> quesList = (HashMap<Long,Question>) request.getSession().getAttribute("quesMap");
		
		List<Question> selectedQues = new ArrayList<Question>();
		String[] checked = request.getParameterValues("quesSelection");
		System.out.println(checked.length);
		System.out.println(qId+"---"+qName+"---"+qMarks);
		String quesIds="";
		
		for (int i = 0; i < checked.length; i++) {
			
			
		    quesIds = quesIds+","+checked[i];
		    
		}
		
		hs.addQuiz(qName, quesIds, qId, qMarks);
	}

}
