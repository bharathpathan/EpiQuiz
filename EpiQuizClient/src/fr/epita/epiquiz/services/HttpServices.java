package fr.epita.epiquiz.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import fr.epita.epiquiz.model.Question;
import fr.epita.epiquiz.model.Quiz;
import fr.epita.epiquiz.model.Student;

public class HttpServices {

	private static HttpClient client = HttpClientBuilder.create().build();
	private static final Logger LOGGER = LogManager.getLogger(HttpServices.class);
	
	
	
	public JSONObject getLogin(String usr, String pwd) throws ClientProtocolException, IOException
	{
			int type=0;
		
		String url = "http://localhost:8080/api/Users/"+usr+"/"+pwd;
		JSONObject explrObject = new JSONObject();
		
		HttpGet request1 = new HttpGet(url);
		
		
		request1.addHeader("content-type", "application/json");
		HttpResponse response1 = client.execute(request1);
		
		

		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response1.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		
		
		JSONArray jsonArray = new JSONArray(result.toString()); 
		for (int i = 0; i < jsonArray.length(); i++) {
		    explrObject = jsonArray.getJSONObject(i);
		}
		LOGGER.info("login--------"+result.toString());
		LOGGER.info(explrObject.toString());
		List<String> sl = new ArrayList<String>();
		if(explrObject.get("name").equals(usr)&&explrObject.get("password").equals(pwd)) {
			type = explrObject.getInt("type");
			return explrObject;
		}

		
		return explrObject;
	}
	
	public boolean addQues(String ques,String op1,String op2,String op3, String op4, String ans,String exp,String tag) throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/api/Ques";

		
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("User-Agent", "bharath");

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("name", "C02G8416DRJM"));
		urlParameters.add(new BasicNameValuePair("password", "pwd"));
		urlParameters.add(new BasicNameValuePair("type", "1"));
		post.addHeader("content-type", "application/json");
		
String send = "{\"question\": \""+ques+"\",\"option1\": \""+op1+"\",\"option2\":\""+op2+"\",\"option3\": \""+op3+"\",\"option4\":\""+op4+"\",\"answer\":\""+ans+"\",\"tags\" : \""+tag+"\",\"explaination\":\""+exp+"\"\r\n" + 
		"    \r\n" + 
		"}";

LOGGER.info("---"+send);
		//post.setEntity(new UrlEncodedFormEntity(send));
		post.setEntity(new StringEntity(send));

		HttpResponse response1 = client.execute(post);
		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response1.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		if(response1.getStatusLine().getStatusCode()==200)
			return true;
		else
			return false;
		
	}
	
	public HashMap<Long, Question> getQues() throws ClientProtocolException, IOException
	{
		String url = "http://localhost:8080/api/Ques";
		JSONObject explrObject = new JSONObject();
		
		HttpGet request1 = new HttpGet(url);
		
		
		request1.addHeader("content-type", "application/json");
		HttpResponse response1 = client.execute(request1);
		
		

		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response1.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		
			List<Question> quesList = new ArrayList<Question>();
			HashMap<Long,Question> quesMap = new HashMap<Long,Question>();
			
			
			JSONArray jsonArray = new JSONArray(result.toString()); 
			for (int i = 0; i < jsonArray.length(); i++) {
			    explrObject = jsonArray.getJSONObject(i);
			   // LOGGER.info(explrObject.toString());
			    Question quesObj = new Question();
			    quesObj.setId(explrObject.getLong("id"));
			    quesObj.setQuestion(explrObject.getString("question"));
			    quesObj.setAnswer(explrObject.getString("answer"));
			    quesObj.setExplaination(explrObject.getString("explaination"));
			    quesObj.setTags(explrObject.getString("tags"));
			    quesObj.setOption1(explrObject.getString("option1"));
			    quesObj.setOption2(explrObject.getString("option2"));
			    quesObj.setOption3(explrObject.getString("option3"));
			    quesObj.setOption4(explrObject.getString("option4"));
			    quesList.add(quesObj);
			    quesMap.put(explrObject.getLong("id"), quesObj);
			}
			//quesMap.put("quesList", quesList);
			return quesMap;
	}
	
	
	
	public boolean addQuiz(String qname,String quesIds,Long id,Long qmarks) throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/api/Quiz";

		
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("User-Agent", "bharath");

		
		post.addHeader("content-type", "application/json");
		
