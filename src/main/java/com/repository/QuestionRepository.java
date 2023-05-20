package com.repository;

import org.springframework.data.repository.CrudRepository;
import com.model.*;

public interface QuestionRepository extends CrudRepository<Question, Long> {

}
