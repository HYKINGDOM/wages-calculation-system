package com.company.wages.calculation.system.demo.programmefour;

import com.company.wages.calculation.system.demo.programmetwo.Operator;

public class AddRule implements Rule {
    private int result;

    @Override
    public boolean evaluate(Expression expression) {
        boolean evalResult = false;
        if (expression.getOperator() == Operator.ADD) {
            this.result = expression.getX() + expression.getY();
            evalResult = true;
        }
        return evalResult;
    }

    @Override
    public Result getResult() {
        return new Result(result);
    }
}
