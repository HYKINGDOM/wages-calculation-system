package com.company.wages.calculation.system.demo.programmeone;

import com.company.wages.calculation.system.domain.Employee;
import com.company.wages.calculation.system.domain.EmployeeTotal;
import com.company.wages.calculation.system.util.ReaderXmlFileUtil;

import java.util.List;

import static com.company.wages.calculation.system.util.CommonUtil.doubleKeepTwoDecimalPlaces;

public class MainTest {

    public static void main(String[] args) {
        ReaderXmlFileUtil readerXmlFileUtil = new ReaderXmlFileUtil();
        List<EmployeeTotal> listMap = readerXmlFileUtil.readerXmlFile();
        double amount = 0;
        for (EmployeeTotal employeeTotal : listMap) {
            List<Employee> employeeList = employeeTotal.getEmployeeList();
            for (Employee employee : employeeList) {
                amount += calculateUsingFactory(employee.getType(), employeeTotal.getMonth(), employee);
            }
        }

        System.out.println("工资总额为:" + doubleKeepTwoDecimalPlaces(amount));
    }


    public static double calculateUsingFactory(String type, Integer month, Employee employee) {
        double employeeTestService = OperatorEmpFactory
                .getEmpWage(type).caluWageEmp(month, employee);
        return employeeTestService;
    }
}
