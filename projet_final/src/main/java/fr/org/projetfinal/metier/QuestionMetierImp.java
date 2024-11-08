package fr.org.projetfinal.metier;

import java.util.List;

import fr.org.projetfinal.dao.IQuestionDao;
import fr.org.projetfinal.dao.QuestionDaoImp;
import fr.org.projetfinal.model.Question;

public class QuestionMetierImp implements IQuestionMetier {
	
	private IQuestionDao questionDao;
	@Override
	public List<Question> findAllQuestion() throws Exception {
		
		questionDao = new QuestionDaoImp();
		return questionDao.getAllQuestions();
				
	}

}
