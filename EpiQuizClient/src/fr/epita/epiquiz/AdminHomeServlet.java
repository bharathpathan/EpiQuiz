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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import fr.epita.epiquiz.model.Question;
import fr.epita.epiquiz.model.Quiz;
import fr.epita.epiquiz.model.Student;
import fr.epita.epiquiz.services.HttpServices;

/**
 * Servlet implementation class AdminHomeServlet
 */

public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminHomeServlet() {
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
		
		final Logger LOGGER = LogManager.getLogger(AdminHomeServlet.class);
		
		HttpServices hs = new HttpServices();
		if (request.getParameter("results") != null) {
			LOGGER.info("inside results");
				List<Student> quizList = hs.getAllStudents();
			
			//quizList.add(stud);
			//System.out.println(quizList.size());
			
			
			request.getSession().setAttribute("studList", quizList);
			response.sendRedirect("results.jsp");
			request.getRequestDispatcher("results.jsp").forward(request, response);	
		}
		
		if (request.getParameter("addQues") != null) {
			LOGGER.info("inside Adding Question");
			request.getRequestDispatcher("edit_que.jsp").forward(request, response);
					
				}
		

		if (request.getParameter("addQuiz") != null) {
			LOGGER.info("inside adding quiz");
			List<Question> quesList = new ArrayList<Question>();
			HashMap<Long,Question>  quesMap = (HashMap<Long,Question>) hs.getQues();
			for (HashMap.Entry<Long, Question> ques : quesMap.entrySet())
			{
				quesList.add(ques.getValue());
			}
			List<Quiz> quizList = hs.getQuiz();
			Quiz q = quizList.get(quizList.size()-1);
			request.getSession().setAttribute("quizzid", (q.getId()+1));
			request.getSession().setAttribute("quesList", quesList);
			request.getSession().setAttribute("quesMap", quesMap);
			response.sendRedirect("makeQuiz.jsp");
		}

		
		
	}

}
