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
import fr.epita.epiquiz.model.Student;
import fr.epita.epiquiz.services.HttpServices;

/**
 * Servlet implementation class QuizServlet
 */

public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServlet() {
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
		final Logger LOGGER = LogManager.getLogger(QuizServlet.class);
		HttpServices hs = new HttpServices();
		Quiz quiz= (Quiz)request.getSession().getAttribute("quiz");	
		Long marks= (Long)request.getSession().getAttribute("marks");
		int total= (Integer)request.getSession().getAttribute("total");
		double tscore = Double.valueOf(marks)/Double.valueOf(total);
		double score=0;
		String answer="";
		String[] checked = request.getParameterValues("option");
		for (int i = 0; i < checked.length; i++) {
			 
			    answer=checked[i];
			  
		
		List<String> quesids = Arrays.asList(answer.split(","));
		
		
			Long qid = Long.valueOf(quesids.get(0));
			String choice = quesids.get(1);
			
			
			if(!quesids.isEmpty()) {
				
			
			List<Question> listQues= (List<Question>)request.getSession().getAttribute("ques");
			for(Question q : listQues)
			{
				if(q.getId()==qid)
				{
					if(choice.equals(q.getAnswer()))
					{
						//System.out.println("Id-->"+q.getId());
						score=score+tscore;
						//System.out.println("Present Score : "+score);
					}
					else {
						//System.out.println("wrong ans");
					}
				}
			}
			
			
			
		}
			
	}
		LOGGER.info("Total : "+marks);
		LOGGER.info("tScore is : "+tscore);
		LOGGER.info("Score is : "+score);
		Student stud = hs.getStudent(request.getSession().getAttribute("id").toString());
		Student update = new Student();
		update.setId(stud.getId());
		update.setName(stud.getName());
		update.setNoofQuiz(""+Integer.valueOf(stud.getNoofQuiz())+1);
		update.setScore(""+(Double.valueOf(stud.getScore())+score));
		update.setQuizids(stud.getQuizids()+","+quiz.getId());
		if(hs.updateStudent(update, update.getId().toString()))
		{
			List<Student> quizList = new ArrayList<Student>();
			//System.out.println(request.getSession().getAttribute("name").toString());
			Student stud1 = hs.getStudent(request.getSession().getAttribute("id").toString());
			
			quizList.add(stud1);
			System.out.println(quizList.size());
			request.getSession().setAttribute("studList", quizList);
			response.sendRedirect("results.jsp");
		}
	if(stud.getId()==null)
	{
		Student student = new Student();
		student.setId(Long.valueOf(request.getSession().getAttribute("id").toString()));
		student.setName(request.getSession().getAttribute("name").toString());
		student.setNoofQuiz("1");
		student.setQuizids(""+quiz.getId());
		student.setScore(""+score);
		hs.addStudent(student);
		List<Student> quizList = new ArrayList<Student>();
		//System.out.println(request.getSession().getAttribute("name").toString());
		Student stud1 = hs.getStudent(request.getSession().getAttribute("id").toString());
		
		quizList.add(stud1);
		//System.out.println(quizList.size());
		
		
		request.getSession().setAttribute("studList", quizList);
		response.sendRedirect("results.jsp");
		
	}
	
	
	}

}
