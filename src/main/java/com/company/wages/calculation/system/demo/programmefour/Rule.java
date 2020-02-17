package com.company.wages.calculation.system.demo.programmefour;

public interface Rule {
    boolean evaluate(Expression expression);
    Result getResult();
}

