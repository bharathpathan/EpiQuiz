package fr.epita.epiquiz.model;




public class Quiz {

	  public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getqName() {
		return qName;
	}

	public void setqName(String qName) {
		this.qName = qName;
	}

	public Long getqMarks() {
		return qMarks;
	}

	public void setqMarks(Long qMarks) {
		this.qMarks = qMarks;
	}

	public String getQuesIds() {
		return quesIds;
	}

	public void setQuesIds(String quesIds) {
		this.quesIds = quesIds;
	}


	    private Long id;

	   
	    private String qName;
	    
	
	    private Long qMarks;
	    
	
	    private String quesIds;

		
	
}
