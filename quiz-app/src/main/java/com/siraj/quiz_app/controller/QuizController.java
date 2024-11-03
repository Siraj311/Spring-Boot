package com.siraj.quiz_app.controller;

import com.siraj.quiz_app.model.Question;
import com.siraj.quiz_app.model.QuestionWrapper;
import com.siraj.quiz_app.model.Response;
import com.siraj.quiz_app.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("quiz")
public class QuizController {

    QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
        try {
            return new ResponseEntity<>(quizService.createQuiz(category, numQ, title), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>("Unsuccess", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(quizService.getQuizQuestions(id) , HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses) {
        try {
            return new ResponseEntity<>(quizService.calculateResult(id, responses), HttpStatus.OK);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(-1, HttpStatus.BAD_REQUEST);
    }

}
