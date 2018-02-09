package fr.epita.epiquiz.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.json.JSONArray;
import org.json.JSONObject;

import fr.epita.epiquiz.model.Question;

public class Temporary {

	public static void main(String args[]) throws ClientProtocolException, IOException
	{
		
		int n = 100;
		System.out.println("my name is srikanth"+n);
		
	}
		/*HttpServices hs = new HttpServices();
		StringBuffer sb = hs.getQues();
		//System.out.println(sb);
		JSONObject explrObject = new JSONObject();
		List<Question> quesList = new ArrayList<Question>();
		
		JSONArray jsonArray = new JSONArray(sb.toString()); 
		for (int i = 0; i < jsonArray.length(); i++) {
		    explrObject = jsonArray.getJSONObject(i);
		   // System.out.println(explrObject.toString());
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
		}
		
		
		for (Question q : quesList)
		{
			System.out.println("----------------------------------------------");
			System.out.println(q.toString());
			System.out.println("----------------------------------------------");
		}
		
	}*/
	
	
}
