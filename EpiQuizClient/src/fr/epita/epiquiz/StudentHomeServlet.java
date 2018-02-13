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
import fr.epita.epiquiz.model.Quiz;
import fr.epita.epiquiz.model.Student;
import fr.epita.epiquiz.services.HttpServices;

/**
 * Servlet implementation class StudentHomeServlet
 */

public class StudentHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentHomeServlet() {
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
		if (request.getParameter("participate") != null) {
			//System.out.println("inside participate");
			List<Quiz> quizList =(List<Quiz>) hs.getQuiz();
			//System.out.println(quizList.size());
			
			
			request.getSession().setAttribute("quizList", quizList);
			response.sendRedirect("selectquiz.jsp");
	
					
				}
		if (request.getParameter("view") != null) {
			//System.out.println("inside participate");
			List<Student> quizList = new ArrayList<Student>();
					//System.out.println(request.getSession().getAttribute("id").toString());
			Student stud = hs.getStudent(request.getSession().getAttribute("id").toString());
			
			quizList.add(stud);
			//System.out.println(quizList.size());
			
			
			request.getSession().setAttribute("studList", quizList);
			response.sendRedirect("results.jsp");
	
					
				}
		if (request.getParameter("oView") != null) {
			//System.out.println("inside participate");
			 //= new ArrayList<Student>();
				//	System.out.println(request.getSession().getAttribute("id").toString());
					List<Student> quizList = hs.getAllStudents();
			
			//quizList.add(stud);
			//System.out.println(quizList.size());
			
			
			request.getSession().setAttribute("studList", quizList);
			response.sendRedirect("results.jsp");
	
					
				}
	}

}
