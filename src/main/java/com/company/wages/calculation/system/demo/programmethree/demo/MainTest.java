package com.company.wages.calculation.system.demo.programmethree.demo;

public class MainTest {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(new AddCommand(3, 7));
        System.out.println("计算所得结果:" + result);
    }


}
