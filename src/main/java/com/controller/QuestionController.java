package com.controller;

import com.model.Answer;
import com.model.Game2;
import com.model.Question;
import com.service.AnswerServiceImpl;
import com.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    QuestionServiceImpl questionServiceImpl;
    @Autowired
    AnswerServiceImpl answerServiceImpl;

    private long entityCount;
    private long randomNumber;
    private long prevQuestionNumber;

//    @GetMapping("/games")
//    public String getAllGames(Model model) {
//        Iterable<Answer> answers = answerServiceImpl.getAll();
//        Iterable<Question> games = questionServiceImpl.getAll();
//        model.addAttribute("games", games);
//        model.addAttribute("games", answers);
//        return "games";
//    }

    @GetMapping("/getQuestion")
    public ResponseEntity<String> getQuestion() {
        entityCount = questionServiceImpl.getEntityCount(); //-- Получаем количество записей в БД.
        randomNumber = (long) (Math.random()*entityCount+1);
        String question = questionServiceImpl.getById(randomNumber).get().getQuestion(); // получить вопрос из базы данных
        prevQuestionNumber = randomNumber; //--- Записать номер вопроса, для возвращения к этому вопросу после нажатия на кнопку НАЗАД.
        return new ResponseEntity<String>(question, HttpStatus.OK);
    }

    @GetMapping("/getPrevQuestion")
    public ResponseEntity<String> getPrevQuestion() {

        String question = questionServiceImpl.getById(prevQuestionNumber).get().getQuestion(); // получить вопрос из базы данных

        return new ResponseEntity<String>(question, HttpStatus.OK);
    }

    @GetMapping("/getAnswer")
    public ResponseEntity<String> getAnswer() {
        String answer = answerServiceImpl.getById(randomNumber).get().getAnswer(); // получить ответ из базы данных

        return new ResponseEntity<String>(answer, HttpStatus.OK);
    }


}

