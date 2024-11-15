package fr.org.projetfinal.dao.Question;

import java.util.List;

import fr.org.projetfinal.model.Question;

public interface IQuestionDao {
	
	List<Question> getAllQuestions() throws Exception;

}
