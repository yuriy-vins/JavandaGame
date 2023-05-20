package com.controller;

import com.model.Game;
import com.model.Question;
import com.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class ControllerRest {

    @Autowired
    QuestionServiceImpl gameServiceImpl;

    @GetMapping("gamelist")
    public Iterable<Question> getGames(){

        Iterable<Question> gameList = gameServiceImpl.getAll();

        return gameList;
    }

}
