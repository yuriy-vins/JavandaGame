package com.controller;


import com.model.Answer;
import com.model.Game2;
import com.model.Question;
import com.service.AnswerServiceImpl;
import com.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    @Autowired
    QuestionServiceImpl questionServiceImpl;
    @Autowired
    AnswerServiceImpl answerServiceImpl;

    @GetMapping("/")
    public String indexController(){
        return "index";
    }

    @GetMapping("/games")
    public String games(Model model) {
        List<Answer> answers = (List<Answer>) answerServiceImpl.getAll();
        List<Question> questions = (List<Question>) questionServiceImpl.getAll();

        List<Game2> questionAnswerWrappers = new ArrayList<>();

        // Сопоставьте вопросы и ответы в объекты Game2
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
            Answer answer = answers.get(i);
            Game2 wrapper = new Game2(question, answer);
            questionAnswerWrappers.add(wrapper);
        }

        model.addAttribute("games", questionAnswerWrappers);

        return "games";
    }

    @GetMapping("/games/save")
    public String getForms() {
        return "forms";
    }

    @GetMapping("/games/delete/{id}")
    public String showDeleteConfirmationPage(@PathVariable("id") long id, Model model) {
        Question question = questionServiceImpl.getById(id).get();
        model.addAttribute("game", question);
        return "delete";
    }

    @PostMapping("/games/delete/{id}")
    public String deleteGame(@PathVariable("id") long id) {
        questionServiceImpl.deleteByID(id);
        return "redirect:/games";
    }

    @GetMapping("/games/edit/{id}")
    public String showEditGameForm(@PathVariable("id") long id, Model model) {
        Question question = questionServiceImpl.getById(id).get();
        Answer answer = answerServiceImpl.getById(id).get();
        Game2 gameForm = new Game2();
        gameForm.setQuestion(question);
        gameForm.setAnswer(answer);
        model.addAttribute("gameForm", gameForm);
        return "edit";
    }

    @PostMapping("/games/save")
    public String saveGame(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) {
        // Создание объектов Question и Answer и сохранение их
        Answer answerObj = new Answer();
        answerObj.setAnswer(answer);

        Question questionObj = new Question();
        questionObj.setQuestion(question);
        questionObj.setAnswer(answerObj);

        answerServiceImpl.save(answerObj);
        questionServiceImpl.save(questionObj);
        return "redirect:/games";
    }


    @PostMapping("/games/update")
    public String updateGame(@ModelAttribute("game") Question question) {
        questionServiceImpl.save(question);
        return "redirect:/games";
    }
}