String send = "{\"qName\": \""+qname+"\",\"qMarks\":\""+qmarks+"\",\"quesIds\": \""+quesIds+"\"\r\n" + 
		"\r\n" + 
		"}";

LOGGER.info("---"+send);
		//post.setEntity(new UrlEncodedFormEntity(send));
		post.setEntity(new StringEntity(send));

		HttpResponse response1 = client.execute(post);
		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response1.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		if(response1.getStatusLine().getStatusCode()==200)
			return true;
		else
			return false;
		
	}
	
	public List<Quiz> getQuiz() throws ClientProtocolException, IOException
	{
		String url = "http://localhost:8080/api/Quiz";
		JSONObject explrObject = new JSONObject();
		
		HttpGet request1 = new HttpGet(url);
		
		
		request1.addHeader("content-type", "application/json");
		HttpResponse response1 = client.execute(request1);
		
		

		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response1.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		
			List<Quiz> quizList = new ArrayList<Quiz>();
			
			
			LOGGER.info(result.toString());
			JSONArray jsonArray = new JSONArray(result.toString()); 
			for (int i = 0; i < jsonArray.length(); i++) {
				explrObject = jsonArray.getJSONObject(i);
				   // LOGGER.info(explrObject.toString());
				    Quiz quesObj = new Quiz();
				    quesObj.setId(explrObject.getLong("id"));
				    quesObj.setqName(explrObject.getString("qName"));
				    quesObj.setqMarks(Long.valueOf(explrObject.getLong("qMarks")));
				    quizList.add(quesObj);
			}
			return quizList;
	}
	
	
	public Quiz selectQuizById(Long id) throws ClientProtocolException, IOException
	{
		String url = "http://localhost:8080/api/Quiz/"+id;
		JSONObject explrObject = new JSONObject();
		
		HttpGet request1 = new HttpGet(url);
		
		
		request1.addHeader("content-type", "application/json");
		HttpResponse response1 = client.execute(request1);
		
		

		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response1.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		
			List<Quiz> quizList = new ArrayList<Quiz>();
			
			
			LOGGER.info(result.toString());
			//JSONArray jsonArray = new JSONArray(result.toString()); 
			//
			JSONObject jso = new JSONObject(result.toString());
			LOGGER.info(jso);
			Quiz quesObj = new Quiz();
			if(!result.equals(null)) {
			//for (int i = 0; i < jsonArray.length(); i++) {
				explrObject = jso;
				LOGGER.info(explrObject);
				   // LOGGER.info(explrObject.toString());
				    
				    quesObj.setId(explrObject.getLong("id"));
				    quesObj.setqName(explrObject.getString("qName"));
				    quesObj.setqMarks(Long.valueOf(explrObject.getLong("qMarks")));
				    quesObj.setQuesIds(explrObject.getString("quesIds"));
				    quizList.add(quesObj);
			}
			return quesObj;
	}
	public Question getQuesById(String s) throws ClientProtocolException, IOException
	{
		String url = "http://localhost:8080/api/Ques/"+s;
		JSONObject explrObject = new JSONObject();
		
		HttpGet request1 = new HttpGet(url); Question quesObj = new Question();
		
		
		request1.addHeader("content-type", "application/json");
		HttpResponse response1 = client.execute(request1);
		
		

		System.out.println("Response Code : "
		                + response1.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response1.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		
			List<Question> quesList = new ArrayList<Question>();
			HashMap<Long,Question> quesMap = new HashMap<Long,Question>();
			
			LOGGER.info("--->",result.toString());
			System.out.println(result.toString());
			System.out.println(response1.toString());
			JSONObject jso = new JSONObject(result.toString());
			
			if(!result.equals(null)) {
				explrObject = jso;
			   // LOGGER.info(explrObject.toString());
			   
			    quesObj.setId(explrObject.getLong("id"));
			    quesObj.setQuestion(explrObject.getString("question"));
			    quesObj.setAnswer(explrObject.getString("answer"));
			    quesObj.setExplaination(explrObject.getString("explaination"));
			    quesObj.setTags(explrObject.getString("tags"));
			    quesObj.setOption1(explrObject.getString("option1"));
			    quesObj.setOption2(explrObject.getString("option2"));
			    quesObj.setOption3(explrObject.getString("option3"));
			    quesObj.setOption4(explrObject.getString("option4"));
			    quesList.add(quesObj);
			    quesMap.put(explrObject.getLong("id"), quesObj);
			}
			//quesMap.put("quesList", quesList);
			return quesObj;
	}
	
	public Student getStudent(String id) throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/api/Stud/"+id;
		JSONObject explrObject = new JSONObject();
		
		HttpGet request1 = new HttpGet(url);
		Student quesObj = new Student();
		
		
		request1.addHeader("content-type", "application/json");
		HttpResponse response1 = client.execute(request1);
		
		

		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response1.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			List<Student> quesList = new ArrayList<Student>();
			HashMap<Long,Question> quesMap = new HashMap<Long,Question>();
			
			LOGGER.info(result.toString());
			
			
			if(response1.getStatusLine().getStatusCode()==200) {
				JSONObject jso = new JSONObject(result.toString());
				explrObject = jso;
			   // LOGGER.info(explrObject.toString());
			   
			    quesObj.setId(explrObject.getLong("id"));
			   
			    quesObj.setName(explrObject.getString("name"));
			    quesObj.setNoofQuiz(explrObject.getString("noofQuiz"));
			    quesObj.setQuizids(explrObject.getString("quizids"));
			    quesObj.setScore(explrObject.getString("score"));
			    

			    quesList.add(quesObj);
			    
			}
			//quesMap.put("quesList", quesList);
			return quesObj;
			
			
		
	}
	public boolean addStudent(Student stud) throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/api/Stud";

		
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("User-Agent", "bharath");

		
		post.addHeader("content-type", "application/json");
		
