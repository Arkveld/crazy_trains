package fr.org.projetfinal.metier;

import java.util.List;

import fr.org.projetfinal.model.Question;

public interface IQuestionMetier {
	
	public List<Question> findAllQuestion() throws Exception;

}
