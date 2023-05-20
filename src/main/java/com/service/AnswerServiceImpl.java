package com.service;

import com.model.Answer;
import com.repository.AnswerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public void save(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public void update(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public Iterable<Answer> getAll() {
        return answerRepository.findAll();
    }

    @Override
    public void delete(Answer answer) {
        answerRepository.delete(answer);
    }

    @Override
    public void deleteByID(long id) {
        answerRepository.deleteById(id);
    }

    @Override
    public Optional<Answer> getById(Long id) {
        return answerRepository.findById(id);
    }

    @Override
    public long getEntityCount() {
        return answerRepository.count();
    }
}