String send = "{\"name\": \""+stud.getName()+"\",\"id\":\""+stud.getId()+"\",\"score\":\""+stud.getScore()+"\",\"noofQuiz\":\""+stud.getNoofQuiz()+"\",\"quizids\": \""+stud.getQuizids()+"\"\r\n" + 
		"    \r\n" + 
		"}";

LOGGER.info("---"+send);
		//post.setEntity(new UrlEncodedFormEntity(send));
		post.setEntity(new StringEntity(send));

		HttpResponse response1 = client.execute(post);
		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response1.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		if(response1.getStatusLine().getStatusCode()==200)
			return true;
		else
			return false;
		
	}
	
	public List<Student> getAllStudents() throws ClientProtocolException, IOException
	{
		String url = "http://localhost:8080/api/Stud";
		JSONObject explrObject = new JSONObject();
		
		HttpGet request1 = new HttpGet(url);
		
		
		request1.addHeader("content-type", "application/json");
		HttpResponse response1 = client.execute(request1);
		
		

		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(
				new InputStreamReader(response1.getEntity().getContent()));

			StringBuffer result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		
			List<Student> quizList = new ArrayList<Student>();
			
			
			LOGGER.info(result.toString());
			JSONArray jsonArray = new JSONArray(result.toString()); 
			for (int i = 0; i < jsonArray.length(); i++) {
				explrObject = jsonArray.getJSONObject(i);
				   // LOGGER.info(explrObject.toString());
				    Student quesObj = new Student();
				    quesObj.setId(explrObject.getLong("id"));
				    quesObj.setName(explrObject.getString("name"));
				    quesObj.setNoofQuiz(explrObject.getString("noofQuiz"));
				    quesObj.setQuizids(explrObject.getString("quizids"));
				    quesObj.setScore((explrObject.getString("score")));
				    quizList.add(quesObj);
			}
			return quizList;
	}


	public boolean addUser(String user, String password, String type) throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/api/Users";

		
		HttpPost post = new HttpPost(url);

		// add header
		post.setHeader("User-Agent", "bharath");

		
		post.addHeader("content-type", "application/json");
		
