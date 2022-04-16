package com.expression.calculator;

import com.expression.calculator.model.Expression;
import com.expression.calculator.repository.ExpressionRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class controller {

    @Autowired ExpressionRepository expressionRepository;

    @PostMapping("/expressions")
    public ResponseEntity<Iterable<Expression>> createExpression(@RequestBody Expression expression) {
        Expression newExpression = expressionRepository.save(expression);
        System.out.println(newExpression);
        Iterable<Expression> savedExpressions = expressionRepository.findAll();
        return new ResponseEntity<>(savedExpressions, HttpStatus.OK);
    }

    @PostMapping("/{expressionName}/calculations")
    public ResponseEntity<Object> evaluate(@PathVariable String expressionName) {
        Optional<Expression> expressionOptional = expressionRepository.findById(expressionName);
        System.out.println(expressionName);
        if(expressionOptional.isPresent()) {
            System.out.println(expressionOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
