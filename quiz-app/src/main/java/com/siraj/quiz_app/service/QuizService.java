package com.siraj.quiz_app.service;

import com.siraj.quiz_app.dao.QuestionDao;
import com.siraj.quiz_app.dao.QuizDao;
import com.siraj.quiz_app.model.Question;
import com.siraj.quiz_app.model.QuestionWrapper;
import com.siraj.quiz_app.model.Quiz;
import com.siraj.quiz_app.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class QuizService {

    QuizDao quizDao;
    QuestionDao questionDao;

    public QuizService(QuizDao quizDao, QuestionDao questionDao) {
        this.quizDao = quizDao;
        this.questionDao = questionDao;
    }

    public String createQuiz(String category, int numQ, String title) {

        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizDao.save(quiz);

        return "Success";
    }

    public List<QuestionWrapper> getQuizQuestions(Integer id) {
        Optional<Quiz> quiz = quizDao.findById(id);

        List<Question> questionsFromDB = quiz.get().getQuestions();
        List<QuestionWrapper> questionsForUser = new ArrayList<>();

        for(Question q : questionsFromDB) {
            QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionsForUser.add(qw);
        }

        return questionsForUser;
    }

    public Integer calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizDao.findById(id).get();
        List<Question> questions = quiz.getQuestions();

        int right = 0;
        int i = 0;

        for(Response response : responses) {
            if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
                right++;
            }

            i++;
        }

        return right;
    }
}
