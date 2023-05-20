package com.service;

import com.model.Question;

import java.util.Optional;

public interface QuestionService {
    void save(Question question);
    Iterable<Question> getAll();
    void update(Question question);
    void delete(Question question);
    void deleteByID(long id);
    Optional<Question> getById(Long id);
    long getEntityCount();
}
