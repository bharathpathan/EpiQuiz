package fr.epita.epiquiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import fr.epita.epiquiz.services.HttpServices;

/**
 * Servlet implementation class SelectQuiz
 */

public class SelectQuiz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectQuiz() {
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
		String[] checked = request.getParameterValues("modify");
		List<Question> qid = new ArrayList<Question>();
		final Logger LOGGER = LogManager.getLogger(SelectQuiz.class);
		
		
		 Quiz quiz = new Quiz();
			for (int i = 0; i < checked.length; i++) {
						
						
					 quiz = hs.selectQuizById(Long.valueOf(checked[i]));
					 
					 
					    
					
		String ques = quiz.getQuesIds();
		//System.out.println("--->"+quiz.getQuesIds());
		Long marks=quiz.getqMarks();
		int noOfQues=0;
		List<String> quesids = Arrays.asList(ques.split(","));
		for (String s : quesids)
		{
			if(!s.equals("")) {
				noOfQues= noOfQues+1;
			//System.out.println("s--->"+s);
			qid.add(hs.getQuesById(s));
			System.out.println(qid);}
		}
		request.getSession().setAttribute("total", noOfQues);
		request.getSession().setAttribute("marks", marks);
		request.getSession().setAttribute("quiz", quiz);
		request.getSession().setAttribute("ques", qid);
		response.sendRedirect("quiz.jsp");
		
		
		
		
		
		
			}
	}

}
