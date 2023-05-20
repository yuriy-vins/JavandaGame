package com.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.model.Question;
import com.repository.QuestionRepository;

import java.util.Optional;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void update(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Iterable<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public void delete(Question question) {
        questionRepository.delete(question);
    }

    @Override
    public void deleteByID(long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Optional<Question> getById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public long getEntityCount() {
        return questionRepository.count();
    }
}

