package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;


@SpringBootApplication
public class Application { //Для запуска локального сервера, интернет не нужен.

    public static void main(String[] args) {
        SpringApplication.run(Application.class);



//        for (int i=0; i<1000; i++){
//            int randomNumber = (int) (Math.random()*10+1);
//
//            System.out.println("Случайное число: " + randomNumber);
//        }

    }
}