String send = "{\"name\": \""+user+"\",\"type\": \""+type+"\",\"password\": \""+password+"\"\r\n" + 
		"    \r\n" + 
		"}";

LOGGER.info("---"+send);
		//post.setEntity(new UrlEncodedFormEntity(send));
		post.setEntity(new StringEntity(send));

		HttpResponse response1 = client.execute(post);
		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response1.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		if(response1.getStatusLine().getStatusCode()==200)
			return true;
		else
			return false;
		
	}
	public boolean updateStudent(Student stud,String id) throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/api/Stud/"+id;

		
		HttpPut post = new HttpPut(url);

		// add header
		post.setHeader("User-Agent", "bharath");

		
		post.addHeader("content-type", "application/json");
		
String send = "{\"name\": \""+stud.getName()+"\",\"id\":\""+stud.getId()+"\",\"score\":\""+stud.getScore()+"\",\"noofQuiz\":\""+stud.getNoofQuiz()+"\",\"quizids\": \""+stud.getQuizids()+"\"\r\n" + 
		"    \r\n" + 
		"}";

LOGGER.info("---"+send);
		//post.setEntity(new UrlEncodedFormEntity(send));
		post.setEntity(new StringEntity(send));

		HttpResponse response1 = client.execute(post);
		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response1.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		if(response1.getStatusLine().getStatusCode()==200)
			return true;
		else
			return false;
		
	}
	public boolean deleteQuestion(String id) throws ClientProtocolException, IOException
	{
		String url = "http://localhost:8080/api/Ques/"+id;
		JSONObject explrObject = new JSONObject();
		
		HttpDelete request1 = new HttpDelete(url); Question quesObj = new Question();
		
		
		request1.addHeader("content-type", "application/json");
		HttpResponse response1 = client.execute(request1);
		
		

		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());
		if(response1.getStatusLine().getStatusCode()==200)
		{
			return true;
		}
		
		return false;
		
			
			//quesMap.put("quesList", quesList);
			//return quesObj;
	}
	public boolean updateQues(String id,String ques,String op1,String op2,String op3, String op4, String ans,String exp,String tag) throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/api/Ques/"+id;

		
		HttpPut post = new HttpPut(url);

		// add header
		post.setHeader("User-Agent", "bharath");

		List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
		urlParameters.add(new BasicNameValuePair("name", "C02G8416DRJM"));
		urlParameters.add(new BasicNameValuePair("password", "pwd"));
		urlParameters.add(new BasicNameValuePair("type", "1"));
		post.addHeader("content-type", "application/json");
		
String send = "{\"question\": \""+ques+"\",\"option1\": \""+op1+"\",\"option2\":\""+op2+"\",\"option3\": \""+op3+"\",\"option4\":\""+op4+"\",\"answer\":\""+ans+"\",\"tags\" : \""+tag+"\",\"explaination\":\""+exp+"\"\r\n" + 
		"    \r\n" + 
		"}";

LOGGER.info("---"+send);
		//post.setEntity(new UrlEncodedFormEntity(send));
		post.setEntity(new StringEntity(send));

		HttpResponse response1 = client.execute(post);
		LOGGER.info("Response Code : "
		                + response1.getStatusLine().getStatusCode());

		BufferedReader rd = new BufferedReader(
		        new InputStreamReader(response1.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		if(response1.getStatusLine().getStatusCode()==200)
			return true;
		else
			return false;
		
	}
	

}
