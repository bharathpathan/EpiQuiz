package fr.epita.EpiiQuiz.model;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/*
 * 
 * Student datamodel class
 */
@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class Student {

	  @Id
	   
	    private Long id;

	    @NotBlank
	    private String name;
	    
	    @NotBlank
	    private String score;
	    
	    @NotBlank
	    private String noofQuiz;
	    
	    @NotBlank
	    private String quizids;
	    
	  

		public String getQuizids() {
			return quizids;
		}

		public void setQuizids(String quizids) {
			this.quizids = quizids;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getScore() {
			return score;
		}

		public void setScore(String score) {
			this.score = score;
		}

		public String getNoofQuiz() {
			return noofQuiz;
		}

		public void setNoofQuiz(String noofQuiz) {
			this.noofQuiz = noofQuiz;
		}

		
	    
	    
	    
	    
	    

	
	
}
