package com.service;

import com.model.Answer;

import java.util.Optional;

public interface AnswerService {
    void save(Answer answer);
    Iterable<Answer> getAll();
    void update(Answer answer);
    void delete(Answer answer);
    void deleteByID(long id);
    Optional<Answer> getById(Long id);
    long getEntityCount();
}
