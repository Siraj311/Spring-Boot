package com.siraj.quiz_app.service;

import com.siraj.quiz_app.dao.QuestionDao;
import com.siraj.quiz_app.model.Question;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    QuestionDao questionDao;

    public QuestionService(QuestionDao questionDao) {
        this.questionDao = questionDao;
    }

    public List<Question> getAllQuestions() {
        return questionDao.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public String addQuestion(Question question) {
        questionDao.save(question);
        return "success";
    }
}
