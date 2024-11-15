package fr.org.projetfinal.dao.Question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.org.projetfinal.bdd.MyConnectionSQL;
import fr.org.projetfinal.model.Question;

public class QuestionDaoImp implements IQuestionDao {
	
	private Connection conncetion;

	@Override
	public List<Question> getAllQuestions() throws Exception {
		
		//Liste vide 
		List<Question> questions = new ArrayList<Question>();
		
		//Se connecte à la BDD
		this.conncetion = MyConnectionSQL.getInstance();
		
		//Statement et Resultset
		Statement statement = conncetion.createStatement();
		ResultSet resultset = statement.executeQuery("SELECT * FROM questions");
		
		while(resultset.next()) {
			
			Question question = new Question();
			question.setId(resultset.getInt("id"));
			question.setQuestion(resultset.getString("question"));
			
			questions.add(question);
			
		}
		
		resultset.close();
		statement.close();
		conncetion.close();
		return questions;
	}

	
}
