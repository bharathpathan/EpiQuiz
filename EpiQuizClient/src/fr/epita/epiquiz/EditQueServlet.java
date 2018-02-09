package fr.epita.epiquiz;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.epita.epiquiz.model.Question;
import fr.epita.epiquiz.services.HttpServices;

/**
 * Servlet implementation class EditQueServlet
 */

public class EditQueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditQueServlet() {
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
		HttpServices hs = new HttpServices();
		
		if (request.getParameter("add") != null) {  
		String[] checked = request.getParameterValues("option");
		
		

		String answer="";
		if(checked.length>1) {
		for (int i = 0; i < checked.length; i++) {
		    System.out.println(checked[i]); 
		    answer=answer+","+checked[i];
		    System.out.println(checked.length);
		}}
		else
		{
			for (int i = 0; i < checked.length; i++) {
			  System.out.println(checked[i]); 
			    answer=checked[i];
			    System.out.println(checked.length);}
		}
		
		//bug: when ore than one option is selected it doesnt work the answer part.
		
		final String que = request.getParameter("question");
		final String tag = request.getParameter("tag");
		final String op1 = request.getParameter("option1t");
		final String op2 = request.getParameter("option2t");
		final String op3 = request.getParameter("option3t");
		final String op4 = request.getParameter("option4t");
		final String ans =request.getParameter(answer);
		
		boolean status = hs.addQues(que, op1, op2, op3, op4, ans, "no Explaination", tag);
		
		if(status)
		{
			System.out.println("successfully inserted");
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
		else
			System.out.println("Failed");
		}
		if (request.getParameter("makequiz") != null) {  
			
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
		
	}

}
