package com.expression.calculator.repository;

import com.expression.calculator.model.Expression;
import org.springframework.data.repository.CrudRepository;

public interface ExpressionRepository extends CrudRepository<Expression, String> {}
