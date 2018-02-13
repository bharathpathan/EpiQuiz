package fr.epita.EpiiQuiz.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
/*
 * 
 * Quiz datamodel class
 */
@Entity
@Table(name = "quiz")
@EntityListeners(AuditingEntityListener.class)
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

	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @NotBlank
	    private String qName;
	    
	    @NotNull
	    private Long qMarks;
	    
	    @NotBlank
	    private String quesIds;

		
	
}
