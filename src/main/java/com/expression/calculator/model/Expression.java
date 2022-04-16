package com.expression.calculator.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Expression {

    @Id
    private String name;
    private String expression;

    public Expression(String name, String expression) {
        this.name = name;
        this.expression = expression;
    }

    public Expression() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override public String toString() {
        return "Expression{" +
            "name='" + name + '\'' +
            ", expression='" + expression + '\'' +
            '}';
    }
}
