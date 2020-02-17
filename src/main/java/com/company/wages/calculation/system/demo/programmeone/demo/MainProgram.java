package com.company.wages.calculation.system.demo.programmeone.demo;

public class MainProgram {

    public static void main(String[] args) {

        int multiply = calculateUsingFactory(5, 4, "multiply");
        System.out.println("计算得到答案:" + multiply);

    }


    public static int calculateUsingFactory(int a, int b, String operator) {
        Operation targetOperation = OperatorFactory
                .getOperation(operator)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Operator"));
        return targetOperation.apply(a, b);
    }

}
