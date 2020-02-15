package com.company.wages.calculation.system.programmefour;

public interface Rule {
    boolean evaluate(Expression expression);
    Result getResult();
}

